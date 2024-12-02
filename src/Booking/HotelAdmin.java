package Booking;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Hotel.Room;
import Hotel.Room.RoomType;
public class HotelAdmin {
    private List<Room> rooms;
    private List<Booking> bookings;

    public HotelAdmin() {
        rooms = new ArrayList<>();
        bookings = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
        System.out.println("Room added: " + room);
    }

    public void updateRoom(String roomId, Room newRoom) {
        for (int i = 0; i < rooms.size(); i++) {
            Room room = rooms.get(i);
            if (room.getId().equals(roomId)) {
                rooms.set(i, newRoom);
                System.out.println("Room updated: " + newRoom);
                return;
            }
        }
        System.out.println("Room not found with ID: " + roomId);
    }

    public void removeRoom(String roomId) {
        rooms.removeIf(room -> room.getId().equals(roomId));
        System.out.println("Room removed with ID: " + roomId);
    }

    public boolean bookRoom(int guestId, int bookerId, Room.RoomType roomType, Date dateIn, Date dateOut) {
        // Check room availability
        Room availableRoom = null;
        for (Room room : rooms) {
            if (room.getRoomType() == roomType && room.getNumberOfRooms() > 0) {
                availableRoom = room;
                break;
            }
        }

        if (availableRoom == null) {
            System.out.println("No available rooms of this type.");
            return false;
        }

        // Book the room
        availableRoom.reduceAvailableRooms();

        // Create GuestStay and Booking
        GuestStay guestStay = new GuestStay(guestId, bookerId, roomType, dateIn, dateOut);
        Booking booking = findOrCreateBooking(bookerId);
        booking.addGuestStay(guestStay);

        System.out.println("Booking successful. " + guestStay);
        return true;
    }

    private Booking findOrCreateBooking(int bookerId) {
        for (Booking booking : bookings) {
            if (booking.getBookerId() == bookerId) {
                return booking;
            }
        }

        Booking newBooking = new Booking(bookerId);
        bookings.add(newBooking);
        return newBooking;
    }

    public void displayRooms() {
        if (rooms.isEmpty()) {
            System.out.println("No rooms available.");
        } else {
            for (Room room : rooms) {
                System.out.println(room);
            }
        }
    }

    public void displayBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings available.");
        } else {
            for (Booking booking : bookings) {
                System.out.println(booking);
            }
        }
    }

    // Add room to database and in-memory list
    public void adDRoom(Room room) {
        String query = "INSERT INTO Room (id, roomImage, pricePerNight, roomType, numberOfRooms) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, room.getId());
            preparedStatement.setString(2, room.getRoomImage());
            preparedStatement.setDouble(3, room.getPricePerNight());
            preparedStatement.setString(4, room.getRoomType().name());
            preparedStatement.setInt(5, room.getNumberOfRooms());

            preparedStatement.executeUpdate();
            rooms.add(room); // Update in-memory cache
            System.out.println("Room added to database and memory: " + room);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update room details in database
    public void updatERoom(String roomId, Room newRoom) {
        String query = "UPDATE Room SET roomImage = ?, pricePerNight = ?, roomType = ?, numberOfRooms = ? WHERE id = ?";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, newRoom.getRoomImage());
            preparedStatement.setDouble(2, newRoom.getPricePerNight());
            preparedStatement.setString(3, newRoom.getRoomType().name());
            preparedStatement.setInt(4, newRoom.getNumberOfRooms());
            preparedStatement.setString(5, roomId);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Room updated in database: " + newRoom);
            } else {
                System.out.println("Room with ID " + roomId + " not found in database.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Remove room from database
    public void removERoom(String roomId) {
        String query = "DELETE FROM Room WHERE id = ?";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, roomId);
            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                rooms.removeIf(room -> room.getId().equals(roomId)); // Update in-memory cache
                System.out.println("Room with ID " + roomId + " removed from database and memory.");
            } else {
                System.out.println("Room with ID " + roomId + " not found in database.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public boolean BooKRoom(int guestId, int bookerId, Room.RoomType roomType, Date dateIn, Date dateOut) {
        String findRoomQuery = "SELECT id, pricePerNight, numberOfRooms FROM Room WHERE roomType = ? AND numberOfRooms > 0";
        String updateRoomQuery = "UPDATE Room SET numberOfRooms = numberOfRooms - 1 WHERE id = ?";
        String insertBookingQuery = "INSERT INTO Booking (bookerId, totalAmount) VALUES (?, ?) ON DUPLICATE KEY UPDATE totalAmount = totalAmount + ?";
        String insertGuestStayQuery = "INSERT INTO GuestStay (guestId, bookerId, roomType, dateIn, dateOut, nightsSpent, amountToPay) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DataBaseConnection.getConnection()) {
            // Check room availability
            PreparedStatement findRoomStmt = connection.prepareStatement(findRoomQuery);
            findRoomStmt.setString(1, roomType.name());
            ResultSet roomResult = findRoomStmt.executeQuery();

            if (!roomResult.next()) {
                System.out.println("No available rooms of this type.");
                return false;
            }

            String roomId = roomResult.getString("id");
            double pricePerNight = roomResult.getDouble("pricePerNight");
            int numberOfRooms = roomResult.getInt("numberOfRooms");

            // Calculate stay details
            long diffInMillis = dateOut.getTime() - dateIn.getTime();
            int nightsSpent = (int) (diffInMillis / (1000 * 60 * 60 * 24));
            double amountToPay = nightsSpent * pricePerNight;

            // Book the room (reduce availability)
            PreparedStatement updateRoomStmt = connection.prepareStatement(updateRoomQuery);
            updateRoomStmt.setString(1, roomId);
            updateRoomStmt.executeUpdate();

            // Insert or update booking
            PreparedStatement insertBookingStmt = connection.prepareStatement(insertBookingQuery);
            insertBookingStmt.setInt(1, bookerId);
            insertBookingStmt.setDouble(2, amountToPay);
            insertBookingStmt.setDouble(3, amountToPay);
            insertBookingStmt.executeUpdate();

            // Insert guest stay details
            PreparedStatement insertGuestStayStmt = connection.prepareStatement(insertGuestStayQuery);
            insertGuestStayStmt.setInt(1, guestId);
            insertGuestStayStmt.setInt(2, bookerId);
            insertGuestStayStmt.setString(3, roomType.name());
            insertGuestStayStmt.setDate(4, new java.sql.Date(dateIn.getTime()));
            insertGuestStayStmt.setDate(5, new java.sql.Date(dateOut.getTime()));
            insertGuestStayStmt.setInt(6, nightsSpent);
            insertGuestStayStmt.setDouble(7, amountToPay);
            insertGuestStayStmt.executeUpdate();

            System.out.println("Booking successful! Guest ID: " + guestId + ", Room Type: " + roomType + ", Nights: " + nightsSpent + ", Total: $" + amountToPay);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    // Display all rooms from the database
    public void displaYRooms() {
        String query = "SELECT * FROM Room";
        try (Connection connection = DataBaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String image = resultSet.getString("roomImage");
                double price = resultSet.getDouble("pricePerNight");
                String type = resultSet.getString("roomType");
                int numberOfRooms = resultSet.getInt("numberOfRooms");

                System.out.println("Room ID: " + id + ", Image: " + image + ", Price: $" + price +
                        ", Type: " + type + ", Available Rooms: " + numberOfRooms);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Display all Bookings from the database
    public void displaYBookings() {
        String bookingQuery = "SELECT b.bookerId, b.totalAmount, g.guestId, g.roomType, g.dateIn, g.dateOut, g.nightsSpent, g.amountToPay " +
                "FROM Booking b " +
                "JOIN GuestStay g ON b.bookerId = g.bookerId " +
                "ORDER BY b.bookerId";

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(bookingQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (!resultSet.isBeforeFirst()) {
                System.out.println("No bookings available.");
                return;
            }

            while (resultSet.next()) {
                int bookerId = resultSet.getInt("bookerId");
                double totalAmount = resultSet.getDouble("totalAmount");
                int guestId = resultSet.getInt("guestId");
                String roomType = resultSet.getString("roomType");
                Date dateIn = resultSet.getDate("dateIn");
                Date dateOut = resultSet.getDate("dateOut");
                int nightsSpent = resultSet.getInt("nightsSpent");
                double amountToPay = resultSet.getDouble("amountToPay");

                System.out.println("Booker ID: " + bookerId);
                System.out.println("  Total Amount: $" + totalAmount);
                System.out.println("  Guest ID: " + guestId);
                System.out.println("  Room Type: " + roomType);
                System.out.println("  Check-in Date: " + dateIn);
                System.out.println("  Check-out Date: " + dateOut);
                System.out.println("  Nights Spent: " + nightsSpent);
                System.out.println("  Amount to Pay: $" + amountToPay);
                System.out.println("----------------------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }







}
