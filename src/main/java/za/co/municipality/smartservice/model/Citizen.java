package za.co.municipality.smartservice.model;

public class Citizen extends Person {
    private String identityNumber;

    public Citizen() { }
    public Citizen(String fullName, String email, String identityNumber) {
        super(fullName, email);
        this.identityNumber = identityNumber;
    }
    public String getIdentityNumber() { return identityNumber; }
    public void setIdentityNumber(String identityNumber) { this.identityNumber = identityNumber; }
}
