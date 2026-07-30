public class User {

    private String UserName;

    private String Password;

    private String FullName;

    private String Contact;

    public User(String userName, String password, String fullName, String contact) {
        UserName = userName;
        Password = password;
        FullName = fullName;
        Contact = contact;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String useerName) {
        UserName = useerName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    @Override
    public String toString() {
        return FullName + "("+UserName+")";
    }
}
