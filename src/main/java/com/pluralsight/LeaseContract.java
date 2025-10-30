package com.pluralsight;

public class LeaseContract extends Contract {
    private static final double LEASE_RATE = 0.04 / 12;  // 4% annual → monthly
    private static final int LEASE_MONTHS = 36;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
    }

    @Override
    public double getTotalPrice() {
        double expectedEndingValue = getVehicleSold().getPrice() * 0.5;
        double leaseFee = getVehicleSold().getPrice() * 0.07;
        return getVehicleSold().getPrice() + leaseFee;
    }

    @Override
    public double getMonthlyPayment() {
        double expectedEndingValue = getVehicleSold().getPrice() * 0.5;
        double leaseFee = getVehicleSold().getPrice() * 0.07;
        double amountFinanced = getVehicleSold().getPrice() - expectedEndingValue + leaseFee;

        return (amountFinanced * LEASE_RATE) / (1 - Math.pow(1 + LEASE_RATE, -LEASE_MONTHS));
    }
}

