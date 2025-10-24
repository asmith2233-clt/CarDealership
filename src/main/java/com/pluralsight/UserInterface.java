package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;

    public void display() {
        init();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            displayMenu();

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    processAllVehiclesRequest();
                    break;
                case "0":
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
                    break;
            }
        }

        scanner.close();
    }

    // Load the dealership from the file
    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
        dealership = fileManager.getDealership();

        if (dealership != null) {
            System.out.println("✅ Dealership loaded successfully!\n");
        } else {
            System.out.println("⚠️ Failed to load dealership data.\n");
        }
    }

    // Show menu options
    private void displayMenu() {
        System.out.println("======== Dealership Menu ========");
        System.out.println("1) View all vehicles");
        System.out.println("0) Exit");
        System.out.println("=================================");
    }

    // Display all vehicles
    private void processAllVehiclesRequest() {
        if (dealership == null) {
            System.out.println("No dealership loaded.");
            return;
        }

        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    // Helper method to show each vehicle
    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
            return;
        }

        System.out.println("\n--- Vehicles Available ---");
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
        System.out.println("---------------------------\n");
    }
}


