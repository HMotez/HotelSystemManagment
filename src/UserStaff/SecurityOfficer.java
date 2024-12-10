package UserStaff;

import java.math.BigDecimal;

public class SecurityOfficer extends Operational {

    private String securityClearanceLevel;
    private String certifications;
    private String patrolArea;
    private int incidentReportsFiled;
    private int hoursOnDuty;
    private BigDecimal emergencyResponseTime;

    public SecurityOfficer() {
    }

    public SecurityOfficer(int id, String firstName, String lastName, String email, String phoneNumber,
                           String address, java.util.Date hireDate, BigDecimal salary, String status,
                           String department, String jobTitle, String workingHours, String shiftType,
                           String location, String responsibilityLevel, int taskCount, BigDecimal performanceRating,
                           String securityClearanceLevel, String certifications, String patrolArea,
                           int incidentReportsFiled, int hoursOnDuty, BigDecimal emergencyResponseTime) {
        super(id, firstName, lastName, email, phoneNumber, address, hireDate, salary, status, department,
                jobTitle, workingHours, shiftType, location, responsibilityLevel, taskCount, performanceRating);
        this.securityClearanceLevel = securityClearanceLevel;
        this.certifications = certifications;
        this.patrolArea = patrolArea;
        this.incidentReportsFiled = incidentReportsFiled;
        this.hoursOnDuty = hoursOnDuty;
        this.emergencyResponseTime = emergencyResponseTime;
    }

    public String getSecurityClearanceLevel() {
        return securityClearanceLevel;
    }

    public void setSecurityClearanceLevel(String securityClearanceLevel) {
        this.securityClearanceLevel = securityClearanceLevel;
    }

    public String getCertifications() {
        return certifications;
    }

    public void setCertifications(String certifications) {
        this.certifications = certifications;
    }

    public String getPatrolArea() {
        return patrolArea;
    }

    public void setPatrolArea(String patrolArea) {
        this.patrolArea = patrolArea;
    }

    public int getIncidentReportsFiled() {
        return incidentReportsFiled;
    }

    public void setIncidentReportsFiled(int incidentReportsFiled) {
        this.incidentReportsFiled = incidentReportsFiled;
    }

    public int getHoursOnDuty() {
        return hoursOnDuty;
    }

    public void setHoursOnDuty(int hoursOnDuty) {
        this.hoursOnDuty = hoursOnDuty;
    }

    public BigDecimal getEmergencyResponseTime() {
        return emergencyResponseTime;
    }

    public void setEmergencyResponseTime(BigDecimal emergencyResponseTime) {
        this.emergencyResponseTime = emergencyResponseTime;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", SecurityOfficer {" +
                "securityClearanceLevel='" + securityClearanceLevel + '\'' +
                ", certifications='" + certifications + '\'' +
                ", patrolArea='" + patrolArea + '\'' +
                ", incidentReportsFiled=" + incidentReportsFiled +
                ", hoursOnDuty=" + hoursOnDuty +
                ", emergencyResponseTime=" + emergencyResponseTime +
                '}';
    }
}
