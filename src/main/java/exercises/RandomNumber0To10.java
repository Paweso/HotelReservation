package exercises;

import java.util.Random;
import java.util.Scanner;

public class RandomNumber0To10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int rand = random.nextInt(11);
        System.out.println(rand);
        System.out.println("Podaj cyfrę między 0 a 10: ");
        int number = 0;
        try{
            number = sc.nextInt();
        } catch (Exception e){
            System.out.println("Nieprawidłowe wyrażenie");
        }
        if (rand == number){
            System.out.println("Brawo");
        }else {
            System.out.println("Nie trafiłeś");
        }

    }
}
