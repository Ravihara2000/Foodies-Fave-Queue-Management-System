package task2;

import java.util.ArrayList;

public class FoodQueue {
    //    ArrayList to store passenger object relevant to the queue
    private ArrayList<Customer> CusQueue =new ArrayList<Customer>();
    private int queueLength;
    //    Creating Passenger objects and add it to ArrayList
    public void addCustomerObj(String cusFirstName, String cusLastName, int reqBurgers) {
        if (CusQueue.size()<queueLength){
            CusQueue.add(new Customer(cusFirstName,cusLastName,reqBurgers));
        }else {
            System.out.println("Array is full");
        }

    }
    public int size(){
        return CusQueue.size();
    }
    public Customer getCustomer(int customerIndex){
        return CusQueue.get(customerIndex);
    }



}
