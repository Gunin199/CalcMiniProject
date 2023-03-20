package calculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;


public class App {

    private static Logger logger;

    public App()
    {
        logger = LogManager.getLogger(App.class);
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        System.out.println("Press enter to start the application");

        while(true)
        {

        }

        sc.close();
        System.out.println("Bye");
    }

    public static void printMenu()
    {
        System.out.println("Scientific Calculator");
        System.out.println("--------------------------");
        System.out.println("Select one of the above options");

        System.out.println("1. Compute Factorial of a number");
        System.out.println("2. Compute square root of a number");
        System.out.println("3. Compute natural log of a number");
        System.out.println("4. Compute power of a number to another");

        System.out.println("Any key to Exit the app");
    }

}