package oop_estore.project;

import java.util.ArrayList;

public class User {
    private int iD;
    private String name,email;
    
    private ArrayList<Product> wishList = new ArrayList<>();

    
    public User (int ID, String name, String email) {
        this.iD = ID;
        this.name = name;
        this.email = email;
    }
    
    public void addToWishList(Product p){
        wishList.add(p);
    }
    
    public void removeFromWishList(Product p){
        wishList.remove(p);
    }
    
    public ArrayList<Product> getWishList(){
        return wishList;
    }
    
    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }
    
}
