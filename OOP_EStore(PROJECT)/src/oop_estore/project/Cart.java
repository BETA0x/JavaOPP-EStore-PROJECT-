package oop_estore.project;

import java.util.ArrayList;

public class Cart {
    
    private ArrayList<CartItem> cartItems = new ArrayList<>();
    
    public void addProduct(Product p, int qua){
        CartItem newP = new CartItem(p,qua);
        cartItems.add(newP);
    }
    
    public void removeProduct(Product p){
        cartItems.removeIf(prod -> prod.getProduct().equals(p));
    }
    
    public double getTotalPrice(){
        double total = 0;
        for (CartItem item : cartItems){
            total = total + item.getSubtotal();
        }
        return total;
    }
    
    public ArrayList<CartItem> getCartItems(){
        return cartItems;
    }
}
