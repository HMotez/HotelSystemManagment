package User;

public class GuestBooker extends User {

    private String paymentDetails; // Informations de paiement

    // Constructeur paramétré
    public GuestBooker(String CIN, String firstname, String lastname, String email, String phoneNumber,
                       String paymentDetails) {
        super(CIN, firstname, lastname, email, phoneNumber); // Appelle le constructeur de Person
        this.paymentDetails = paymentDetails;
    }

    // Getter et setter pour paymentDetails
    public String getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(String paymentDetails) {
        this.paymentDetails = paymentDetails;
    }


    @Override
    public String toString() {
        return "GuestBooker {" + super.toString()+ ",paymentDetails=" + paymentDetails + '}';

    }
}
