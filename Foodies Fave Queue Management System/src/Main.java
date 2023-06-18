import java.util.Scanner;

public class Main {
    static Scanner scn = new Scanner(System.in);

    static String[] array1 = {"O", "O"};
    static String[] array2 = {"O", "O", "O"};
    static String[] array3 = {"O", "O", "O", "O", "O"};
    static String[] cusNameArray1={};
    static String[] cusNameArray2={};
    static String[] cusNameArray3={};

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
                    addCustomers();
                    break;
                case "103":
                case "RCQ":
                    removeCustomer();
                    break;
                case "104":
                case "PCQ":
                    removeServedCustomer();
                    break;
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
                    System.exit(0);

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

    public static void viewEmptyQueues() {

        if (array1[0] == "O") {
            System.out.println("Cashier 1 is empty");
        } else {
            System.out.println("Cashier 1 is busy");
        }

        if (array2[0] == "O") {
            System.out.println("Cashier 2 is empty");
        } else {
            System.out.println("Cashier 2 is busy");
        }

        if (array3[0] == "O") {
            System.out.println("Cashier 3 is empty");
        } else {
            System.out.println("Cashier 3 is busy");
        }
    }

    public static void addCustomers() {
/*        int count1 = 0;
        int count2 = 0;
        int count3 = 0;*/
        try {

            System.out.println("Enter customer name  :");
            String cusName = scn.next();

            if (array1[0] == "O") {
                array1[0] = "X";
                cusNameArray1[0]=cusName;
                System.out.println("Customer added to queue 1");
            } else if (array2[0] == "O") {
                array2[0] = "X";
                cusNameArray2[0]=cusName;
                System.out.println("Customer added to queue 2");
            } else if (array3[0] == "O") {
                array3[0] = "X";
                cusNameArray3[0]=cusName;
                System.out.println("Customer added to queue 3");
            } else {

                for (int i = 1; i < 5; i++) {
                    if (array1[i] == "O") {
                        array1[i] = "X";
                        System.out.println("Customer added to queue 1");
                        break;
                    } else if (array2[i] == "O") {
                        array2[i] = "X";
                        System.out.println("Customer added to queue 2");
                        break;
                    } else if (array3[i] == "O") {
                        array3[i] = "X";
                        System.out.println("Customer added to queue 3");
                        break;
                    } else {
                        System.out.println("All queues are full");
                    }
                }
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void removeCustomer() {
        int x=0;
        try {
            while(x<1) {
                System.out.println("Enter Cashier Number :");
                int cashNum = scn.nextInt();

                System.out.println("Enter the position of the Queue  :");
                int position = scn.nextInt();

                if (cashNum == 1) {
                    if (position - 1 < 2) {
                        if (array1[position - 1] == "O") {
                            System.out.println("There is no customer in this position");
                        } else {
                            array1[position - 1] = "O";
                            System.out.println("Removed customer from queue 1");
                        }
                        break;
                    } else {
                        System.out.println("Invalid Input");
                    }
                }
                if (cashNum == 2) {
                    if (position - 1 < 3) {
                        if (array2[position - 1] == "O") {
                            System.out.println("There is no customer in this position");
                        } else {
                            array2[position - 1] = "O";
                            System.out.println("Removed customer from queue 1");
                        }
                        break;
                    } else {
                        System.out.println("Invalid Input");
                    }
                }
                if (cashNum == 3) {
                    if (position - 1 < 5) {
                        if (array3[position - 1] == "O") {
                            System.out.println("There is no customer in this position");
                        } else if (array3[position - 1] == "X") {
                            array3[position - 1] = "O";
                            System.out.println("Removed customer from queue 1");
                        }
                        break;
                    } else {
                        System.out.println("Invalid Input");
                    }
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void removeServedCustomer(){
        try{
            System.out.println("Enter Cashier Number :");
            int cashNum = scn.nextInt();

            if(cashNum==1){
                array1[0]="O";
            }
            if(cashNum==2){
                array2[0]="O";
            }
            if(cashNum==3){
                array3[0]="O";
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}