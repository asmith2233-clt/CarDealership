package com.pluralsight;

import java.util.ArrayList;

public class Vehicle {
    private int vinNumber;
    private int year;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private int odometer;
    private double price;

    // Constructor
    public Vehicle(int vinNumber, int year, String make, String model, String vehicleType, String color, int odometer, double price) {
        this.vinNumber = vinNumber;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    // Getters and Setters
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(int vinNumber) {
        this.vinNumber = vinNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // This method creates and returns an ArrayList of Vehicle objects
    public static ArrayList<Vehicle> getVehicleList() {
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Vehicle(10112, 1993, "Ford", "Explorer", "SUV", "Red", 525123, 995.00));
        vehicles.add(new Vehicle(37846, 2001, "Ford", "Ranger", "Truck", "Yellow", 172544, 1995.00));
        vehicles.add(new Vehicle(44901, 2012, "Honda", "Civic", "SUV", "Gray", 103221, 6995.00));
        vehicles.add(new Vehicle(59234, 2015, "Toyota", "Camry", "Sedan", "Blue", 88210, 10995.00));
        vehicles.add(new Vehicle(67321, 2017, "Chevrolet", "Malibu", "Sedan", "White", 64233, 11950.00));
        vehicles.add(new Vehicle(78455, 2010, "Nissan", "Altima", "Sedan", "Black", 135880, 7495.00));
        vehicles.add(new Vehicle(81239, 2018, "Jeep", "Wrangler", "SUV", "Green", 55412, 22495.00));
        vehicles.add(new Vehicle(92347, 2014, "Hyundai", "Sonata", "Sedan", "Silver", 98330, 8995.00));
        vehicles.add(new Vehicle(10456, 2019, "Subaru", "Outback", "Wagon", "Brown", 42670, 18995.00));
        vehicles.add(new Vehicle(11589, 2020, "Kia", "Soul", "SUV", "Orange", 33100, 15995.00));
        vehicles.add(new Vehicle(12673, 2013, "Dodge", "Ram 1500", "Truck", "Red", 117430, 13950.00));
        vehicles.add(new Vehicle(13744, 2011, "BMW", "328i", "Sedan", "Gray", 90215, 9995.00));
        vehicles.add(new Vehicle(14829, 2016, "Chevrolet", "Tahoe", "SUV", "Black", 78100, 21995.00));
        vehicles.add(new Vehicle(15903, 2017, "Ford", "Fusion", "Sedan", "Blue", 59211, 12500.00));
        vehicles.add(new Vehicle(16288, 2012, "Mazda", "CX-5", "SUV", "White", 101422, 10950.00));
        vehicles.add(new Vehicle(17594, 2015, "Volkswagen", "Jetta", "Sedan", "Silver", 88540, 9450.00));
        vehicles.add(new Vehicle(18321, 2019, "Toyota", "RAV4", "SUV", "Gray", 46320, 21995.00));
        return vehicles;
    }
    @Override
    public String toString() {
        return year + " " + make + " " + model + " (" + color + ") - $" + price;
    }


}
