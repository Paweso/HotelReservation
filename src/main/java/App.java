import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String hotelName = "Overlook";
        int systemVersion = 1;
        boolean isDeveloperVersion = false;

        showWelcomeInformationSystem(hotelName, systemVersion, isDeveloperVersion);
        int option = getActionFromUser(sc);

        showActionResultFromUser(option, sc);
    }

    private static void showWelcomeInformationSystem(String hotelName, int systemVersion, boolean isDeveloperVersion) {
        new WelcomeInformation().printInfo(hotelName, systemVersion, isDeveloperVersion);
    }

    private static int getActionFromUser(Scanner sc) {
        System.out.println("1. Dodaj nowego gościa");
        System.out.println("2. Dodaj nowy pokój");
        System.out.println("3. Wyszukaj gościa");
        System.out.println("Wybierz opcję: ");

        int option = 0;
        try {
            option = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Niepoprawne dane wejściowe");
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
            default -> System.out.println("Błąd. Niepoprawny wybór.");
        }
    }

    private static Guest createNewGuest(Scanner sc) {
        try {
            System.out.println("Tworzymy nowego gościa: ");
            System.out.print("Podaj imię: ");
            String firstName = sc.next();
            System.out.print("Podaj nazwisko: ");
            String lastName = sc.next();
            System.out.print("Podaj wiek: ");
            int age = sc.nextInt();
            return new Guest(firstName, lastName, age);
        } catch (Exception e) {
            System.out.println("Niewłaściwa forma wieku!");
            return null;
        }
    }

    private static Room createNewRoom(Scanner sc) {
        try {
            System.out.println("Tworzymy nowy pokój: ");
            System.out.print("Podaj numer pokoju: ");
            int number = sc.nextInt();
            System.out.print("""
                    Podaj typ łóżek:
                        1. Pojedyńcze
                        2. Podwójne
                        3. Królewskie
                        """);
            int bedTypeOption = sc.nextInt();
            BedType bedType = switch (bedTypeOption) {
                case 2 -> BedType.DOUBLE;
                case 3 -> BedType.KING_SIZE;
                default -> BedType.SINGLE;
            };
            return new Room(number, bedType);
        } catch (Exception e) {
            System.out.println("Niewłaściwa forma liczb!");
            return null;
        }
    }
}
