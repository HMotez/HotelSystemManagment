package User;

public class Admin extends User {

    public enum Role {SUPER_ADMIN, MANAGER, RECEPTIONIST}

    private Role role;




    // Constructeur paramétré
    public Admin(String CIN, String firstname, String lastname, String email, String phoneNumber,
                 Role role ) {
        super(CIN, firstname, lastname, email, phoneNumber); // Appelle le constructeur de Person
        this.role = role;

    }

    // Getters et setters
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Admin {" + super.toString()+ ", role=" + role  + '}';
    }
}
