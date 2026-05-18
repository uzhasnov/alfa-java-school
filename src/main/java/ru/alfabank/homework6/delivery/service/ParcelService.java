package ru.alfabank.homework6.delivery.service;

import ru.alfabank.homework6.delivery.model.Parcel;

public class ParcelService {
    public void printParcelsReport(Parcel[] parcels) {
        for (Parcel parcel : parcels) {
            parcel.printInfo();
            System.out.printf("Delivery price: %s\n", parcel.calculateDeliveryPrice());
            System.out.println();
        }
    }
}
