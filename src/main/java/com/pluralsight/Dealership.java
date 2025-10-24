package com.pluralsight;

import java.util.ArrayList;

public class Dealership {
    // Dealership info
    private String name;
    private String address;
    private String phone;

    // A list that holds all vehicles
    private ArrayList<Vehicle> inventory;

    // Constructor
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>(); // Always start with an empty list
    }

    // Add a vehicle to the list
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    // Get all vehicles
    public ArrayList<Vehicle> getAllVehicles() {
        return inventory;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
