package ru.alfabank.homework6.delivery.model;

public class ExpressParcel extends Parcel {

    private int deliveryHours;

    public ExpressParcel(String name, String address, double weight, String trackNumber, int deliveryHours) {
        super(name, address, weight, trackNumber);
        this.deliveryHours = deliveryHours;
    }

    public double calculateDeliveryPrice() {
        return deliveryHours < 24 ? 500 + super.calculateDeliveryPrice() : super.calculateDeliveryPrice();
    }

    public void printInfo() {
        super.printInfo();
        System.out.printf("Delivery deadline: %d hours\n", deliveryHours);
    }
}
