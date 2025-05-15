package oop_estore.project;
public abstract class Product {
    protected int id, stockQuantity;
    protected String name,category;
    protected double price;
    
    public Product(int id, String name,String category, double price, int stockQuantity){
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stockQuantity = stockQuantity;
        
    }
    
    
    public void decreaseStock(int quantity){
        if(stockQuantity >= quantity){
            stockQuantity = stockQuantity - quantity;
        }
        else {
            System.out.println("Quantity is not Enough");
        }
    }
    
    public double getPrice(){
        return price;
    }
    
    public int getStockQuantity(){
        return stockQuantity;
    }
    
    public String getName(){
        return name;
    }
    
    public String getCategory(){
        return category;
    }
    
    public abstract String getDetails();
    
    
}
