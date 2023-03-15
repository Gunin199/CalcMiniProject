package calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello math world!");
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            System.out.print("Enter 1st number: ");
            int num1 = sc.nextInt();

            System.out.print("Enter 2nd number: ");
            int num2 = sc.nextInt();

            System.out.println("Sum = " + (num2 + num1));

            boolean shouldContinue = true;

            System.out.println("Want to exit(y/n) ?");
            if(sc.next().equals("y"))
            {
                break;
            } else if (sc.next().equals("n")) {
                continue;
            }
        }
        sc.close();
        System.out.println("Bye");
    }
}