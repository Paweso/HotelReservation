import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String hotelName = "Overlook";
        int systemVersion = 1;
        boolean isDeveloperVersion = false;

        showWelcomeInformationSystem(hotelName, systemVersion, isDeveloperVersion);

        try {
            int option = getActionFromUser(sc);
            showActionResultFromUser(option, sc);
        } catch (WrongOptionException e) {
            System.out.println("Wystąpił niespodziewany błąd!");
            System.out.println("Kod błędu: " + e.getCode());
            System.out.println("Komunikat błędu: " + e.getMessage());
        } catch (OnlyNumberException e) {
            System.out.println("Wystąpił niespodziewany błąd!");
            System.out.println("Kod błędu: " + e.getCode());
            System.out.println("Komunikat błędu: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Wystąpił niespodziewany błąd!");
            System.out.println("Nieznany kod błędu!");
            System.out.println("Komunikat błędu: " + e.getMessage());
        }
    }

    private static void showWelcomeInformationSystem(String hotelName, int systemVersion, boolean isDeveloperVersion) {
        new WelcomeInformation().printInfo(hotelName, systemVersion, isDeveloperVersion);
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

    private static void showActionResultFromUser(int option, Scanner sc) {
        switch (option) {
            case 1 -> {
                Guest newGuest = createNewGuest(sc);
                System.out.println(newGuest);
            }
            case 2 -> {
                Room newRoom = createNewRoom(sc);
                System.out.println(newRoom);
            }
            case 3 -> System.out.println("Wybrano opcję 3.");
            default -> throw new WrongOptionException("Wrong option in main menu");
        }
    }

    private static Guest createNewGuest(Scanner sc) {

        System.out.println("Tworzymy nowego gościa: ");
        System.out.print("Podaj imię: ");
        String firstName = sc.next();
        System.out.print("Podaj nazwisko: ");
        String lastName = sc.next();
        int age;
        try {
            System.out.print("Podaj wiek: ");
            age = sc.nextInt();
        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Wrong form of age!");
        }
        System.out.print("""
                Podaj płeć:
                    1. Mężczyzna.
                    2. Kobieta
                    """);
        Gender gender;
        try {
            int genderOption = sc.nextInt();
            gender = switch (genderOption) {
                case 1 -> Gender.MALE;
                case 2 -> Gender.FEMALE;
                default -> throw new WrongOptionException("Wrong option in gender menu.");
            };
        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Wrong form of number!");
        }
        return new Guest(firstName, lastName, age, gender);
    }

    private static Room createNewRoom(Scanner sc) {
        try {
            System.out.println("Tworzymy nowy pokój: ");
            System.out.print("Podaj numer pokoju: ");
            int number = sc.nextInt();
            BedType[] bedTypes = chooseBedType(sc);
            return new Room(number, bedTypes);
        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Use numbers when creating new room!");
        }
    }

    private static BedType[] chooseBedType(Scanner sc) {
        System.out.println("Podaj ilość łóżek: ");
        int bedNumber = sc.nextInt();
        BedType[] bedTypes = new BedType[bedNumber];

        for (int i = 0; i < bedTypes.length; i++) {
            System.out.print("""
                    Podaj typ łóżka:
                        1. Pojedyńcze.
                        2. Podwójne.
                        3. Królewskie.
                        """);
            int bedTypeOption = sc.nextInt();
            BedType bedType = switch (bedTypeOption) {
                case 1 -> BedType.SINGLE;
                case 2 -> BedType.DOUBLE;
                case 3 -> BedType.KING_SIZE;
                default -> throw new WrongOptionException("Wrong option when selecting bed type!");
            };
            bedTypes[i] = bedType;
        }
        return bedTypes;
    }
}
