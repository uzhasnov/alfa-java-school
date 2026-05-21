package ru.alfabank.homework6.delivery.model;

public class Parcel {

    private String recipient;
    private String address;
    protected double weight;
    String trackNumber;

    public Parcel(String recipient, String address, double weight, String trackNumber) {
        this.recipient = recipient;
        this.address = address;
        this.weight = weight;
        this.trackNumber = trackNumber;
    }

    public Parcel() {
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
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
                        Recipient: %s
                        Address: %s
                        Weight: %s
                        Track number: %s
                        """,
                        recipient,
                        address,
                        weight,
                        trackNumber
        );
    }
}
