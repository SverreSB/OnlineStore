package edu.csumb.cst338.homework.hw5.OnlineStore;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Store {
    String name;

    public Store(String name){
        this.name = name;
    }

    public Store(){
        this.name = "UNKOWN";
    }


    /*
     * Function for adding customer to map holding customers
     *
     */
    public void addCustomer(int generatedId){
        if(Customer.customers.containsKey(generatedId)){
            System.out.println("Customer id (" + generatedId + ") is already in use");
            return;
        }

        String customerName;
        System.out.println("Customer number: " + generatedId + "\n \n");

        System.out.print("Customer Name: ");

        Scanner sc = new Scanner(System.in);
        customerName = sc.nextLine();

        Customer temp = new Customer(customerName, generatedId);
        Customer.customers.put(generatedId, temp);

        System.out.println("Customer Added - " + customerName + "(# " + generatedId + ")");
    }

    /*
     * Method for generating a unique customer number between 100 and 300.
     * If customer map doesn't contain the generated number, then it returns generated ID.
     *
     * COMMENT TO FUNCTION: Will be stuck in the while-loop if there are 201 customers
     */
    public int generateCustomerID(){
        int id;
        while(true){
            id = generateID(200, 100);
            if(!Product.products.containsKey(id)){
                return id;
            }
        }
    }

    public int generateProductID(){
        int id;
        while(true){
            id = generateID(200, 500);
            if(!Product.products.containsKey(id)){
                return id;
            }
        }
    }

    public int generateID(int range, int start){
        Random random = new Random();
        int number = random.nextInt(range) + start;
        return number;
    }

    public void customerInfo(){
        System.out.println("===== " + Customer.customers.size() + " =====");
        for (Map.Entry<Integer, Customer> customerEntry : Customer.customers.entrySet()){
            System.out.println(customerEntry.getValue().getName() + " - " + customerEntry.getKey());
        }
    }
}