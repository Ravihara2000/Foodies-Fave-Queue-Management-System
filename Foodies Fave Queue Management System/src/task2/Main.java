package task2;

import java.io.File;
import java.util.Scanner;

public class Main {
    static Scanner scn = new Scanner(System.in);

    static String[] array1 = {"X", "X","X"};
    static String[] array2 = {"X", "X", "X","X"};
    static String[] array3 = {"X", "X", "X", "X", "X","X"};
    static String[] cusNameArray1=new String[2];
    static String[] cusNameArray2=new String[3];
    static String[] cusNameArray3=new String[5];
    static File logFile = new File("cashier-data.txt");
    static int burgerAmount=50;

    public static void main(String[] args) {
        int x = 0;


        while (x < 1) {
            displayMenu();

            System.out.println("Enter Your Option  :");
            String opt = scn.next();
            opt = opt.toUpperCase();

            switch (opt) {
                case "100":
                case "VFQ":
                    viewAllQueues();
                    break;
                case "101":
                case "VEQ":
                    viewEmptyQueues();
                    break;
                case "102":
                case "ACQ":
                    //addCustomers();
                    break;
                case "103":
                case "RCQ":
                    //removeCustomer();
                    break;
                case "104":
                case "PCQ":
                    //removeServedCustomer();
                    break;
                case "105":
                case "VCS":
                    //sortedCustomer();
                    break;
                case "106":
                case "SPD":
                    //storeData();
                    break;
                case "107":
                case "LPD":
                    //loadDataFromFile();
                    break;
                case "108":
                case "STK":
                    //viewRemainingBurgers();
                    break;
                case "109":
                case "AFS":
                    //addBurgersStock();
                    break;
                case "999":
                case "EXT":
                    System.exit(0);
                default:
                    System.out.println("Invalid input");

            }

        }

    }

    public static void displayMenu() {
        System.out.println("\n100 or VFQ: View all Queues.\n" +
                "101 or VEQ: View all Empty Queues.\n" +
                "102 or ACQ: Add customer to a Queue.\n" +
                "103 or RCQ: Remove a customer from a Queue. (From a specific location)\n" +
                "104 or PCQ: Remove a served customer.\n" +
                "105 or VCS: View Customers Sorted in alphabetical order (Do not use library sort routine)\n" +
                "106 or SPD: Store Program Data into file.\n" +
                "107 or LPD: Load Program Data from file.\n" +
                "108 or STK: View Remaining burgers Stock.\n" +
                "109 or AFS: Add burgers to Stock.\n" +
                "999 or EXT: Exit the Program");
        System.out.println("-------------------------------------");
    }
    public static void viewAllQueues() {
        System.out.println("*****************");
        System.out.println("*\tCashiers\t*");
        System.out.println("*****************");


        for (int i = 0; i < 10; i++) {
            if (i < 2) {
                System.out.print(array1[i] + "\t");
            } else {
                System.out.print("\t");
            }

            if (i < 3) {
                System.out.print(array2[i] + "\t");
            } else {
                System.out.print("\t");
            }

            if (i < 5) {
                System.out.print(array3[i]);
            }

            System.out.println();
        }


    }

    public static void viewEmptyQueues() {

        if (array1[0] == "X") {
            System.out.println("Cashier 1 is empty");
        } else {
            System.out.println("Cashier 1 is busy");
        }

        if (array2[0] == "X") {
            System.out.println("Cashier 2 is empty");
        } else {
            System.out.println("Cashier 2 is busy");
        }

        if (array3[0] == "X") {
            System.out.println("Cashier 3 is empty");
        } else {
            System.out.println("Cashier 3 is busy");
        }
    }





}
