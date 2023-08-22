import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private static TextUI textUI = new TextUI();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String hotelName = "Overlook";
        int systemVersion = 1;
        boolean isDeveloperVersion = false;

        showWelcomeInformationSystem(hotelName, systemVersion, isDeveloperVersion);

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
            case 1 -> textUI.readNewGuestData(sc);
            case 2 -> {
                Room newRoom = createNewRoom(sc);
                System.out.println(newRoom);
            }
            case 3 -> System.out.println("Wybrano opcję 3.");
            default -> throw new WrongOptionException("Wrong option in main menu");
        }
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
