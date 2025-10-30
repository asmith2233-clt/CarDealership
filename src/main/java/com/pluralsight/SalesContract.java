package com.pluralsight;

public class SalesContract extends Contract {
    private static final double SALES_TAX_RATE = 0.05;
    private static final double RECORDING_FEE = 100.0;

    private double processingFee;
    private boolean isFinanced;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, boolean isFinanced) {
        super(date, customerName, customerEmail, vehicleSold);
        this.isFinanced = isFinanced;
        this.processingFee = (vehicleSold.getPrice() < 10000) ? 295.0 : 495.0;
    }

    @Override
    public double getTotalPrice() {
        double salesTax = getVehicleSold().getPrice() * SALES_TAX_RATE;
        return getVehicleSold().getPrice() + salesTax + RECORDING_FEE + processingFee;
    }

    @Override
    public double getMonthlyPayment() {
        if (!isFinanced) return 0;

        double price = getTotalPrice();
        double rate;
        int months;

        if (getVehicleSold().getPrice() >= 10000) {
            rate = 0.0425 / 12;  // 4.25% yearly → monthly
            months = 48;
        } else {
            rate = 0.0525 / 12;  // 5.25% yearly → monthly
            months = 24;
        }

        // standard loan payment formula
        return (price * rate) / (1 - Math.pow(1 + rate, -months));
    }

    public boolean isFinanced() { return isFinanced; }
}
