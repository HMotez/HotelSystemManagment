package UserStaff;

public class Concierge extends CustomerService {

    private String guestPreferences;
    private String localGuides;
    private int bookingsMade;
    private String specialRequests;

    // Default Constructor
    public Concierge() {
    }

    public Concierge(int id, String firstName, String lastName, String email, String phoneNumber,
                     String address, java.util.Date hireDate, java.math.BigDecimal salary, String status,
                     String department, String jobTitle, String workingHours, String shiftType, String location,
                     String responsibilityLevel, int taskCount, java.math.BigDecimal performanceRating,
                     java.math.BigDecimal customerSatisfactionScore, String languagesSpoken, String shift,
                     String feedbackReceived, String guestPreferences, String localGuides, int bookingsMade,
                     String specialRequests) {
        super(id, firstName, lastName, email, phoneNumber, address, hireDate, salary, status, department, jobTitle,
                workingHours, customerSatisfactionScore,languagesSpoken,shift,feedbackReceived);

        this.guestPreferences = guestPreferences;
        this.localGuides = localGuides;
        this.bookingsMade = bookingsMade;
        this.specialRequests = specialRequests;
    }

    public String getGuestPreferences() {
        return guestPreferences;
    }

    public void setGuestPreferences(String guestPreferences) {
        this.guestPreferences = guestPreferences;
    }

    public String getLocalGuides() {
        return localGuides;
    }

    public void setLocalGuides(String localGuides) {
        this.localGuides = localGuides;
    }

    public int getBookingsMade() {
        return bookingsMade;
    }

    public void setBookingsMade(int bookingsMade) {
        this.bookingsMade = bookingsMade;
    }

    public String getSpecialRequests() {
        return specialRequests;
    }

    public void setSpecialRequests(String specialRequests) {
        this.specialRequests = specialRequests;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Concierge {" +
                "guestPreferences='" + guestPreferences + '\'' +
                ", localGuides='" + localGuides + '\'' +
                ", bookingsMade=" + bookingsMade +
                ", specialRequests='" + specialRequests + '\'' +
                '}';
    }
}
