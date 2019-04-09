package com.chnt.gr.preOrder.classes;

public class User {

    public String firstname;
    public String lastname;
    public String email;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String email, String fName, String lName) {

        this.email = email;
        this.firstname = fName;
        this.lastname = lName;
    }
}
