import java.util.InputMismatchException;
import java.util.Scanner;

public class TextUI {
    GuestService guestService = new GuestService();

    public void readNewGuestData(Scanner sc) {
        try {
            System.out.println("Tworzymy nowego gościa: ");
            System.out.print("Podaj imię: ");
            String firstName = sc.next();
            System.out.print("Podaj nazwisko: ");
            String lastName = sc.next();
            System.out.print("Podaj wiek: ");
            int age = sc.nextInt();
            System.out.print("""
                Podaj płeć:
                    1. Mężczyzna.
                    2. Kobieta
                    """);
            int genderOption = sc.nextInt();
            if (genderOption != 1 && genderOption != 2) {
                throw new WrongOptionException("Wrong option in gender menu.");
            }
            Guest newGuest = guestService.createNewGuest(firstName, lastName, age, genderOption);

            System.out.println(newGuest.toString());
        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Use only numbers when choosing gender");
        }

    }
}
