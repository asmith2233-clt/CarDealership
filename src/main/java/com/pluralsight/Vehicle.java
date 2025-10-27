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

    public Vehicle(int vin, int year, String make, String model, String type, String color, int odometer, double price) {
        this.vinNumber = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = type;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    public int getVinNumber() { return vinNumber; }
    public int getYear() { return year; }
    public String getMake() { return make; }
    public String getModel() { return model; }
    public String getVehicleType() { return vehicleType; }
    public String getColor() { return color; }
    public int getOdometer() { return odometer; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return year + " " + make + " " + model + " (" + color + ") - $" + price;
    }

    public static ArrayList<Vehicle> getVehicleList() {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle(10112, 1993, "Ford", "Explorer", "SUV", "Red", 525123, 995.00));
        vehicles.add(new Vehicle(37846, 2001, "Ford", "Ranger", "Truck", "Yellow", 172544, 1995.00));
        vehicles.add(new Vehicle(44901, 2012, "Honda", "Civic", "SUV", "Gray", 103221, 6995.00));
        vehicles.add(new Vehicle(59234, 2015, "Toyota", "Camry", "Sedan", "Blue", 88210, 10995.00));
        vehicles.add(new Vehicle(81239, 2018, "Jeep", "Wrangler", "SUV", "Green", 55412, 22495.00));
        return vehicles;
    }
}

