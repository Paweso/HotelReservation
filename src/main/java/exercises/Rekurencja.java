package exercises;

public class Rekurencja {
    public static void main(String[] args) {
//        System.out.println(sumaRekursywna(5));
//        licznikIteracyjny(7);
        licznikRekurencyjny(5);
    }

    private static int sumaRekursywna(int i) {
        if (i < 1)
            return 0;
        return i + sumaRekursywna(i - 1);
    }

    public static void licznikIteracyjny(int n) {
        while (n > 0)
            System.out.println(n--);
    }

    public static void licznikRekurencyjny(int n) {
        if (n == 0)
            return;
        System.out.println(n);
        licznikRekurencyjny(--n);

    }
}
