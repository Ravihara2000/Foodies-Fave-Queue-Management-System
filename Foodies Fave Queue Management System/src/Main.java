import java.util.Scanner;

public class Main {
    static Scanner scn = new Scanner(System.in);

    static String[] array1 = {"O", "O"};
    static String[] array2 = {"O", "O", "O"};
    static String[] array3 = {"O", "O", "O", "O", "O"};
    static String[] cusNameArray1=new String[2];
    static String[] cusNameArray2=new String[3];
    static String[] cusNameArray3=new String[5];

    static int burgerAmount=13;

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
                    sortedCustomer();
                    break;
                case "106":
                case "SPD":
                case "107":
                case "LPD":
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
        try {
            for (int v = 1; v > -1; v++) {
                System.out.println("Enter Customer name  :");
                String cName = scn.next();

                System.out.println("Enter Queue number you wish to add customer(1-3) or Press 0 to come back to menu  :");
                int qNum = scn.nextInt();

                if (qNum == 1) {
                    if (array1[1] == "O") {
                        for (int i = 0; i < 2; i++) {
                            if (array1[i] == "O") {
                                array1[i] = "X";
                                cusNameArray1[i] = cName;
                                System.out.println(cusNameArray1[i] + " added to the queue 1");
                                break;
                            }
                        }

                    } else {
                        System.out.println("Queue 1 is full.Try a another queue.");
                        break;

                    }

                } else if (qNum == 2) {
                    if (array2[2] == "O") {
                        for (int i = 0; i < 3; i++) {
                            if (array2[i] == "O") {
                                array2[i] = "X";
                                cusNameArray2[i] = cName;
                                System.out.println(cusNameArray2[i] + " added to the queue 2");
                                break;
                            }
                        }

                    } else {
                        System.out.println("Queue 2 is full.Try a another queue.");
                        break;

                    }
                } else if (qNum == 3) {
                    if (array3[4] == "O") {
                        for (int i = 0; i < 5; i++) {
                            if (array3[i] == "O") {
                                array3[i] = "X";
                                cusNameArray3[i] = cName;
                                System.out.println(cusNameArray3[i] + " added to the queue 3");
                                break;
                            }
                        }

                    } else {
                        System.out.println("Queue 3 is full.Try a another queue.");
                        break;

                    }
                } else if (qNum == 0) {
                    break;

                } else {
                    System.out.println("Invalid queue number.");
                    break;
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

        }catch (Exception e){
            System.out.println(e);
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

    public static void sortedCustomer(){
        try{
            String temp;
            System.out.println("Strings in sorted order:");
            for (int j = 0; j < cusNameArray1.length; j++) {
                for (int i = j + 1; i < cusNameArray1.length; i++) {
                    // comparing adjacent strings
                    if (cusNameArray1[i].compareTo(cusNameArray1[j]) < 0) {
                        temp = cusNameArray1[j];
                        cusNameArray1[j] = cusNameArray1[i];
                        cusNameArray1[i] = temp;
                    }
                }
                System.out.println(cusNameArray1[j]);
                System.out.println("Sorted");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }


}