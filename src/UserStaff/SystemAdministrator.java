package User;



import java.math.BigDecimal;
import java.util.Date;

public class SystemAdministrator extends Technical {

    private String systemType;
    private int serverCount;
    private String backupSchedules;
    private BigDecimal uptimePercentage;


    public SystemAdministrator() {
    }

    public SystemAdministrator(int id, String firstName, String lastName, String email, String phoneNumber,
                               String address, Date hireDate, BigDecimal salary, String status,
                               String department, String jobTitle, String workingHours,
                               String technicalSkills, String certifications, String workLocation,
                               Date lastTrainingDate, String systemType, int serverCount,
                               String backupSchedules, BigDecimal uptimePercentage) {
        super(id, firstName, lastName, email, phoneNumber, address, hireDate, salary, status, department, jobTitle,
                workingHours, technicalSkills, certifications, workLocation, lastTrainingDate);
        this.systemType = systemType;
        this.serverCount = serverCount;
        this.backupSchedules = backupSchedules;
        this.uptimePercentage = uptimePercentage;
    }


    public String getSystemType() {
        return systemType;
    }

    public void setSystemType(String systemType) {
        this.systemType = systemType;
    }

    public int getServerCount() {
        return serverCount;
    }

    public void setServerCount(int serverCount) {
        this.serverCount = serverCount;
    }

    public String getBackupSchedules() {
        return backupSchedules;
    }

    public void setBackupSchedules(String backupSchedules) {
        this.backupSchedules = backupSchedules;
    }

    public BigDecimal getUptimePercentage() {
        return uptimePercentage;
    }

    public void setUptimePercentage(BigDecimal uptimePercentage) {
        this.uptimePercentage = uptimePercentage;
    }


    @Override
    public String toString() {
        return super.toString() +
                ", SystemAdministrator {" +
                "systemType='" + systemType + '\'' +
                ", serverCount=" + serverCount +
                ", backupSchedules='" + backupSchedules + '\'' +
                ", uptimePercentage=" + uptimePercentage +
                '}';
    }
}

