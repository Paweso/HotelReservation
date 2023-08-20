package exercises;

import java.util.Scanner;

public class OperationsOnArrayElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Podaj ilość ilość liczb: ");
        int elements = sc.nextInt();

        System.out.println("Podaj liczby: ");

        int[] data = new int[elements];

        for (int i = 0; i < data.length; i++) {
            data[i] = sc.nextInt();
        }

        int sum = getSum(data);
        System.out.println("Wynik sumowania tablicy: " + sum);

        int min = getMinOfArray(data);
        System.out.print("Minimum to: " + min);
    }

    private static int getSum(int[] data) {

        int sum = 0;
        for (int datum : data) {
            sum += datum;
        }
        return sum;
    }

    private static int getMinOfArray(int[] data) {
        int min = data[0];
        for (int datum : data) {
            if (datum < min) {
                min = datum;
            }
        }
        return min;
    }
}
