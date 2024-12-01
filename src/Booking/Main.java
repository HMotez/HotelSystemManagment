// Main class to test the implementation
package Booking;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a booking
        Scanner scanner = new Scanner(System.in); // Create a Scanner object
        System.out.print("Enter a bookerID: ");
        int bookerID = scanner.nextInt();

        // Add guest stays to the booking
        GuestStay guest1 = new GuestStay(101, bookerID, "Single", 3, 50.0);
        GuestStay guest2 = new GuestStay(102, bookerID, "Double", 2, 80.0);
        Booking booking = new Booking(1,2,bookerID);

        booking.addGuestStay(guest1);
        booking.addGuestStay(guest2);

        // Print booking details
        booking.info();
    }
}