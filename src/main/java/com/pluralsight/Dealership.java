package com.pluralsight;
import java.util.ArrayList;

public class Dealership {
    // Dealership properties
    private String name;
    private String address;
    private String phone;

    // Constructor (used to create a dealership)
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    // Getters and Setters
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Method that creates an ArrayList of Dealerships
    public static ArrayList<Dealership> getDealerships() {
        ArrayList<Dealership> dealerships = new ArrayList<>();

        // Add some dealerships to the list
        dealerships.add(new Dealership("D & B Used Cars", "111 Old Benbrook Rd", "817-555-5555"));
        dealerships.add(new Dealership("Northside Auto Sales", "245 Main St", "817-555-1212"));
        dealerships.add(new Dealership("Metro Motors", "909 West Ave", "682-555-3434"));
        dealerships.add(new Dealership("Lone Star Cars", "500 East Ridge Rd", "972-555-6767"));

        return dealerships;
    }
}
