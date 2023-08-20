package exercises;

public class Silnia {
    public static void main(String[] args) {

        System.out.println(factorialIter(5));
        System.out.println(factorialRec(5));
    }

    public static int factorialRec(int n) {
        if (n == 1)
            return 1;

        return n * factorialRec(n - 1);
    }

    public static int factorialIter(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }
}
