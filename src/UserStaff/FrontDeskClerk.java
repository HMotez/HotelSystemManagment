package UserStaff;



import java.sql.Time;
import java.math.BigDecimal;

public class FrontDeskClerk extends CustomerService {

    private int assignedRoomNumber;
    private Time checkInTime;
    private Time checkOutTime;
    private String paymentStatus;

    // Default Constructor
    public FrontDeskClerk() {
    }

    // Parameterized Constructor
    public FrontDeskClerk(int id, String firstName, String lastName, String email, String phoneNumber,
                          String address, java.util.Date hireDate, BigDecimal salary, String status, String department,
                          String jobTitle, String workingHours, String shiftType, String location, String responsibilityLevel,
                          int taskCount, BigDecimal performanceRating, BigDecimal customerSatisfactionScore,
                          String languagesSpoken, String shift, String feedbackReceived, int assignedRoomNumber,
                          Time checkInTime, Time checkOutTime, String paymentStatus) {
        // Calling the parent constructor (CustomerService)
        super(id, firstName, lastName, email, phoneNumber, address, hireDate, salary, status, department, jobTitle,
                workingHours, customerSatisfactionScore,languagesSpoken,shift,feedbackReceived);

        // Initializing the FrontDeskClerk-specific fields
        this.assignedRoomNumber = assignedRoomNumber;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.paymentStatus = paymentStatus;
    }

    // Getters and Setters
    public int getAssignedRoomNumber() {
        return assignedRoomNumber;
    }

    public void setAssignedRoomNumber(int assignedRoomNumber) {
        this.assignedRoomNumber = assignedRoomNumber;
    }

    public Time getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Time checkInTime) {
        this.checkInTime = checkInTime;
    }

    public Time getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(Time checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    // toString Method
    @Override
    public String toString() {
        return super.toString() +
                ", FrontDeskClerk {" +
                "assignedRoomNumber=" + assignedRoomNumber +
                ", checkInTime=" + checkInTime +
                ", checkOutTime=" + checkOutTime +
                ", paymentStatus='" + paymentStatus + '\'' +
                '}';
    }
}
