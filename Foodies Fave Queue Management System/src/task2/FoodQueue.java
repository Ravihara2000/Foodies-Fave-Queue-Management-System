package task2;


import java.util.ArrayList;

public class FoodQueue {
    //    ArrayList to store passenger object relevant to the queue
    private ArrayList<Customer> foodQueue =new ArrayList<Customer>();
    private int queueLength;

    public FoodQueue(int foodQueueLength){
        this.queueLength = foodQueueLength;
    }



    //    Creating Passenger objects and add it to ArrayList
    public void addCustomerObj(String cusFirstName, String cusLastName, int reqBurgers) {
        if (foodQueue.size()<queueLength){
            foodQueue.add(new Customer(cusFirstName,cusLastName,reqBurgers));
        }else {
            System.out.println("Array is full");
        }

    }
    public int size(){
        return foodQueue.size();
    }
    public Customer getCustomer(int customerIndex){
        return foodQueue.get(customerIndex);
    }

    public int getNoOfEmpty(){
        return queueLength- foodQueue.size();
    }
    public void remove(int index){
        foodQueue.remove(index);
    }
    public void reset(){
        foodQueue.clear();
    }

}
