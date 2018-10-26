package edu.csumb.cst338.homework.hw5.OnlineStore;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Store s = new Store();



        s.addCustomer(s.generateCustomerID());
        s.addCustomer(s.generateCustomerID());
        s.addCustomer(s.generateCustomerID());
        s.addCustomer(s.generateCustomerID());

        System.out.println(s.generateProductID());

        s.customerInfo();



    }
}
