package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    public static Dealership dealership = DealershipFileManager.getDealership();
    private final Scanner scanner = new Scanner(System.in); // use one scanner

    public void display() {
        init();

        boolean running = true;

        while (running) {
            displayMenu();
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine(); // use nextLine everywhere

            switch (choice) {
                case "1":
                    processAllVehiclesRequest();
                    break;
                case "2":
                    processAddVehicleRequest();
                    break;
                case "3":
                    processRemoveVehicleRequest();
                    break;
                case "4":
                    processFindByPriceRequest();
                    break;
                case "5":
                    processFindByMakeModelRequest();
                    break;
                case "6":
                    processFindByYearRequest();
                    break;
                case "7":
                    processFindByColorRequest();
                    break;
                case "8":
                    processFindByMileageRequest();
                    break;
                case "9":
                    processFindByTypeRequest();
                    break;
                case "10":
                    processSellOrLeaseRequest(); // new Phase 3
                    break;
                case "0":
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        }
    }

    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
        dealership = fileManager.getDealership();
        if (dealership != null)
            System.out.println("Dealership loaded successfully!\n");
        else
            System.out.println("Failed to load dealership data.\n");
    }

    private void displayMenu() {
        System.out.println("======== Dealership Menu ========");
        System.out.println("1) View all vehicles");
        System.out.println("2) Add a vehicle");
        System.out.println("3) Remove a vehicle");
        System.out.println("4) Find vehicles by price range");
        System.out.println("5) Find vehicles by make/model");
        System.out.println("6) Find vehicles by year range");
        System.out.println("7) Find vehicles by color");
        System.out.println("8) Find vehicles by mileage range");
        System.out.println("9) Find vehicles by type");
        System.out.println("10) Sell/Lease a vehicle"); // new Phase 3 feature
        System.out.println("0) Exit");
        System.out.println("=================================");
    }

    private void processAllVehiclesRequest() {
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found.\n");
            return;
        }
        System.out.println("\n--- Vehicles Found ---");
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
        System.out.println("----------------------\n");
    }

    private void processAddVehicleRequest() {
        System.out.println("\n--- Add a New Vehicle ---");
        System.out.print("Enter VIN: ");
        int vin = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter year: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter make: ");
        String make = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();
        System.out.print("Enter type: ");
        String type = scanner.nextLine();
        System.out.print("Enter color: ");
        String color = scanner.nextLine();
        System.out.print("Enter mileage: ");
        int odometer = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter price: ");
        double price = Double.parseDouble(scanner.nextLine());

        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
        dealership.addVehicle(vehicle);

        DealershipFileManager fileManager = new DealershipFileManager();
        fileManager.saveDealership(dealership);

        System.out.println("Vehicle added and saved successfully!\n");
    }

    private void processRemoveVehicleRequest() {
        System.out.print("\nEnter VIN to remove: ");
        int vin = Integer.parseInt(scanner.nextLine());
        dealership.removeVehicle(vin);
        new DealershipFileManager().saveDealership(dealership);
        System.out.println("Vehicle removed and saved successfully.\n");
    }

    private void processFindByPriceRequest() {
        System.out.print("Enter minimum price: ");
        double min = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter maximum price: ");
        double max = Double.parseDouble(scanner.nextLine());
        displayVehicles(dealership.getVehiclesByPrice(min, max));
    }

    private void processFindByMakeModelRequest() {
        System.out.print("Enter make or model: ");
        String makeModel = scanner.nextLine();
        displayVehicles(dealership.getVehiclesByMakeModel(makeModel));
    }

    private void processFindByYearRequest() {
        System.out.print("Enter minimum year: ");
        int min = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter maximum year: ");
        int max = Integer.parseInt(scanner.nextLine());
        displayVehicles(dealership.getVehiclesByYear(min, max));
    }

    private void processFindByColorRequest() {
        System.out.print("Enter color: ");
        String color = scanner.nextLine();
        displayVehicles(dealership.getVehiclesByColor(color));
    }

    private void processFindByMileageRequest() {
        System.out.print("Enter minimum mileage: ");
        int min = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter maximum mileage: ");
        int max = Integer.parseInt(scanner.nextLine());
        displayVehicles(dealership.getVehiclesByMileage(min, max));
    }

    private void processFindByTypeRequest() {
        System.out.print("Enter vehicle type (SUV, car, truck, etc.): ");
        String type = scanner.nextLine();
        displayVehicles(dealership.getVehiclesByType(type));
    }

    // Phase 3: Sell or Lease a Vehicle
    private void processSellOrLeaseRequest() {
        System.out.print("Enter VIN of vehicle: ");
        int vin = Integer.parseInt(scanner.nextLine());

        Vehicle vehicle = null;
        for (Vehicle v : dealership.getAllVehicles()) {
            if (v.getVinNumber() == vin) {
                vehicle = v;
                break;
            }
        }

        if (vehicle == null) {
            System.out.println("Vehicle not found.\n");
            return;
        }

        System.out.print("Enter date (YYYYMMDD): ");
        String date = scanner.nextLine();
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter customer email: ");
        String email = scanner.nextLine();

        System.out.print("Is this a Sale or Lease (S/L)? ");
        String type = scanner.nextLine().toUpperCase();

        Contract contract = null;

        if (type.equals("S")) {
            System.out.print("Do they want to finance? (yes/no): ");
            boolean finance = scanner.nextLine().equalsIgnoreCase("yes");
            contract = new SalesContract(date, name, email, vehicle, finance);
        } else if (type.equals("L")) {
            if (2025 - vehicle.getYear() > 3) {
                System.out.println("Cannot lease vehicles older than 3 years!");
                return;
            }
            contract = new LeaseContract(date, name, email, vehicle);
        } else {
            System.out.println("Invalid choice. Returning to main menu.\n");
            return;
        }

        new ContractFileManager().saveContract(contract);
        dealership.removeVehicle(vin);
        new DealershipFileManager().saveDealership(dealership);

        System.out.println("\nContract processed successfully!");
        System.out.println("Total Price: $" + String.format("%.2f", contract.getTotalPrice()));
        System.out.println("Monthly Payment: $" + String.format("%.2f", contract.getMonthlyPayment()) + "\n");
    }
}

