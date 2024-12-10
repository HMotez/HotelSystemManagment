package User;



import java.util.Date;
import java.util.List;

public class MaintenanceEngineer extends Technical {

    private String specialization;
    private int responseTime;
    private List<String> repairRequests;
    private List<String> maintenanceTasks;
    private String tools;


    public MaintenanceEngineer() {
    }


    public MaintenanceEngineer(int id, String firstName, String lastName, String email, String phoneNumber,
                               String address, Date hireDate, java.math.BigDecimal salary, String status,
                               String department, String jobTitle, String workingHours, String technicalSkills,
                               String certifications, String workLocation, Date lastTrainingDate, String specialization,
                               int responseTime, List<String> repairRequests, List<String> maintenanceTasks, String tools) {
        super(id, firstName, lastName, email, phoneNumber, address, hireDate, salary, status, department, jobTitle,
                workingHours, technicalSkills, certifications, workLocation, lastTrainingDate);
        this.specialization = specialization;
        this.responseTime = responseTime;
        this.repairRequests = repairRequests;
        this.maintenanceTasks = maintenanceTasks;
        this.tools = tools;
    }


    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(int responseTime) {
        this.responseTime = responseTime;
    }

    public List<String> getRepairRequests() {
        return repairRequests;
    }

    public void setRepairRequests(List<String> repairRequests) {
        this.repairRequests = repairRequests;
    }

    public List<String> getMaintenanceTasks() {
        return maintenanceTasks;
    }

    public void setMaintenanceTasks(List<String> maintenanceTasks) {
        this.maintenanceTasks = maintenanceTasks;
    }

    public String getTools() {
        return tools;
    }

    public void setTools(String tools) {
        this.tools = tools;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", MaintenanceEngineer {" +
                "specialization='" + specialization + '\'' +
                ", responseTime=" + responseTime +
                ", repairRequests=" + repairRequests +
                ", maintenanceTasks=" + maintenanceTasks +
                ", tools='" + tools + '\'' +
                '}';
    }
}
