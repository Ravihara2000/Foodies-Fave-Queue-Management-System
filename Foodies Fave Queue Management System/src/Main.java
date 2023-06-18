import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int x=0;
        Scanner scn = new Scanner(System.in);

        while(x<1){
            displayMenu();
            System.out.println("Enter Your Option  \n");
            String opt = scn.next();
            opt=opt.toUpperCase();

            switch (opt){
                case "100":
                case "VFQ":
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
        System.out.println("100 or VFQ: View all Queues.\n" +
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
}