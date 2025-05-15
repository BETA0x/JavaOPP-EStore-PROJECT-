package oop_estore.project;

import java.util.ArrayList;
import java.util.HashMap;

public class Store {
    private HashMap<String,ArrayList<Product>> categorys = new HashMap();
    private HashMap<String, User> users = new HashMap<>();
    private HashMap<String, Cart> usersCarts = new HashMap<>();
    private int productCounter = 0;
    private int userCounter = 0;
    
    
    public void addCategory(String cate){
        categorys.putIfAbsent(cate,new ArrayList<>());
    }
    
    public boolean hasCategory(String cate){
        return categorys.containsKey(cate);
    }
    
    public void addProductToCategory(String cate, Product p){
        if(hasCategory(cate)){
            categorys.get(cate).add(p);
        }
        else{
            System.out.println("The Category Didnt exist yet!");
        }
    }
    
    public void displayCategorys() {
        System.out.println("\nAvilebale categorys: ");
        for(String cate : categorys.keySet()){
            System.out.println(" - " + cate);
        }
    }
    
    public void displayAllProduct (){
        for (String cate : categorys.keySet()){
            System.out.println("\nCategory : " + cate);
            for(Product p : categorys.get(cate)){
                System.out.println(" Product :" + p.getDetails());
            }
        }
    }
    
    public ArrayList<Product> getProductsInCategorys(String name){
        return categorys.getOrDefault(name, new ArrayList<>());
    }
    
    public Product findProduct(String name){
        for(ArrayList<Product> products : categorys.values()){
            for (Product p : products){
                if (p.getName().equalsIgnoreCase(name)){
                    return p;
                }
            }    
        }
    return null;    
    }
    
    public User creatUser(String name,String email){
        if(!users.containsKey(name)){
            User user = new User(ceationUserId(), name, email);
            users.put(name, user);
            usersCarts.put(name, new Cart());
        }
        return users.get(name);
    }
    
    public Cart getUserCart(String name){
        return usersCarts.getOrDefault(name,new Cart());
    }
    public void saveUsersCarts(String name, Cart cart){
        usersCarts.put(name, cart);
    }
    
    public void addToWishList(String userName, Product p){
        if(users.containsKey(userName)){
            users.get(userName).addToWishList(p);
        }
    }
    
    public void removeFromWishList(String userName, Product p){
        if(users.containsKey(userName)){
            if (users.get(userName).getWishList().isEmpty()){
                System.out.println("your wishlist is empry!");
            }
            else{
                users.get(userName).removeFromWishList(p);
            }
        }
    }
    
    public ArrayList<Product> getUserWhishList(String userName){
        if(users.containsKey(userName)){
            return users.get(userName).getWishList();
        }
        return new ArrayList<>();
    }
    
    
    public int creationProductID(){
        return productCounter++;
    }
    
    public int ceationUserId(){
        return userCounter++;
    }
}
