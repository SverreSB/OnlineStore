package edu.csumb.cst338.homework.hw5.OnlineStore;

import java.util.HashMap;


public class Customer {
    private String name;
    private int id;
    public static HashMap<Integer, Customer> customers = new HashMap<>();

    public Customer(String name, int id){
        this.name = name;
        this.id = id;
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
}
