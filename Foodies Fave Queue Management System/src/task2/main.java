package task2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class main {

    //    Integer list for store income of each Cashier.
    static Integer[] cashierIncome = new Integer[3];
    // Initialize the cashierIncome array


    static int c1=0;
    static int queueLength = 5;
    static Scanner scn = new Scanner(System.in);
    //    Object list for store all cashier objects
    static FoodQueue[] foodArray = new FoodQueue[3];

    static String[] array1 = {"X", "X","X"};
    static String[] array2 = {"X", "X", "X","X"};
    static String[] array3 = {"X", "X", "X", "X", "X","X"};

    static File logFile = new File("cashier-data.txt");
    static int burgerAmount=50;
    // Queue capacities
    static int queue1Capacity = 2;
    static int queue2Capacity = 3;
    static int queue3Capacity = 5;
    // Initialize the cashierIncome array with default values of zero
    static {
        Arrays.fill(cashierIncome, 0);
    }


    // Queue lengths
    static int queue1Length = 0;
    static int queue2Length = 0;
    static int queue3Length = 0;
    

    public static void main(String[] args) {

        for (int i = 0; i < foodArray.length; i++) {
            foodArray[i]=new FoodQueue(queueLength);
        }
            for(;;){
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
                    storeData();
                    break;
                case "107":
                case "LPD":
                    loadDataFromFile();
                    break;
                case "108":
                case "STK":
                    viewRemainingBurgers();
                    break;
                case "109":
                case "AFS":
                    addBurgersStock();
                    break;
                case "110":
                case "IFQ":
                    showQueueIncome();
                    break;
                case "999":
                case "EXT":
                    System.exit(0);
                default:
                    System.out.println("Invalid input");

            }

        }

    }

    private static void loadDataFromFile() {
        try {
            if (logFile.exists()) {
                System.out.println("This action cannot be undone!!!");
                Scanner sc  = new Scanner(System.in);
                while (true) {
                    System.out.println("Do you want to overwrite?(Y/N)");
                    String overwriteChoice = sc.nextLine();
                    if (overwriteChoice.equalsIgnoreCase("y")) {
                        Path file = Path.of("cashier-data.txt");
                        int lineNumber = 0;
                        for (int i = 0; i < foodArray.length; i++) {
                            foodArray[i].reset();
                            for (int j = lineNumber; j < queueLength+lineNumber; j++) {
                                String[] lineData = Files.readAllLines(file).get(j).split(",");
                                if (lineData.length>1) {

                                    foodArray[i].addCustomerObj(lineData[0], lineData[1], Integer.parseInt(lineData[2]));
                                }
                            }
                            lineNumber+=queueLength;

                        }
                        burgerAmount = Integer.parseInt(Files.readAllLines(file).get(foodArray.length*queueLength));
                        String[] cashierIncomeLoaded = Files.readAllLines(file).get(foodArray.length*queueLength+1).split(",");
                        for (int i = 0; i < cashierIncome.length; i++) {
                            cashierIncome[i]=Integer.parseInt(cashierIncomeLoaded[i]);
                        }
                        System.out.println("Data loaded successfully.");
                        break;
                    } else if (overwriteChoice.equalsIgnoreCase("n")) {
                        break;
                    }else {
                        System.out.println("Invalid Input.");
                    }
                }

            } else {
                System.out.println("No log file to retrieve data from.");
            }
        }catch (IOException e){
            System.out.println("Error occurred.");
        }

    }

    private static void storeData() {
        try{
            if (logFile.createNewFile()){
                System.out.println("Log file created");
                writeToFile();
            }else {
                System.out.println("File already exists.");
                Scanner sc = new Scanner(System.in);

                while (true){
                    System.out.println("Do you want to overwrite?(Y/N)");
                    String overwriteChoice = sc.nextLine();
                    if (overwriteChoice.equalsIgnoreCase("y")){
                        writeToFile();
                        System.out.println("Data stored successfully!!");
                        break;
                    } else if (overwriteChoice.equalsIgnoreCase("n")) {
                        break;
                    }else {
                        System.out.println("Invalid input.");
                    }
                }
            }

        }catch (IOException e){
            System.out.println("Error occurred.");
            e.printStackTrace();
        }
    }
    //    Write necessary data to cashier-data.txt
    private static void writeToFile(){
        try {
            FileWriter logWrite = new FileWriter("cashier-data.txt");
            for (int i = 0; i < foodArray.length; i++) {
                for (int j = 0; j < foodArray[i].size(); j++) {
                    logWrite.write(foodArray[i].getCustomer(j).toString());
                }
                if (foodArray[i].size() < queueLength) {
                    int emptyLength = queueLength - foodArray[i].size();
                    for (int k = 0; k < emptyLength; k++) {
                        logWrite.write("\n");
                    }
                }
            }
            logWrite.write(String.valueOf(burgerAmount)+"\n");
            logWrite.write(Arrays.toString(cashierIncome).replaceAll("\\[", "").replaceAll("\\]","").replaceAll(" ",""));
            logWrite.close();
        }catch (IOException e) {
            System.out.println("Error occurred.");
        }

    }

    private static void sortedCustomer() {
        for (int i = 0; i < foodArray.length; i++) {
            ArrayList<Customer> tempQueue = new ArrayList<Customer>();
            for (int j = 0; j < foodArray[i].size(); j++) {
                tempQueue.add(foodArray[i].getCustomer(j));
            }
            Collections.sort(tempQueue, Comparator.comparing(Customer::getFirstName));
            if (tempQueue.size() > 0) {
                System.out.println("----------------------- Cashier "+(i+1)+" [SORTED] -------------------------");
                System.out.printf("%15s | %15s | %15s\n", "First Name", "Second Name", "Required Burgers");
                System.out.println("-----------------------------------------------------------------");

                for (Customer passenger:tempQueue
                ) {
                    System.out.printf("%15s | %15s | %15s \n", passenger.getFirstName(), passenger.getSecondName(), passenger.getNoOfBurger());

                }
                System.out.println();
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
                "110 or AFS: View Cashier Income.\n" +
                "999 or EXT: Exit the Program");
        System.out.println("-------------------------------------");
    }
    public static void viewAllQueues() {
        //sample();
        //
        for (int i = 0; i < foodArray.length; i++) {
            queueDetails(i);
            System.out.println();

        }
    }

    private static void queueDetails(int queueNum) {
        System.out.println("---------------------------- Cashier "+(queueNum+1)+" -----------------------------");
        System.out.printf("%15s | %15s | %15s|\n", "First Name", "Last Name", "Required Burgers");
        System.out.println("-----------------------------------------------------------------");
        for (int j = 0; j < foodArray[queueNum].size(); j++) {
            System.out.printf("%15s | %15s | %15s \n", foodArray[queueNum].getCustomer(j).getFirstName(), foodArray[queueNum].getCustomer(j).getSecondName(), foodArray[queueNum].getCustomer(j).getNoOfBurger());
        }
        if (foodArray[queueNum].size()<queueLength){
            int emptyLength = queueLength - foodArray[queueNum].size();
            for (int k = 0; k < emptyLength; k++) {
                System.out.printf("%15s | %15s | %15s \n", "empty","empty","-");
            }
        }
    }

    private static void addCustomers() {

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
        if (queueNumber == 1 && queue1Length == queue1Capacity) {
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
        } else if (queueNumber == 2 && queue2Length == queue2Capacity) {
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
        } else if (queueNumber == 3 && queue3Length == queue3Capacity) {
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
        System.out.println("Customer added to Queue " + (queueNumber));
        getCustomerDetail(foodArray[queueNumber-1]);
        System.out.println("Updated Queue 1 length: " + queue1Length);
        System.out.println("Updated Queue 2 length: " + queue2Length);
        System.out.println("Updated Queue 3 length: " + queue3Length);
    }

    public static void getCustomerDetail(FoodQueue foodQueue) {
        String firstName;
        String secondName;
        int reqBurger = 0;

        while (true) {
            System.out.print("Enter customer first name: ");
            firstName = scn.next();
            if (!firstName.isEmpty()) {
                break;
            } else {
                System.out.println("WARNING!! First name cannot be empty\n");
            }
        }
        while (true) {
            System.out.print("Enter customer second name: ");
            secondName = scn.next();
            if (!secondName.isEmpty()) {
                break;
            } else {
                System.out.println("WARNING!! Second name cannot be empty\n");
            }
        }
        while (true) {
            try {
                System.out.print("Required burgers: ");
                reqBurger = scn.nextInt();
                if (reqBurger != 0) {
                    break;
                } else {
                    System.out.println("WARNING!! No. of burgers cannot be zero\n");
                }
            } catch (Exception e) {
                System.out.println("WARNING!! No. of burgers must be an integer");
                scn.nextLine();
            }
        }
        if (burgerAmount-reqBurger<0){
            System.out.println("Not enough burgers to serve entered customer. Restock and try again.");
        }else {
            burgerAmount-=reqBurger;
            foodQueue.addCustomerObj(firstName,secondName,reqBurger);
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
        System.out.print("Enter \n1 - 1st Cashier\n2 - 2nd Cashier\n3 - 3rd Cashier\n");
        try{
            System.out.print("Which cashier customer do you want to remove : ");
            int cashNum = scn.nextInt();
            for (int i = 0; i < foodArray.length; i++) {
                if (cashNum == i+1) {
                    if (foodArray[i].getNoOfEmpty() < queueLength) {
                        System.out.println("Cashier " + (i + 1) + " selected");
                        showCustomerIndex(foodArray[i]);
                    }
                    else {
                        System.out.println("Cashier" + (i + 1) + " is empty");
                    }
                }
            }

        }catch (Exception e){
            System.out.println("Only integers are allowed");
        }

    }
    //    Show customer name and vehicle number to user with index to remove any customer within the queue
    public static void showCustomerIndex(FoodQueue foodQueue){
        Scanner scanner = new Scanner(System.in);
        int index = 0;
        System.out.printf("%2s | %15s | %15s \n","Index", "First Name", "Second Name");
        System.out.println("-----------------------------------------------------------------");
        for (int i = 0; i < foodQueue.size(); i++) {
            System.out.printf("%5s | %15s | %15s \n",i+1, foodQueue.getCustomer(i).getFirstName(), foodQueue.getCustomer(i).getSecondName());
            index++;
        }
        System.out.printf("\n%5s | %15s |", "999", "Exit");
        while (true) {
            try {
                System.out.print("\nSelect customer by Index : ");
                int selectedIndex = scanner.nextInt();

                if (selectedIndex <= index) {
                    burgerAmount+=foodQueue.getCustomer(selectedIndex-1).getNoOfBurger();
                    foodQueue.remove(selectedIndex-1);
                    System.out.println("Successfully removed");
                    break;
                } else if (selectedIndex == 999) {
                    break;
                } else {
                    System.out.println("Selected index doesn't exist");
                }
            } catch (Exception e) {
                System.out.println("Only integers are allowed.");
                scanner.nextLine();
            }
        }

    }
    public static void removeServedCustomer() {
        System.out.print("Enter \n1 - 1st Cashier\n2 - 2nd Cashier\n3 - 3rd Cashier\n");
        try{
            System.out.print("What Cashier did serve : ");
            int cashNum = scn.nextInt();
            for (int i = 0; i < foodArray.length; i++) {
                if (cashNum == i+1) {
                    if (foodArray[i].getNoOfEmpty() < queueLength) {
                        System.out.println("Cashier " + (i + 1) + " served");
                        int reqBurgers = foodArray[i].getCustomer(0).getNoOfBurger();
                        foodArray[i].remove(0);
                        changeCashierIncome(i,reqBurgers);
                    }
                    else {
                        System.out.println("Cashier " + (i + 1) + " is empty");
                    }
                }
            }

        }catch (Exception e){
            System.out.println("Only integers are allowed");
        }

    }
    //    show income of every queue
    private static void showQueueIncome(){
        for (int i = 0; i < foodArray.length; i++) {
            int queueIncome = cashierIncome[i]*650;
            System.out.printf("Income of cashier %d : Rs.%d%n",i+1,queueIncome);
        }
    }

    //    Change income value when customer has been served
    public static void changeCashierIncome(int index, int reqBurgers){
        cashierIncome[index] += reqBurgers;
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
