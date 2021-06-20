package com.uitest.uiprototype.model;

public class ItemModel {
    private int image, seat;
    private double distance, rentalFee, mileageFee;
    private String name, licensePlate;

    public ItemModel() {}

    public ItemModel(int image, String name, String licensePlate, int seat, double distance, double rentalFee, double mileageFee) {
        this.image = image;
        this.name = name;
        this.licensePlate = licensePlate;
        this.seat = seat;
        this.distance = distance;
        this.rentalFee = rentalFee;
        this.mileageFee = mileageFee;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getRentalFee() {
        return rentalFee;
    }

    public void setRentalFee(double rentalFee) {
        this.rentalFee = rentalFee;
    }

    public double getMileageFee() {
        return mileageFee;
    }

    public void setMileageFee(double mileageFee) {
        this.mileageFee = mileageFee;
    }
}
