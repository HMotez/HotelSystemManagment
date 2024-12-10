package User;



import java.math.BigDecimal;
import java.util.Date;

public class ITSupportSpecialist extends Technical {

    private String ticketingSystemExperience;
    private int issueResolutionTime;
    private BigDecimal customerFeedbackScore;
    private boolean remoteSupportExperience;

    public ITSupportSpecialist() {
    }

    public ITSupportSpecialist(int id, String firstName, String lastName, String email, String phoneNumber,
                               String address, Date hireDate, BigDecimal salary, String status,
                               String department, String jobTitle, String workingHours, String technicalSkills,
                               String certifications, String workLocation, Date lastTrainingDate,
                               String ticketingSystemExperience, int issueResolutionTime,
                               BigDecimal customerFeedbackScore, boolean remoteSupportExperience) {
        super(id, firstName, lastName, email, phoneNumber, address, hireDate, salary, status, department,
                jobTitle, workingHours, technicalSkills, certifications, workLocation, lastTrainingDate);
        this.ticketingSystemExperience = ticketingSystemExperience;
        this.issueResolutionTime = issueResolutionTime;
        this.customerFeedbackScore = customerFeedbackScore;
        this.remoteSupportExperience = remoteSupportExperience;
    }


    public String getTicketingSystemExperience() {
        return ticketingSystemExperience;
    }

    public void setTicketingSystemExperience(String ticketingSystemExperience) {
        this.ticketingSystemExperience = ticketingSystemExperience;
    }

    public int getIssueResolutionTime() {
        return issueResolutionTime;
    }

    public void setIssueResolutionTime(int issueResolutionTime) {
        this.issueResolutionTime = issueResolutionTime;
    }

    public BigDecimal getCustomerFeedbackScore() {
        return customerFeedbackScore;
    }

    public void setCustomerFeedbackScore(BigDecimal customerFeedbackScore) {
        this.customerFeedbackScore = customerFeedbackScore;
    }

    public boolean isRemoteSupportExperience() {
        return remoteSupportExperience;
    }

    public void setRemoteSupportExperience(boolean remoteSupportExperience) {
        this.remoteSupportExperience = remoteSupportExperience;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", ITSupportSpecialist {" +
                "ticketingSystemExperience='" + ticketingSystemExperience + '\'' +
                ", issueResolutionTime=" + issueResolutionTime +
                ", customerFeedbackScore=" + customerFeedbackScore +
                ", remoteSupportExperience=" + remoteSupportExperience +
                '}';
    }
}

