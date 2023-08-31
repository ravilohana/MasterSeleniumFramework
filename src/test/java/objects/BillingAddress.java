package objects;

public class BillingAddress {

    // fields name for billing address for checkout page
    private String firstname;
    private String lastname;
    private String companyName;
    private String countryName;
    private String streetAddressOne;
    private String streetAddressTwo;
    private String city;
    private String state;
    private String zipCode;
    private String phone_no;
    private String email_id;

    // Default constructor

    public BillingAddress(){}


    // Parametrized Constructor
    public BillingAddress(String firstname,
                          String lastname,
                          String companyName,
                          String countryName,
                          String streetAddressOne,
                          String streetAddressTwo,
                          String city,
                          String state,
                          String zipCode,
                          String phone_no,
                          String email_id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.companyName = companyName;
        this.countryName = countryName;
        this.streetAddressOne = streetAddressOne;
        this.streetAddressTwo = streetAddressTwo;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phone_no = phone_no;
        this.email_id = email_id;
    }






    // Getter and Setter

    public String getFirstname() {
        return firstname;
    }

    public BillingAddress setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public BillingAddress setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public BillingAddress setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getCountryName() {
        return countryName;
    }

    public BillingAddress setCountryName(String countryName) {
        this.countryName = countryName;
        return this;
    }

    public String getStreetAddressOne() {
        return streetAddressOne;
    }

    public BillingAddress setStreetAddressOne(String streetAddressOne) {
        this.streetAddressOne = streetAddressOne;
        return this;
    }

    public String getStreetAddressTwo() {
        return streetAddressTwo;
    }

    public BillingAddress setStreetAddressTwo(String streetAddressTwo) {
        this.streetAddressTwo = streetAddressTwo;
        return this;
    }

    public String getCity() {
        return city;
    }

    public BillingAddress setCity(String city) {
        this.city = city;
        return this;
    }

    public String getState() {
        return state;
    }

    public BillingAddress setState(String state) {
        this.state = state;
        return this;
    }

    public String getZipCode() {
        return zipCode;
    }

    public BillingAddress setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public BillingAddress setPhone_no(String phone_no) {
        this.phone_no = phone_no;
        return this;

    }

    public String getEmail_id() {
        return email_id;
    }

    public BillingAddress setEmail_id(String email_id) {
        this.email_id = email_id;
        return this;
    }
}
