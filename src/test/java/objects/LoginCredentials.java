package objects;

public class LoginCredentials {

    private String username;



    private String password;

    private String email_id;

    // Default Constructor

    public LoginCredentials(){}

    // Parameterized Constructor

    public LoginCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // getter and setter


    public String getUsername() {
        return username;
    }

    public LoginCredentials setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginCredentials setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail_id() {
        return email_id;
    }

    public LoginCredentials setEmail_id(String email_id) {
        this.email_id = email_id;
        return this;
    }
}
