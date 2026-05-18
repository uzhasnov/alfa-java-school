package ru.alfabank.homework6.delivery.app;

import ru.alfabank.homework6.delivery.model.ExpressParcel;
import ru.alfabank.homework6.delivery.model.FragileParcel;
import ru.alfabank.homework6.delivery.model.Parcel;
import ru.alfabank.homework6.delivery.service.ParcelService;

public class Main {
    public static void main(String[] args) {

        Parcel ordinaryParcel = new Parcel(
                "Иванов И.И.",
                "д. Кукуево",
                30.0,
                "32562346"
        );

        FragileParcel fragileParcel = new FragileParcel(
                "Петров А.С.",
                "г. Сочи",
                1500.0, "32562347",
                true
        );

        ExpressParcel expressParcel = new ExpressParcel(
                "Сидоров К.Ю.",
                "г. Москва",
                50.0,
                "32562348",
                12);

        Parcel unknownParcel = new Parcel();

        Parcel[] parcels = {
                ordinaryParcel,
                fragileParcel,
                expressParcel,
                unknownParcel
        };

        ParcelService parcelService = new ParcelService();
        parcelService.printParcelsReport(parcels);
    }
}
