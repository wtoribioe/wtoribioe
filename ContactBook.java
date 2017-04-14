/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wilfridoaddressbook;

public class ContactBook {
    String fullName;
    String street;
    String city;
    String state;
    String zip;

    public ContactBook(String fullName) {
        this.fullName = fullName;
    }
    public ContactBook(String fullName, String street, String city, String state, String zip) {
        this(fullName);
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getZip() {
        return zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }
    @Override
    public String toString() {
        return "Full Name: " + fullName + " | Street: " + street +
                " | City: " + city + " | State: " + state + " | Zip: " + zip;
    }
}