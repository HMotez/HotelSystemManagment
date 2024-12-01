package Booking;
class GuestStay {
    private int guestId;
    private int bookerId;
    private String roomType;
    private int nightsSpent;
    private double amountToPay;

    public GuestStay(int guestId, int bookerId, String roomType, int nightsSpent, double pricePerNight) {
        this.guestId = guestId;
        this.bookerId = bookerId;
        this.roomType = roomType;
        this.nightsSpent = nightsSpent;
        this.amountToPay = calculateAmount(pricePerNight);
    }

    private double calculateAmount(double pricePerNight) {
        return nightsSpent * pricePerNight;
    }

    public int getGuestId() {
        return guestId;
    }

    public int getBookerId() {
        return bookerId;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getNightsSpent() {
        return nightsSpent;
    }

    public double getAmountToPay() {
        return amountToPay;
    }
}
