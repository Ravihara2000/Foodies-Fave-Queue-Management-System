package task2;

import java.io.File;
import java.util.Scanner;

public class main {
    static int c1=0;
    static Scanner scn = new Scanner(System.in);
    //    Object list for store all pump objects
    static FoodQueue[] foodArray = new FoodQueue[10];

    static String[] array1 = {"X", "X","X"};
    static String[] array2 = {"X", "X", "X","X"};
    static String[] array3 = {"X", "X", "X", "X", "X","X"};
    static String[] cusNameArray1=new String[2];
    static String[] cusNameArray2=new String[3];
    static String[] cusNameArray3=new String[5];
    static File logFile = new File("cashier-data.txt");
    static int burgerAmount=50;
    // Queue capacities
    static int queue1Capacity = 2;
    static int queue2Capacity = 3;
    static int queue3Capacity = 5;

    // Queue lengths
    static int queue1Length = 0;
    static int queue2Length = 0;
    static int queue3Length = 0;

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
                    viewRemainingBurgers();
                    break;
                case "109":
                case "AFS":
                    addBurgersStock();
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
        queueDetails();


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

    private static void queueDetails(){
        for (int i=0;i<3;i++){
            System.out.println("---------------------------- Cashier "+(i+1)+" -----------------------------");
            System.out.printf("%15s | %15s | %15s\n", "First Name", "Second Name", "No Of Burgers");
            System.out.println("-----------------------------------------------------------------");


        }
    }

    private static void addCustomers(){

        // Find the queue with the minimum number of customers
        int minCustomers = Math.min(Math.min(queue1Length, queue2Length), queue3Length);

// Determine the queue number with the minimum number of customers
        int queueNumber;
        if (minCustomers == queue1Length) {
            queueNumber = 1;
        } else if (minCustomers == queue2Length) {
            queueNumber = 2;
        } else {
            queueNumber = 3;
        }

// Check if the selected queue is at its maximum capacity
        if (queueNumber == 1 && queue1Length == queue1Capacity){
            // Check if queue 2 has available capacity
            if (queue2Length < queue2Capacity) {
                queueNumber = 2;
            }
            // Check if queue 3 has available capacity
            else if (queue3Length < queue3Capacity) {
                queueNumber = 3;
            } else {
                System.out.println("All queues are already at maximum capacity and cannot accept more customers.");
                return;
            }
        }
        else if(queueNumber == 2 && queue2Length == queue2Capacity){
            // Check if queue 1 has available capacity
            if (queue1Length < queue1Capacity) {
                queueNumber = 1;
            }
            // Check if queue 3 has available capacity
            else if (queue3Length < queue3Capacity) {
                queueNumber = 3;
            } else {
                System.out.println("All queues are already at maximum capacity and cannot accept more customers.");
                return;
            }
        }
        else if(queueNumber == 3 && queue3Length == queue3Capacity) {
            // Check if queue 1 has available capacity
            if (queue1Length < queue1Capacity) {
                queueNumber = 1;
            }
            // Check if queue 2 has available capacity
            else if (queue2Length < queue2Capacity) {
                queueNumber = 2;
            } else {
                System.out.println("All queues are already at maximum capacity and cannot accept more customers.");
                return;
            }
        }

// Add the customer to the queue with the minimum number of customers
        if (queueNumber == 1) {
            array1[queue1Length] = "O";
            queue1Length++;

        } else if (queueNumber == 2) {
            array2[queue2Length] = "O";
            queue2Length++;
        } else {
            array3[queue3Length] = "O";
            queue3Length++;
        }

// Print the selected queue number and updated queue lengths
        System.out.println("Customer added to Queue " + queueNumber);
        System.out.println("Updated Queue 1 length: " + queue1Length);
        System.out.println("Updated Queue 2 length: " + queue2Length);
        System.out.println("Updated Queue 3 length: " + queue3Length);

    }
    public static void getCustomerDetail(){
        String firstName;
        String secondName;
        int reqBurger=0;

        while (true) {
            System.out.print("Enter customer first name : ");
            firstName = scn.next();
            if (firstName.length()!=0){
                break;
            }else {
                System.out.println("WARNING!! First name cannot be empty\n");
            }
        }
        while (true) {
            System.out.print("Enter customer second name : ");
            secondName = scn.next();
            if (secondName.length()!=0){
                break;
            }else {
                System.out.println("WARNING!! second name cannot be empty\n");
            }
        }
        while (true) {
            try {
                System.out.print("Required burgers : ");
                reqBurger = scn.nextInt();
                if (reqBurger != 0) {
                    break;
                } else {
                    System.out.println("WARNING!! No. of burgers cannot be zero\n");
                }
            } catch (Exception e) {
                System.out.println("WARNING!! No. of burgers must be integer");
                scn.nextLine();
            }
            if (burgerAmount-reqBurger<0){
                System.out.println("Not enough burgers to serve entered customer. Restock and try again.");
            }else {
                burgerAmount-=reqBurger;
                foodArray.addCustomerObj(firstName,secondName,reqBurger);
            }
        }
    }
    public static void viewRemainingBurgers(){
        System.out.printf("You have remaining %d burgers",burgerAmount);
    }

    public static void addBurgersStock(){
        System.out.println("How many burgers you want to add to the stock  :");
        int amnt = scn.nextInt();

        burgerAmount= burgerAmount+amnt;
        System.out.println("Burger stocks updated");
    }

    public static void removeCustomer(){
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
                if(array1[0]=="O"){
                    System.out.println("There is no customer in the queue 1");
                }else{
                    for(int i=0;i<2;i++){
                        array1[i]=array1[i+1];
                    }
                    burgerAmount-=5;
                    System.out.println("Removed the served customer");
                }
            }
            else if(cashNum==2){
                if(array2[0]=="O"){
                    System.out.println("There is no customer in the queue 2");
                }else{
                    for(int i=0;i<3;i++){
                        array3[i]=array3[i+1];
                    }
                    burgerAmount-=5;
                    System.out.println("Removed the served customer");
                }
            }
            else if(cashNum==3){
                if(array3[0]=="O"){
                    System.out.println("There is no customer in the queue 3");
                }else{
                    for(int i=0;i<5;i++){
                        array3[i]=array3[i+1];
                    }
                    burgerAmount-=5;
                    System.out.println("Removed the served customer");
                }
            }
            else{
                System.out.println("Invalid Input");
            }
            if (burgerAmount<=10){
                System.out.println("****The stock of burgers is running low. Please replenish the stock.****");
            }

    }


}
