package com.pluralsight;

import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> vehicles;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.vehicles = new ArrayList<>();
    }

    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void removeVehicle(int vinNumber) {
        vehicles.removeIf(v -> v.getVinNumber() == vinNumber);
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return vehicles;
    }

    // Search by price range
    public ArrayList<Vehicle> getVehiclesByPrice(double minPrice, double maxPrice) {
        ArrayList<Vehicle> matches = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if (v.getPrice() >= minPrice && v.getPrice() <= maxPrice) {
                matches.add(v);
            }
        }
        return matches;
    }

    //  Search by make or model
    public ArrayList<Vehicle> getVehiclesByMakeModel(String makeOrModel) {
        ArrayList<Vehicle> matches = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if (v.getMake().equalsIgnoreCase(makeOrModel) ||
                    v.getModel().equalsIgnoreCase(makeOrModel)) {
                matches.add(v);
            }
        }
        return matches;
    }

    //  Search by year range
    public ArrayList<Vehicle> getVehiclesByYear(int minYear, int maxYear) {
        ArrayList<Vehicle> matches = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if (v.getYear() >= minYear && v.getYear() <= maxYear) {
                matches.add(v);
            }
        }
        return matches;
    }

    //  Search by color
    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        ArrayList<Vehicle> matches = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if (v.getColor().equalsIgnoreCase(color)) {
                matches.add(v);
            }
        }
        return matches;
    }

    //  Search by mileage
    public ArrayList<Vehicle> getVehiclesByMileage(int minMiles, int maxMiles) {
        ArrayList<Vehicle> matches = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if (v.getOdometer() >= minMiles && v.getOdometer() <= maxMiles) {
                matches.add(v);
            }
        }
        return matches;
    }

    //  Search by type
    public ArrayList<Vehicle> getVehiclesByType(String type) {
        ArrayList<Vehicle> matches = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if (v.getVehicleType().equalsIgnoreCase(type)) {
                matches.add(v);
            }
        }
        return matches;
    }
}

