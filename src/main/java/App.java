import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        WelcomeInformation welcomeInformation = new WelcomeInformation();
        String hotelName = "Overlook";
        int systemVersion = 1;
        boolean isDeveloperVersion = false;
        welcomeInformation.printInfo(hotelName, systemVersion, isDeveloperVersion);

        Scanner sc = new Scanner(System.in);

        System.out.println("1. Dodaj nowego gościa");
        System.out.println("2. Dodaj nowy pokój");
        System.out.println("3. Wyszukaj gościa");
        System.out.println("Wybierz opcję: ");

        int option = sc.nextInt();

        if (option == 1) {
            System.out.println("Wybrano opcję 1.");
        } else if (option == 2) {
            System.out.println("Wybrano opcję 2.");
        } else if (option == 3) {
            System.out.println("Wybrano opcję 3.");
        } else {
            System.out.println("Błąd. Niepoprawny wybór.");
        }
    }
}
