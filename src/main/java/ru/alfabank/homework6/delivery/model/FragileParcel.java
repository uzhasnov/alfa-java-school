package ru.alfabank.homework6.delivery.model;

public class FragileParcel extends Parcel {

    private boolean requiresCarefulDelivery;

    public FragileParcel(String name, String address, double weight, String trackId, boolean requiresCarefulDelivery) {
        super(name, address, weight, trackId);
        this.requiresCarefulDelivery = requiresCarefulDelivery;
    }

    public double calculateDeliveryPrice() {
        return 200 + super.calculateDeliveryPrice();
    }

    public void printInfo() {
        super.printInfo();
        System.out.printf("Handle with care: %b\n", requiresCarefulDelivery);
    }
}
