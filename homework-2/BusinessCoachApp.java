import java.util.Random;

public class BusinessCoachApp {
    public static void main(String[] args) {
        Random random = new Random();
        int guestAge = random.nextInt(84) + 6;
        double guestMoney = random.nextDouble(200_001.0) + 100.0;

        boolean isGuestInvited = true;
        boolean isGuestBlackListed = false;

        boolean isGuestOldEnough = guestAge >= 18;
        boolean isGuestInvitedAndHasEnoughMoney = guestMoney >= 50_000.0 && isGuestInvited;
        boolean isGuestAllowed = isGuestOldEnough && isGuestInvitedAndHasEnoughMoney && !isGuestBlackListed;

        System.out.printf("Участник подходит под критерии: %b\n",  isGuestAllowed);

        double mandatoryDonation = guestMoney * 0.075;

        System.out.printf("Обязательный добровольный взнос: %.2f",  mandatoryDonation);
    }
}
