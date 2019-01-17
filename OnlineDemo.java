/*
* Title OnlineDemo.java
* Abstract Class holding main program calling methods in other classes depending on the action user wants the program to execute
* Author Sverre Broen
* Date 11/4/2018
 */

package edu.csumb.cst338.homework.hw5.OnlineStore;

import java.util.InputMismatchException;
import java.util.Scanner;

import static edu.csumb.cst338.homework.hw5.OnlineStore.Customer.getCustomer;

public class OnlineDemo {

    public static void main(String[] args) {
        System.out.println("Welcome  to CSUMB Online Store");
        Store s = new Store();
        int option;
        Scanner sc;


        while(true) {
            option = 0;
            s.displayOptions();

            Scanner options = new Scanner(System.in);

            try {
                option = options.nextInt();
            }catch (InputMismatchException ime){}

            switch (option) {
                //Case for adding costumer to map
                case 1:
                    s.addCustomer(Customer.generateCustomerID());
                    break;

                //Case for printing out every customer in map
                case 2:
                    s.customerInfo();
                    break;

                //Case for adding product to map
                case 3:
                    s.addProduct(Product.generateProductID());
                    break;

                //Case for removing a product for product map
                case 4:
                    s.deleteProduct();
                    break;

                //Case for printing out products in map
                case 5:
                    if(Product.products.size() == 0){
                        System.out.print("No product information");
                        break;
                    }
                    String userInput;
                    sc = new Scanner(System.in);
                    System.out.print("Enter product number (or just enter to display all products): ");
                    userInput = sc.nextLine();
                    s.productInfo(userInput);

                    break;

                //Case for making a order
                case 6:
                    int productNumber = 1;
                    int customerNumber;
                    int orderNumber = Order.generateOrderID();
                    System.out.println("Order Number: " + orderNumber);
                    sc = new Scanner(System.in);
                    System.out.print("Type customer number: ");
                    customerNumber = Customer.validateCustomer(sc.nextInt());
                    if(customerNumber == 0){
                        System.out.println("No costumers created. Please add customer before making a order.");
                        break;
                    }
                    Customer c = getCustomer(customerNumber);
                    while (productNumber != 0) {
                        System.out.print("Type Product Number (0 to finish): ");
                        productNumber = Product.validateProduct(sc.nextInt());
                        if (productNumber != 0) {
                            s.makeOrder(c, productNumber, orderNumber);
                        }
                    }
                    s.displayOrder(orderNumber);

                    break;

                //Exit
                case 7:
                    System.out.println("Bye");
                    return;


                default:
                    System.out.println("Invalid option. Please choose a valid option");
                    break;

            }
            System.out.println("\n \n");
        }



    }
}
