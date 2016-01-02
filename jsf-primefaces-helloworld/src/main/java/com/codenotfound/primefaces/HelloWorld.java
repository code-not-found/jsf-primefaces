package com.codenotfound.primefaces;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class HelloWorld {

    private String firstName = "John";
    private String lastName = "Doe";

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

    public String showGreeting() {
        return "Hello" + " " + firstName + " " + lastName + "!";
    }
}
