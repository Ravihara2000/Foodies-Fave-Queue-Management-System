package task2;

public class Customer {
    //Instance variables
    private String firstName;
    private String secondName;
    private int noOfBurger;

    //Constructor

    public Customer(String firstName, String secondName, int noOfBurger) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.noOfBurger = noOfBurger;
    }
// Getters
    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getNoOfBurger() {
        return noOfBurger;
    }

    @Override
    public String toString() {
        return firstName + ',' +
                secondName + ',' +
                noOfBurger +'\n';
    }
}
