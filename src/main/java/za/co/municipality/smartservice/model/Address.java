package za.co.municipality.smartservice.model;

public class Address {
    private String street;
    private String suburb;
    private String city;
    private String postalCode;

    public Address() { }
    public Address(String street, String suburb, String city, String postalCode) {
        this.street = street; this.suburb = suburb; this.city = city; this.postalCode = postalCode;
    }
    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }
    public String getSuburb() { return suburb; }
    public void setSuburb(String suburb) { this.suburb = suburb; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }
}
