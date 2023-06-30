package task2;

import java.util.ArrayList;

public class FoodQueue {
    //    ArrayList to store passenger object relevant to the queue
    private ArrayList<Customer> CashQueue =new ArrayList<Customer>();
    //    Creating Passenger objects and add it to ArrayList
    public void addCustomerObj(String passengerFirstName, String passengerLastName, String vehicleNumber, int noOfLiters) {
        if (pumpQueue.size()<queueLength){
            pumpQueue.add(new Passenger(passengerFirstName,passengerLastName,vehicleNumber,noOfLiters));
        }else {
            System.out.println("Array is full");
        }

    }
}
