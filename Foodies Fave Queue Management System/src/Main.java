import java.util.Scanner;

public class Main {
    static Scanner scn = new Scanner(System.in);

    static String [] array1 = {"O","O"};
    static String [] array2 = {"O","O","O"};
    static String [] array3 = {"O","O","O","O","O"};
    public static void main(String[] args) {
        int x=0;


        while(x<1){
            displayMenu();

            System.out.println("Enter Your Option  :\n");
            String opt = scn.next();
            opt=opt.toUpperCase();

            switch (opt){
                case "100":
                case "VFQ":
                    viewAllQueues();
                case "101":
                case "VEQ":
                case "102":
                case "ACQ":
                case "103":
                case "RCQ":
                case "104":
                case "PCQ":
                case "105":
                case "VCS":
                case "106":
                case "SPD":
                case "107":
                case "LPD":
                case "108":
                case "STK":
                case "109":
                case "AFS":
                case "999":
                case "EXT":

            }

        }

    }

    public static void displayMenu(){
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

    public static void viewAllQueues(){
        System.out.println("*****************");
        System.out.println("*\tCashiers\t*");
        System.out.println("*****************");
        int maxLength = Math.max(Math.max(array1.length, array2.length), array3.length);

        for (int i = 0; i < maxLength; i++) {
            if (i < array1.length) {
                System.out.print(array1[i] + "\t");
            } else {
                System.out.print("\t");
            }

            if (i < array2.length) {
                System.out.print(array2[i] + "\t");
            } else {
                System.out.print("\t");
            }

            if (i < array3.length) {
                System.out.print(array3[i]);
            }

            System.out.println();
        }


    }
}