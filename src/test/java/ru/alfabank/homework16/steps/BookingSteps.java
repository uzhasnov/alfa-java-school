package ru.alfabank.homework16.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.PendingException;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.То;

public class BookingSteps {

    @Дано("в ресторане есть свободный стол на {int} человека")
    public void checkIfFreeTableExist(int arg0) {
        System.out.println("checkIfFreeTableExist()");
    }

    @Если("клиент пытается забронировать столик на {int} человека")
    public void clientTryToBookATable(int arg0) {
        System.out.println("clientTryToBookATable()");
    }

    @То("стол успешно бронируется клиентом")
    public void bookTable() {
        System.out.println("bookTable()");
    }

    @То("происходит отказ в бронировании стола клиентом")
    public void rejectBooking() {
        System.out.println("rejectBooking()");
    }

    @И("у клиента забронирован стол")
    public void ifClientHasBooking() {
        System.out.println("ifClientHasBooking()");
    }

    @Если("клиент отменяет бронирование")
    public void requestToAbortBooking() {
        System.out.println("requestToAbortBooking()");
    }

    @То("бронирование отменяется")
    public void abortBooking() {
        System.out.println("abortBooking()");
    }

    @Дано("В ресторане есть столик на {string} человек")
    public void isTableAvailable(String arg0) {
        System.out.println("isTableAvailable()");
    }

    @Если("клиент пытается забронировать столик на {string} гостей")
    public void tryToBookTable(String arg0) {
        System.out.println("tryToBookTable()");
    }

    @То("бронирование {string}")
    public void confirmBooking(String arg0) {
        System.out.println("confirmBooking()");
    }

    @Дано("В ресторане есть столик {string} на {string} человек")
    public void isTableAvailable(String arg0, String arg1, DataTable table) {
        table.asMap().forEach((k, v) -> System.out.println(k + ": " + v));
    }


    @Если("гость оставляет пожелание к брони")
    public void produceSpecialNote(String arg0) {
        System.out.println(arg0);
    }

    @То("особое пожелание учитывается при бронировании")
    public void processSpacialNote() {
        System.out.println("processSpacialNote()");
    }

    @Если("^гость (увеличивает|уменьшает) бронь на 2 человека$")
    public void changeBookingByClient() {
        System.out.println("changeBookingByClient()");
    }
}
