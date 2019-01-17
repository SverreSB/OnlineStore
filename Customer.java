/*
 * Title OnlineDemo.java
 * Abstract Customer class holding hash map holding customer with customer id as key
   Also has method for calling a random generator that creates an unique id and a method for validating if customer exist.
 * Author Sverre Broen
 * Date 11/4/2018
 */

package edu.csumb.cst338.homework.hw5.OnlineStore;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Customer {
    private String name;
    private int id;
    public static HashMap<Integer, Customer> customers = new HashMap<>();

    public Customer(String name, int id){
        this.name = name;
        this.id = id;
    }

    /*
     * Method for generating a unique customer number between 100 and 300.
     * If customer map doesn't contain the generated number, then it returns generated ID.
     *
     * COMMENT TO FUNCTION: Will be stuck in the while-loop if there are 201 customers
     */
    public static int generateCustomerID(){
        int id;
        while(true){
            id = Store.generateID(200, 100);
            if(!customers.containsKey(id)){
                return id;
            }
        }
    }

    public static int validateCustomer(int customerNumber){
        if(customers.size() == 0 || customers.size() > 200){
            return 0;
        }

        while(!customers.containsKey(customerNumber)){
            System.out.println("Input error: Customer " + customerNumber + " doesn't exist.");
            System.out.print("Type customer number: ");
            Scanner sc = new Scanner(System.in);
            customerNumber = sc.nextInt();
        }
        return customerNumber;
    }

    public Customer(){
        this.name = "UNKNOWN";
        this.id = 0;
    }


    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public static Customer getCustomer(int customerNumber){
        for(Map.Entry<Integer, Customer> customerEntry : customers.entrySet()){
            if(customerEntry.getKey() == customerNumber){
                return customerEntry.getValue();
            }
        }
        return null;
    }
}
