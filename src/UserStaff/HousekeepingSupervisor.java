package User;


import java.math.BigDecimal;
import java.util.Date;

public class HousekeepingSupervisor extends Operational {

    private int supervisedStaffCount;
    private BigDecimal roomInspectionScore;
    private Date inventoryCheckDate;
    private String cleaningSchedule;
    private int guestRequestsHandled;

    public HousekeepingSupervisor() {
    }

    public HousekeepingSupervisor(int id, String firstName, String lastName, String email, String phoneNumber,
                                  String address, Date hireDate, BigDecimal salary, String status, String department,
                                  String jobTitle, String workingHours, String shiftType, String location,
                                  String responsibilityLevel, int taskCount, BigDecimal performanceRating,
                                  int supervisedStaffCount, BigDecimal roomInspectionScore, Date inventoryCheckDate,
                                  String cleaningSchedule, int guestRequestsHandled) {
        super(id, firstName, lastName, email, phoneNumber, address, hireDate, salary, status, department, jobTitle,
                workingHours, shiftType, location, responsibilityLevel, taskCount, performanceRating);
        this.supervisedStaffCount = supervisedStaffCount;
        this.roomInspectionScore = roomInspectionScore;
        this.inventoryCheckDate = inventoryCheckDate;
        this.cleaningSchedule = cleaningSchedule;
        this.guestRequestsHandled = guestRequestsHandled;
    }

    public int getSupervisedStaffCount() {
        return supervisedStaffCount;
    }

    public void setSupervisedStaffCount(int supervisedStaffCount) {
        this.supervisedStaffCount = supervisedStaffCount;
    }

    public BigDecimal getRoomInspectionScore() {
        return roomInspectionScore;
    }

    public void setRoomInspectionScore(BigDecimal roomInspectionScore) {
        this.roomInspectionScore = roomInspectionScore;
    }

    public Date getInventoryCheckDate() {
        return inventoryCheckDate;
    }

    public void setInventoryCheckDate(Date inventoryCheckDate) {
        this.inventoryCheckDate = inventoryCheckDate;
    }

    public String getCleaningSchedule() {
        return cleaningSchedule;
    }

    public void setCleaningSchedule(String cleaningSchedule) {
        this.cleaningSchedule = cleaningSchedule;
    }

    public int getGuestRequestsHandled() {
        return guestRequestsHandled;
    }

    public void setGuestRequestsHandled(int guestRequestsHandled) {
        this.guestRequestsHandled = guestRequestsHandled;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", HousekeepingSupervisor {" +
                "supervisedStaffCount=" + supervisedStaffCount +
                ", roomInspectionScore=" + roomInspectionScore +
                ", inventoryCheckDate=" + inventoryCheckDate +
                ", cleaningSchedule='" + cleaningSchedule + '\'' +
                ", guestRequestsHandled=" + guestRequestsHandled +
                '}';
    }
}
