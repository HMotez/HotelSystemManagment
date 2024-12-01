
package Hotel;
import User.*;


public class Room {
    //S:STANDARD
    //D:DELUXE
    //E:Executive
    //F:FAMILY
    public enum RoomType {S1,S2,D1,D2,E1,E2,F1,F2,F3,F4}

    private String roomName;
    private String roomImage;
    private double pricePerNight;
    private RoomType roomType;


    public Room() {}


    public Room( String roomName, String roomImage, double pricePerNight, RoomType roomType) {
        this.roomName = roomName;
        this.roomImage = roomImage;
        this.pricePerNight = pricePerNight;
        this.roomType = roomType;
    }


    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomImage() {
        return roomImage;
    }

    public void setRoomImage(String roomImage) {
        this.roomImage = roomImage;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }


    @Override
    public String toString() {
        return "Room{" +
                " roomName='" + roomName + '\'' +
                ", roomImage='" + roomImage + '\'' +
                ", pricePerNight=" + pricePerNight +
                ", roomType=" + roomType +
                '}';
    }



}
