package dto;


import java.util.Objects;

public class User {
    private int id;
    private String firstNAme;
    private String lastName;
    private String userName;
    private String password;
    private String phoneNumber;
    private String email;
    private Address address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstNAme() {
        return firstNAme;
    }

    public void setFirstNAme(String firstNAme) {
        this.firstNAme = firstNAme;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(getFirstNAme(), user.getFirstNAme()) &&
                Objects.equals(getLastName(), user.getLastName()) &&
                Objects.equals(getUserName(), user.getUserName()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                Objects.equals(getPhoneNumber(), user.getPhoneNumber()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getAddress(), user.getAddress());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getFirstNAme(), getLastName(), getUserName(), getPassword(), getPhoneNumber(),getEmail(), getAddress());
    }

    @Override
    public String toString() {
        String user = "{user name:" + userName + "," +
                "password:" + password + "," +
                "first name:" + firstNAme + "," +
                "last name:" + lastName + "," +
                "email:" + email + "," +
                "phone number:" + phoneNumber + "," +
                "address:" + address + "}";
        return user;
    }
}
