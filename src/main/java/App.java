import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        showWelcomeInformationSystem();
        int option = getActionFromUser(sc);

        switch (option) {
            case 1 -> createNewGuest(sc);
            case 2 -> createNewRoom(sc);
            case 3 -> System.out.println("Wybrano opcję 3.");
            default -> System.out.println("Błąd. Niepoprawny wybór.");
        }
    }

    private static void showWelcomeInformationSystem() {
        WelcomeInformation welcomeInformation = new WelcomeInformation();
        String hotelName = "Overlook";
        int systemVersion = 1;
        boolean isDeveloperVersion = false;
        welcomeInformation.printInfo(hotelName, systemVersion, isDeveloperVersion);
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

    private static void createNewGuest(Scanner sc) {
        System.out.println("Tworzymy nowego gościa: ");
        try {
            System.out.print("Podaj imię: ");
            String firstName = sc.next();
            System.out.print("Podaj nazwisko: ");
            String lastName = sc.next();
            System.out.print("Podaj wiek: ");
            int age = sc.nextInt();
            Guest createGuest = new Guest(firstName, lastName, age);
            System.out.println(createGuest);
        } catch (Exception e) {
            System.out.println("Niewłaściwa forma wieku!");
        }
    }

    private static void createNewRoom(Scanner sc) {
        System.out.println("Tworzymy nowy pokój: ");
        try {
            System.out.print("Podaj numer pokoju: ");
            int number = sc.nextInt();
            System.out.print("Podaj ilość łóżek: ");
            int beds = sc.nextInt();
            Room createRoom = new Room(number, beds);
            System.out.println(createRoom);
        } catch (Exception e) {
            System.out.println("Niewłaściwa forma liczb!");
        }
    }
}
