package ru.alfabank.homework12;

import java.util.Arrays;
import java.util.List;

public class BaggageDropDesk {

    List<String> flights;

    public BaggageDropDesk(List<String> flights) {
        this.flights = flights;
    }

    public BaggageTicket checkInBaggage(String passengerName, String flightNumber, int baggageWeight)
            throws FlightNotFoundException, OverweightBaggageException, BaggageTagPrintException {

        if (passengerName == null || passengerName.isEmpty()) {
            throw new InvalidPassengerNameException("Имя пассажира не может быть пустым");
        }

        if (!flights.contains(flightNumber)) {
            throw new FlightNotFoundException("Указанный рейс не существует");
        }

        if (baggageWeight < 0) {
            throw new InvalidBaggageWeightException("Вес багажа не может быть отрицательным");
        }

        if (baggageWeight > 23) {
            throw new OverweightBaggageException("Багаж слишком тяжёлый");
        }

        if (flightNumber.equals("AE-404")) {
            throw new BaggageTagPrintException("Проблема с печалью багажной бирки");
        }

        System.out.println("Необходимо уплатить налог за слишком правильные введенные данные");
        return new BaggageTicket(passengerName, flightNumber, baggageWeight);
    }
}
