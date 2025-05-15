package oop_estore.project;

import java.util.ArrayList;

public class Order {
    private static int orderID = 1000;
    private User user;
    private ArrayList<CartItem> items;
    private double totalPrice;

    public Order(User user, ArrayList<CartItem> items){
        orderID ++;
        this.user = user;
        this.items = items;
        this.totalPrice = calcTotakPrice();
    }
    
    public double calcTotakPrice(){
        double total = 0;
        for(CartItem item : items){
            total = total + item.getSubtotal();
        }
        return total;
    }
    
    public void generateInvoice(){
        System.out.println("Invoce for order " + orderID);
        System.out.println("Customer: " + user.getName() + "  " + user.getEmail() + "\n");
        
        for (CartItem item : items){
            System.out.println(item.getProduct().getName() + " # " + item.getQuantity());
        }
        
        System.out.println("\nTotal Price: "+totalPrice+" SAR");
    }

}

