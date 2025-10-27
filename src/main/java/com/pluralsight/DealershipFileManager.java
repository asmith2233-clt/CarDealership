package com.pluralsight;

import java.io.*;
import java.util.ArrayList;

public class DealershipFileManager {

    private static final String FILE_NAME = "inventory.csv";

    public static Dealership getDealership() {
        Dealership dealership = null;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line = br.readLine(); // Dealership info
            if (line != null) {
                String[] parts = line.split("\\|");
                dealership = new Dealership(parts[0], parts[1], parts[2]);

                String record;
                while ((record = br.readLine()) != null) {
                    String[] data = record.split("\\|");
                    int vin = Integer.parseInt(data[0]);
                    int year = Integer.parseInt(data[1]);
                    String make = data[2];
                    String model = data[3];
                    String type = data[4];
                    String color = data[5];
                    int odometer = Integer.parseInt(data[6]);
                    double price = Double.parseDouble(data[7]);

                    dealership.addVehicle(new Vehicle(vin, year, make, model, type, color, odometer, price));
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read file. Loading sample data instead.");
            dealership = new Dealership("Sample Motors", "123 Main St", "555-555-5555");
            for (Vehicle v : Vehicle.getVehicleList()) {
                dealership.addVehicle(v);
            }
        }

        return dealership;
    }

    public void saveDealership(Dealership dealership) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            pw.println(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            for (Vehicle v : dealership.getAllVehicles()) {
                pw.println(v.getVinNumber() + "|" + v.getYear() + "|" + v.getMake() + "|" + v.getModel() + "|" +
                        v.getVehicleType() + "|" + v.getColor() + "|" + v.getOdometer() + "|" + v.getPrice());
            }
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}



