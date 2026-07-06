package ru.alfabank.homework12;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        String[] flights = { "SU-123", "TK-777", "KC-909", "AE-404" };

        BaggageDropDesk desk = new BaggageDropDesk(Arrays.stream(flights).toList());

        try {
            desk.checkInBaggage("Ivanov Vladimir", "SU-123", 18);
            desk.checkInBaggage("Petrov Vladislav", "TK-666", 18);
            desk.checkInBaggage("Ivanova Anna", "TK-777", 43);
            desk.checkInBaggage("Petrova Olga", "AE-404", 15);
            desk.checkInBaggage(null, "KC-909", 15);
            desk.checkInBaggage("Petrova Olga", "KC-909", -15);
        } catch (FlightNotFoundException |
                 OverweightBaggageException |
                 BaggageTagPrintException |
                 InvalidPassengerNameException |
                 InvalidBaggageWeightException e) {
            System.out.println(e.getMessage());
        }
    }
}
