package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DealershipFileManager {

    private static final String FILE_NAME = "inventory.csv";

    // Reads the CSV file and builds a Dealership object
    public Dealership getDealership() {
        Dealership dealership = null;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            // Read first line = dealership info
            String dealershipLine = br.readLine();

            if (dealershipLine != null) {
                String[] parts = dealershipLine.split("\\|");
                String name = parts[0];
                String address = parts[1];
                String phone = parts[2];

                dealership = new Dealership(name, address, phone);

                // Read vehicles after the first line
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split("\\|");

                    int vin = Integer.parseInt(data[0]);
                    int year = Integer.parseInt(data[1]);
                    String make = data[2];
                    String model = data[3];
                    String type = data[4];
                    String color = data[5];
                    int odometer = Integer.parseInt(data[6]);
                    double price = Double.parseDouble(data[7]);

                    // Create the Vehicle object and add to dealership
                    Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
                    dealership.addVehicle(vehicle);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return dealership;
    }
}


