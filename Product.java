/*
 * Title OnlineDemo.java
 * Abstract Product class holding hash map holding products with orderid as key
   Also has method for calling a random generator that creates an unique id and a method for validating if product exist.
 * Author Sverre Broen
 * Date 11/4/2018
 */
package edu.csumb.cst338.homework.hw5.OnlineStore;

import java.util.HashMap;
import java.util.Scanner;

public class Product {
    private String name;
    private int id;
    private double price;

    public static HashMap<Integer, Product> products = new HashMap<>();

    public Product(String name, int id, double price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public static int generateProductID(){
        int id;
        while(true){
            id = Store.generateID(200, 500);
            if(!products.containsKey(id)){
                return id;
            }
        }
    }

    public static int validateProduct(int productNumber){

        while(!products.containsKey(productNumber)){
            if(productNumber == 0){
                break;
            }
            System.out.println("Input error: Product " + productNumber + " doesn't exist.");
            System.out.print("Type Product Number (0 to finish): ");
            Scanner sc = new Scanner(System.in);
            productNumber = sc.nextInt();

        }
        return productNumber;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "No: " + id + " - " + name + ", " + price;
    }
}
