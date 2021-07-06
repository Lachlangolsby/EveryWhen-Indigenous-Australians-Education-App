package com.example.infs3605;

public class User {

    public String firstName, lastName, email;

    public User(){

    }

    public User(String fName, String lName, String email){
        this.firstName = fName;
        this.lastName = lName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
