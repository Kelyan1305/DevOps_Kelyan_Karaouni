package com.example.DevOps_Kelyan_Karaouni;

public class Car {
    private String plateNumber;
    private String brand;
    private double price;
    private boolean isRented;
    private String beginRent;
    private String endRent;

    public Car(String plateNumber, String brand, double price) {
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.price = price;
        this.isRented = false;
    }

    // Getters
    public String getPlateNumber() { return plateNumber; }
    public String getBrand() { return brand; }
    public double getPrice() { return price; }
    public boolean isRented() { return isRented; }
    public String getBeginRent() { return beginRent; }
    public String getEndRent() { return endRent; }

    // Setters
    public void setRented(boolean rented) { this.isRented = rented; }
    public void setBeginRent(String beginRent) { this.beginRent = beginRent; }
    public void setEndRent(String endRent) { this.endRent = endRent; }
}

