/*
 * Title OnlineDemo.java
 * Abstract Store class holding all methods that the user can call in OnlineDemo.
 * Author Sverre Broen
 * Date 11/4/2018
 */
package edu.csumb.cst338.homework.hw5.OnlineStore;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import static edu.csumb.cst338.homework.hw5.OnlineStore.Order.getOrderObject;

public class Store {
    String name;

    public Store(String name){
        this.name = name;
    }

    public Store(){
        this.name = "UNKOWN";
    }

     //Function for adding customer to map holding customers
    public void addCustomer(int generatedId){
        if(Customer.customers.containsKey(generatedId)){
            System.out.println("Customer id (" + generatedId + ") is already in use");
            return;
        }
        else if(generatedId == 0){
            System.out.println("Not a valid ID");
            return;
        }

        String customerName;
        System.out.println("Customer number: " + generatedId);

        System.out.print("Customer Name: ");

        Scanner sc = new Scanner(System.in);
        customerName = sc.nextLine();

        Customer temp = new Customer(customerName, generatedId);
        Customer.customers.put(generatedId, temp);

        System.out.println("Customer Added - " + customerName + "(# " + generatedId + ")");
    }

    //Printing out customer information. Prints out customer size and every customer
    public void customerInfo(){
        if(Customer.customers.size() == 0){
            System.out.println("No customer information.");
        }

        else{
            System.out.println("No customer information.");

            System.out.println("===== " + Customer.customers.size() + " =====");
            for (Map.Entry<Integer, Customer> customerEntry : Customer.customers.entrySet()) {
                System.out.println(customerEntry.getValue().getName() + " - " + customerEntry.getKey());
            }
        }
    }


    //Method for adding a product. Product number is unique, so the product wont make duplicate products.
    public void addProduct(int generatedID){
        String productName;
        double productPrice;
        if(Product.products.containsKey(generatedID)){
            System.out.println("Product number " + generatedID + " is already in use.");
        }
        System.out.println("Product number: " + generatedID);
        Scanner sc = new Scanner(System.in);
        System.out.print("Product name: ");
        productName = sc.nextLine();
        System.out.print("Product price: ");
        productPrice = sc.nextDouble();

        Product temp = new Product(productName, generatedID, productPrice);
        Product.products.put(generatedID, temp);

        System.out.println("Product Added - " + productName + ", No: " + generatedID + ", Price: " + productPrice);
    }

    /*
        Method for deleting a product. If product number doesn't exist or the product map is empty,
        it will return a message to the user. If the product number is found,
        it deletes the product and gives confirmation to user.
     */
    public void deleteProduct(){
        int deleteProductNumber;
        if(Product.products.size() == 0){
            System.out.println("No products to delete");
            return;
        }

        System.out.print("Product number to delete: ");
        Scanner sc = new Scanner(System.in);
        deleteProductNumber = sc.nextInt();
        for(Map.Entry<Integer, Product> productEntry : Product.products.entrySet()){
            if(productEntry.getKey().equals(deleteProductNumber)){
                Product.products.remove(productEntry.getKey());
                System.out.println("Product " + deleteProductNumber + " deleted");
                return;
            }
        }
        System.out.println("Input error: Product " + deleteProductNumber + " doesn't exist");
    }

    //Method for printing out product information. Can print out every product or a specific one if product number is given.
    public void productInfo(String productNumber){
        int productID;
        if(productNumber.equals("")){
            for(Map.Entry<Integer, Product> productEntry : Product.products.entrySet()){
                System.out.println("No: " + productEntry.getKey() + " - " + productEntry.getValue().getName() + ", " + productEntry.getValue().getPrice());
            }
            return;
        }

        productID = Integer.parseInt(productNumber);
        if(!Product.products.containsKey(productID)){
            System.out.println("Input error: Product " + productNumber + " doesn't exist");
        }

        else{
            for(Map.Entry<Integer, Product> productEntry : Product.products.entrySet()){
                if(productEntry.getKey() == productID){
                    System.out.println("No: " + productEntry.getKey() + " - " + productEntry.getValue().getName() + ", " + productEntry.getValue().getPrice());
                }
            }
        }
    }

    /*
       Method taking in customer, product number and order number, if both exist in each of their maps,
       then it will add the order in a hash map holding the products and a hash map holding customers.
    */
    public void makeOrder(Customer cust, int productNumber, int orderNumber){
        if(Customer.customers.size() == 0 || Product.products.size() == 0){
            System.out.println("Cant make an order without any costumers or products");
            return;
        }
        Order temp = getOrderObject(orderNumber);
        if(!Order.orders.containsKey(temp)){
            Order.orders.put(temp, cust);
        }

        for(Map.Entry<Integer, Product> productEntry : Product.products.entrySet()){
            if(productEntry.getKey() == productNumber){
                temp.orderedProducts.add(productEntry.getValue());
            }
        }
    }


    //Displays orders. First printing out customer that made order. And then printing out all orders.
    public void displayOrder(int orderId){
        double totalSum;
        Order order = getOrderObject(orderId);

        for(Map.Entry<Order,Customer> customerEntry : Order.orders.entrySet()) {
            if (customerEntry.getKey().equals(order)){
                System.out.println("Order Summary – Order Number: " + orderId + " , Customer: " + customerEntry.getValue().getName());
            }
        }
        totalSum = 0;
        for (int i = 0; i < order.orderedProducts.size(); i++) {
            System.out.println("    Item: " + (i + 1) + ": " + order.orderedProducts.get(i).getName() + " (No. " + order.orderedProducts.get(i).getId() + "): $" + order.orderedProducts.get(i).getPrice());
            totalSum += order.orderedProducts.get(i).getPrice();
        }

        System.out.println("Total Price: $ " + totalSum);
    }

    //Method printing out every option the user can do in this program
    public void displayOptions(){
        System.out.println("Select your options");
        System.out.println("    1. Add Costumer \n" + "    2. Costumer Information \n" + "    3. Add Product \n" + "    4. Delete Product \n"
                + "    5. Product Information \n" + "    6. Make Order \n" + "    7. Exit");
    }

    //Method for generating and ID. Order, product and customer have functions to call this id generator.
    public static int generateID(int range, int start){
        Random random = new Random();
        int number = random.nextInt(range) + start;
        return number;
    }
}