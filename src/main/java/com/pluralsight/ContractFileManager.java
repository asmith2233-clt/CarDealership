package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ContractFileManager {

    private static final String CONTRACT_FILE = "contracts.csv";

    public void saveContract(Contract contract) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(CONTRACT_FILE, true))) {

            Vehicle v = contract.getVehicleSold();
            String baseInfo = String.format("%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f",
                    (contract instanceof SalesContract) ? "SALE" : "LEASE",
                    contract.getDate(),
                    contract.getCustomerName(),
                    contract.getCustomerEmail(),
                    v.getVinNumber(),
                    v.getYear(),
                    v.getMake(),
                    v.getModel(),
                    v.getVehicleType(),
                    v.getColor(),
                    v.getOdometer(),
                    v.getPrice());

            if (contract instanceof SalesContract) {
                SalesContract sc = (SalesContract) contract;
                pw.printf("%s|%.2f|%b|%.2f|%.2f%n",
                        baseInfo,
                        sc.getTotalPrice(),
                        sc.isFinanced(),
                        sc.getTotalPrice(),
                        sc.getMonthlyPayment());
            } else if (contract instanceof LeaseContract) {
                LeaseContract lc = (LeaseContract) contract;
                pw.printf("%s|%.2f|%.2f%n",
                        baseInfo,
                        lc.getTotalPrice(),
                        lc.getMonthlyPayment());
            }

        } catch (IOException e) {
            System.out.println("Error saving contract: " + e.getMessage());
        }
    }
}
