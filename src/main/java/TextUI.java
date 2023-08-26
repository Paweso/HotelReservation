import java.util.InputMismatchException;
import java.util.Scanner;

public class TextUI {
    GuestService guestService = new GuestService();
    RoomService roomService = new RoomService();
    Scanner sc = new Scanner(System.in);

    public void showWelcomeInformationSystem(String hotelName, int systemVersion, boolean isDeveloperVersion) {
        new WelcomeInformation().printInfo(hotelName, systemVersion, isDeveloperVersion);
    }

    public void showMainMenu() {
        try {
            int option = getActionFromUser(sc);
            showActionResultFromUser(option, sc);
        } catch (WrongOptionException | OnlyNumberException e) {
            System.out.println("Wystąpił niespodziewany błąd!");
            System.out.println("Kod błędu: " + e.getCode());
            System.out.println("Komunikat błędu: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Wystąpił niespodziewany błąd!");
            System.out.println("Nieznany kod błędu!");
            System.out.println("Komunikat błędu: " + e.getMessage());
        } finally {
            System.out.println("Wychodzę z aplikacji!");
        }
    }

    private static int getActionFromUser(Scanner sc) {

        System.out.println("1. Dodaj nowego gościa");
        System.out.println("2. Dodaj nowy pokój");
        System.out.println("3. Wyszukaj gościa");
        System.out.println("Wybierz opcję: ");

        int option;
        try {
            option = sc.nextInt();
        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Use only numbers in main menu! ");
        }
        return option;
    }

    private void showActionResultFromUser(int option, Scanner sc) {

        switch (option) {
            case 1 -> readNewGuestData(sc);
            case 2 -> readNewRoomData(sc);
            case 3 -> System.out.println("Wybrano opcję 3.");
            default -> throw new WrongOptionException("Wrong option in main menu");
        }
    }

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

    public void readNewRoomData(Scanner sc) {
        try {
            System.out.println("Tworzymy nowy pokój: ");
            System.out.print("Podaj numer pokoju: ");
            int number = sc.nextInt();
            int[] bedTypes = chooseBedType(sc);
            Room newRoom = roomService.createNewRoom(number, bedTypes);
            System.out.println(newRoom.toString());
        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Use numbers when creating new room!");
        }
    }

    private int[] chooseBedType(Scanner sc) {
        System.out.println("Podaj ilość łóżek: ");
        int bedNumber = sc.nextInt();
        int[] bedTypes = new int[bedNumber];

        for (int i = 0; i < bedTypes.length; i++) {
            System.out.print("""
                    Podaj typ łóżka:
                        1. Pojedyńcze.
                        2. Podwójne.
                        3. Królewskie.
                        """);
            int bedTypeOption = sc.nextInt();

            bedTypes[i] = bedTypeOption;
        }
        return bedTypes;
    }
}
