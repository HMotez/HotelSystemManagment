package Booking;
import Hotel.*;
import java.util.List;
import java.util.ArrayList;

public class Booking {
    // Attributes
    private int id;
    private List<GuestStay> guestStays;
    private int totalGuest;

    private double totalAmount;
    private int bookerId;

    // Constructor
    public Booking(int id, int totalGuest, int bookerId) {
        this.id = id;
        this.guestStays = new ArrayList<>();
        this.totalGuest = totalGuest;
        this.totalAmount = 0;
        this.bookerId = bookerId;
    }

    public void addGuestStay(GuestStay guestStay) {
        guestStays.add(guestStay);
        calculateTotalAmount();
    }

    private void calculateTotalAmount() {
        totalAmount = guestStays.stream().mapToDouble(GuestStay::getAmountToPay).sum();
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




    public List<GuestStay> getGuestStays() {
        return guestStays;
    }

    public void setGuestStays(List<GuestStay> guestStays) {
        this.guestStays = guestStays;
    }

    public int getTotalGuest() {
        return totalGuest;
    }

    public void setTotalGuest(int totalGuest) {
        this.totalGuest = totalGuest;
    }




    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getBookerId() {
        return bookerId;
    }

    public void setBookerId(int bookerId) {
        this.bookerId = bookerId;
    }

    // Optional: Add a toString method for debugging purposes
    public String info() {
        return "Booking{" +
                "id=" + id +
                ", guestStays=" + guestStays +
                ", totalGuest=" + totalGuest +
                ", totalAmount=" + totalAmount +
                ", bookerId='" + bookerId + '\'' +
                '}';
    }
}
