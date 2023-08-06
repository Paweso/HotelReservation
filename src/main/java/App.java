import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        String hotelName = "Overlook";
        int systemVersion = 1;
        boolean isDeveloperVersion = true;

        System.out.print("Witaj w systemie rezerwacji dla hotelu ");
        System.out.println(hotelName);
        System.out.print("Aktualna wersja systemu: ");
        System.out.println(systemVersion);
        System.out.print("Wersja developerska: ");
        System.out.println(isDeveloperVersion);
        System.out.println("\n====================\n");

        Scanner sc = new Scanner(System.in);

        System.out.println("1. Dodaj nowego gościa");
        System.out.println("2. Dodaj nowy pokój");
        System.out.println("Wybierz opcję: ");


    }
}
