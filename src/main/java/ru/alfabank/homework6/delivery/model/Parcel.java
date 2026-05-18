package ru.alfabank.homework6.delivery.model;

public class Parcel {

    private String name;
    private String address;
    protected double weight;
    String trackNumber;

    public Parcel(String name, String address, double weight, String trackNumber) {
        this.name = name;
        this.address = address;
        this.weight = weight;
        this.trackNumber = trackNumber;
    }

    public Parcel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double calculateDeliveryPrice() {
        return 100 + weight * 30;
    }

    public void printInfo() {
        System.out.printf("""
                        Parcel name: %s
                        Address: %s
                        Weight: %s
                        Track number: %s
                        """,
                        name,
                        address,
                        weight,
                        trackNumber
        );
    }
}
