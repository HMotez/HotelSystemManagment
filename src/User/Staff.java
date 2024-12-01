package User;

public class Staff extends User {

    public enum StaffType {CLEANING, MAINTENANCE, SECURITY, CHEF, WAITER, OTHER}

    public enum Shift {DAY, NIGHT}

    private StaffType staffType;
    private double salary;
    private Shift shift;
    private String department;


    // Constructeur paramétré
    public Staff(String CIN, String firstname, String lastname, String email, String phoneNumber,
                 StaffType staffType, double salary, Shift shift, String department) {
        super(CIN, firstname, lastname, email, phoneNumber);
        this.staffType = staffType;
        this.salary = salary;
        this.shift = shift;
        this.department = department;
    }

    // Getters et setters
    public StaffType getStaffType() {
        return staffType;
    }

    public void setStaffType(StaffType staffType) {
        this.staffType = staffType;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


    @Override
    public String toString() {
        return super.toString() + ", Staff {" +
                "staffType=" + staffType +
                ", salary=" + salary +
                ", shift=" + shift +
                ", department='" + department + '\'' +
                '}';
    }
}
