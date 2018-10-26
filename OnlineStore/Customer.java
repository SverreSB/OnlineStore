package edu.csumb.cst338.homework.hw5.OnlineStore;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.in;

public class Customer {
    private String name;
    private int id;
    public static HashMap<Integer, Customer> customers = new HashMap<>();

    public Customer (String name, int id){
        this.name = name;
        this.id = id;
    }

    public Customer(){
        this.name = "UNKNOWN";
        this.id = 0;
    };


    /*
    * Function for adding customer to
     */
    public void addCustomer(){
        this.id = generateID();
        System.out.println("Customer number: " + id + "\n \n");

        System.out.print("Customer Name: ");

        Scanner sc = new Scanner(System.in);
        this.name = sc.nextLine();
        customers.put(id, this);

        System.out.println("Customer Added - " + this.name + "(# " + this.id + ")");
    }

    /*
     * Method for generating a unique customer number between 100 and 300.
     * If customer map doesn't contain the generated number, then it returns generated ID.
     *
     * COMMENT TO FUNCTION: Will be stuck in the while-loop if there are 201 customers
     */
    public int generateID() {
        Random random = new Random();
        while (true) {
            int generatedID = random.nextInt(300) + 100;

            if (!customers.containsKey(generatedID)){
                return generatedID;
            }
        }
    }

    public void customerInfo(){
        System.out.println("===== " + customers.size() + " =====");
        for (Map.Entry<Integer, Customer> customerEntry : Customer.customers.entrySet()){
            System.out.println(customerEntry.getValue().getName() + " - " + customerEntry.getKey());
        }
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
