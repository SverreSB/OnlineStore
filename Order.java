/*
 * Title OnlineDemo.java
 * Abstract Order class holding hasmap for orders and arraylist for ordered products.
   Also has method for calling a random generator and a method for returning order object
 * Author Sverre Broen
 * Date 11/4/2018
 */
package edu.csumb.cst338.homework.hw5.OnlineStore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Order {

    private int orderNumber;

    public static HashMap<Order, Customer> orders = new HashMap<>();
    public ArrayList<Product> orderedProducts = new ArrayList<>();

    public Order(int orderNumber){
        this.orderNumber = orderNumber;
    }

    public Order() {
        this.orderNumber = 0;
    }

    public static int generateOrderID(){
        int id;
        while(true){
            id = Store.generateID(1000, 1000);
            if(!orders.containsKey(id)){
                return id;
            }
        }
    }


    public static Order getOrderObject(int id){

        for(Map.Entry<Order, Customer> orderEntry : orders.entrySet()){
            if(orderEntry.getKey().getOrderNumber() == id){
                return orderEntry.getKey();
            }
        }
        Order order = new Order(id);
        return order;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }


}
