package contacts;

public class Contact {

    // INSTANCE VARIABLES ---------------------------------------------->
    private String name;
    private Long phoneNumber;
    private String email;

    // GETTERS AND SETTERS --------------------------------------------->
    // NAME ............................................................
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    // PHONE NUMBER ....................................................
    public Long getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    // EMAIL ............................................................
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    // CONSTRUCTORS ---------------------------------------------------->
    public Contact(String name, Long phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    public Contact() {
    }
}
