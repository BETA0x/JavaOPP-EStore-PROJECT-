package oop_estore.project;

import java.util.HashMap;

public class Products extends Product{
    private HashMap<String, String> attributes = new HashMap<>();
    
    public Products (int id, String name, String category,double price, int stockQuantity){
        super(id,name,category,price, stockQuantity);
    }

    @Override
    public String getDetails() {
        String details = id + " - " + name + "   " + price + "SAR  #" + stockQuantity + ", Category " + category; 
        if(!attributes.isEmpty()){
            details = details + "| Extra ";
            for(String key : attributes.keySet()){
                details = details + key + ": " + attributes.get(key) + ", ";
            }
            details = details.substring(0,details.length() - 2);
        }
        return details;
    }
    
    public void setAttribute(String key, String val){
        attributes.put(key, val);
    }
    public String getAttribute(String key){
        return attributes.getOrDefault(key,"NO Attribute");
    }
}
