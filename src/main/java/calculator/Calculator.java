package calculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.naming.spi.DirObjectFactory;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Calculator {

    private static Logger logger;

    public Calculator() {
        logger = LogManager.getLogger(Calculator.class);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.nextLine();
//        System.out.println("Press enter to start the application");

        Calculator calc = new Calculator();

        int choice = -1;

        while (choice != 0) {
            Calculator.printMenu();

            try {
                choice = sc.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("\nEnter a valid choice\n");
                continue;
            }

            int num1, res1;

            double num2, res2;

            switch (choice) {
                case 1:
                    do {
                        System.out.print("\nEnter a non-negative integer: ");
                        try {
                            num1 = sc.nextInt();

                            res1 = calc.factorial(num1);
                            if (res1 != -1) {
                                System.out.println("\nFactorial of " + num1 + " = " + res1);
                                break;
                            }
                        } catch (InputMismatchException ime) {
                            System.out.println("\nPlease enter a numeric value");
                        }

                        sc.nextLine(); // flush the buffer before taking the number again


                    } while (true);
                    break;
                case 2:
                    do {
                        System.out.print("\nEnter a non-negative number: ");
                        try {
                            num2 = sc.nextDouble();
                            res2 = calc.squareRoot(num2);
                            if (res2 != -1) {
                                System.out.println("\nSquare root of " + num2 + " = " + res2);
                                break;
                            }
                        } catch (InputMismatchException ime) {
                            System.out.println("\nPlease enter a numeric value");
                        }
                        sc.nextLine(); // flush the buffer before taking the number again

                    } while (true);
                    break;
                case 3:
                    do {
                        System.out.print("\nEnter a non-negative integer: ");
                        try{
                            num2 = sc.nextDouble();
                            res2 = calc.naturalLog(num2);

                            if (res2 != -1) {
                                System.out.println("\nNatural log of " + num2 + " = " + res2);
                                break;
                            }
                        }catch (InputMismatchException ime) {
                            System.out.println("\nPlease enter a numeric value");
                        }

                        sc.nextLine(); // flush the buffer before taking the number again
                    } while (true);
                    break;
                case 4:
                    double x = Double.NaN,b = Double.NaN;

                    while(Double.isNaN(x))
                    {
                        System.out.print("\nEnter the first number: ");
                        try{
                            x = sc.nextDouble();
                        }catch (InputMismatchException ime) {
                            System.out.println("\nPlease enter a numeric value");
                        }
                        sc.nextLine(); // flush the buffer before taking the number again
                    }

                    while(Double.isNaN(b))
                    {
                        System.out.print("\nEnter the second number: ");
                        try{
                            b = sc.nextDouble();
                        }catch (InputMismatchException ime) {
                            System.out.println("\nPlease enter a numeric value");
                        }
                        sc.nextLine(); // flush the buffer before taking the number again
                    }

                    res2 = calc.Power(x,b);
                    System.out.println("\n" + x + " raised to " + b + " = " + res2);
                    break;
                case 0:
                    System.out.println("\nClosing the application...");
                    break;
                default:
                    System.out.println("\nPlease select one of the given options");
            }


        }

        sc.close();
        System.out.println("\nBye");
    }

    public static void printMenu() {
        System.out.println("Scientific Calculator");
        System.out.println("--------------------------");
        System.out.println("Select one of the above options");

        System.out.println("1. Compute Factorial of a number");
        System.out.println("2. Compute square root of a number");
        System.out.println("3. Compute natural log of a number");
        System.out.println("4. Compute power of a number to another");

        System.out.println("0. Close the application");

        System.out.print("\nEnter your choice: ");
    }


    public int factorial(int num) {
        int res = 0;

        try {
            if (num < 0) {
                logger.info("[FACTORIAL] [FAILED] " + num);
                logger.info("[RESULT - FACTORIAL] [INVALID INPUT] -1");
                res = -1;
                throw new IllegalArgumentException("Can't find factorial of negative integer");
            } else {
                if (num == 0) {
                    res = 1;
                } else {
                    res = 1;
                    for (int i = 1; i <= num; i++) {
                        res *= i;
                    }
                }

                logger.info("[FACTORIAL] [SUCCESS] " + num);
                logger.info("[RESULT - FACTORIAL] " + res);

            }
        } catch (IllegalArgumentException iae) {
            // Message for user
            System.out.println(iae.getMessage() + ", Try Again");
        }

        return res;
    }

    public double squareRoot(double num) {
        double res = 0;

        try{
            if (num < 0) {
                logger.info("[SQUARE ROOT] [FAILED] " + num);
                logger.info("[RESULT - SQUARE ROOT] [INVALID INPUT] -1");
                res = -1;
                throw new IllegalArgumentException("Can't find square root of negative numbers");
            }
            else{
                res = Math.sqrt(num);

                logger.info("[SQUARE ROOT] [SUCCESS] " + num);
                logger.info("[RESULT - SQUARE ROOT] " + res);
            }
        }catch (IllegalArgumentException iae){
            // Message for user
            System.out.println(iae.getMessage() + ", Try Again");
        }

        return res;
    }


    public double naturalLog(double num) {
        double res = 0;

        try {
            if (num <= 0) {
                res = -1;
                logger.info("[LOG] [FAILED] " + num);
                logger.info("[RESULT - LOG] [INVALID INPUT] -1");
                throw new IllegalArgumentException("Can't find log of non-positive number");
            } else {
                res = Math.log(num);
                logger.info("[LOG] [SUCCESS] " + num);
                logger.info("[RESULT - LOG] " + res);
            }
        } catch (IllegalArgumentException iae) {
            // Message for user
            System.out.println(iae.getMessage() + ", Try Again");
        }
        return res;
    }

    public double Power(double num1, double num2) {
        double res = Math.pow(num1, num2);

        logger.info("[POWER] [SUCCESS] " + num1 + " " + num2);
        logger.info("[RESULT - POWER] " + res);

        return res;
    }

}