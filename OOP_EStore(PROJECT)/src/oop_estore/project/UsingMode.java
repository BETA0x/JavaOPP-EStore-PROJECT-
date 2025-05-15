package oop_estore.project;

import java.util.ArrayList;
import java.util.Scanner;

public class UsingMode {
    private static Scanner scan = new Scanner(System.in);
    private static Store store = new Store();
    private static Cart cart = new Cart();
    
    private static void sellerMode(){
        boolean x = true;
        while(x){
            System.out.println("\t--YOU ARE IN SELLER MODE--");
            System.out.println("- 1. Add New Category\n- 2. Add new Product\n- 3. Show ALl Catrgorys\n- 4. Show all Products\n- 0. Back to Main menu");
            int sCho = scan.nextInt();
            scan.nextLine();
            
            switch(sCho){
                case 1: {
                    System.out.println("Enter Category name: \t\tor '0' to cancel");
                    String newCate = scan.nextLine();
                    if(newCate.equalsIgnoreCase("0")){
                        System.out.println("Add Categodry Canceled");                        
                        break;
                    } 
                    else{
                        store.addCategory(newCate);
                        System.out.println("Category Added");
                    }
                    
                } break;
                
                case 2:{
                    System.out.println("Enter product category: \t\tor '0' to cancel");
                    String cate = scan.nextLine();
                    if(cate.equalsIgnoreCase("0")){
                        System.out.println("Add product Canceled");
                    }
                    else if (store.hasCategory(cate)){
                        System.out.println("product name: \t\tor '0' or cancel");
                        String pName = scan.nextLine();
                        if(pName.equalsIgnoreCase("0")){
                            System.out.println("Add product Canceled");
                            break;
                        } 
                        else{
                            System.out.println("Price: ");
                            double price = Double.parseDouble(scan.nextLine().replace(",","."));
                            System.out.println("Stock quantity: ");
                            int quan = scan.nextInt();
                            scan.nextLine();
                            
                            System.out.println("\t==one step to add, enter 1 to keep or 0 to canceld==");
                            String ensuring = scan.nextLine();
                            
                            if(ensuring.equalsIgnoreCase("1")){
                                Product p = new Products(store.creationProductID(),pName,cate,price,quan);
                                
                                System.out.println("Enter '1' To add Extra Properties, '0' for not");
                                int addAttr = scan.nextInt();
                                scan.nextLine();
                        
                                while(addAttr == 1){
                                        System.out.println("Property name: ");
                                        String attrProp = scan.nextLine();
                                        System.out.println("Value: ");
                                        String attrVal = scan.nextLine();
                                
                                        ((Products)p).setAttribute(attrProp, attrVal);
                                        System.out.println("Enter '1' To add Another Extra Properties, '0' for not");
                                        addAttr = scan.nextInt();
                                        scan.nextLine();
                                        }
                                
                                    store.addProductToCategory(cate, p);
                                    System.out.println("Product Added");
                            }
                            else if (ensuring.equalsIgnoreCase("0")){
                                System.out.println("Add product Canceled");
                            }
                        }
                        
                    }
                    else{
                        System.out.println("Category didn exist yet");
                    }
                    
                } break;
                
                case 3:{
                    store.displayCategorys();
                } break;
                
                case 4: {
                    store.displayAllProduct();
                } break;
                case 0: {
                    x = false;
                } break;
            }
        }
    }
    
    public static void main(String [] args){
        boolean x = true;
        
        while(x){
            System.out.println("\tWELCOME TO LEGENDS STORE\n\n*  Choose mode");
            System.out.println("- 1. Seller Mode\n- 2. Customer Mode\n- 0. Exit");
            int mCho = scan.nextInt();
            scan.nextLine();
            
            switch (mCho) {
                case 1: {
                    sellerMode();
                } break;
                
                case 2: {
                    customerMode();
                } break;
                
                case 0: {
                    x = false;
                }
                
            }
            
            
            
        }
        
        
        
    }
    private static void customerMode(){
        System.out.println("\t--YOU ARE IN CUSTOMER MODE--");
        System.out.println("Enter your name: ");
        String cusName = scan.nextLine();
        System.out.println("Entr your Email");
        String cusEmail = scan.nextLine();
        
        User user = store.creatUser(cusName, cusEmail);
        Cart userCart = store.getUserCart(cusName);
        
        
        boolean x = true;
        while (x){
            
            System.out.println("- 1. Browse Categorys\n- 2. Show Cart\n- 3. wish\n- 0. Back to Main menu");
            int cusCho = scan.nextInt();
            scan.nextLine();
            
            switch(cusCho){
                case 1: {
                    store.displayCategorys();
                    System.out.println("choose categorys: \t\t or '0' to back to menu");
                    String catcho = scan.nextLine();
                    if(catcho.equalsIgnoreCase("0")){
                        break;
                    }
                    else{
                        var products = store.getProductsInCategorys(catcho);
                        if(products.isEmpty()){
                            System.out.println("there is no product in this category");
                            break;
                        }
                        for(Product p: products){
                        System.out.println(p.getDetails());
                        }
                        System.out.println("Enter product name to add in cart/wilshlist \t\t or '0' to back");
                        String prodName = scan.nextLine();
                        
                        if (prodName.equalsIgnoreCase("0")){
                            break;
                        }
                        else{
                            System.out.println("Enter '1' to add in Cart \t\t '2' to add in wishlist \t\tor '0' to back");
                            String cartOrWhis = scan.nextLine();
                            
                            if(cartOrWhis.equalsIgnoreCase("1")){
                                Product found= store.findProduct(prodName);
                                if(found == null){
                                    System.out.println("product not found, or wrong input!");
                                    break;
                                }
                    
                                System.out.println("Enter quantity: \t\t or '0' to cancel");
                                int quant = scan.nextInt();
                                scan.nextLine();
                                if(quant==0){
                                    break;
                                }
                                else if(quant !=0 && quant > found.getStockQuantity()){
                                    System.out.println("no stock enogh");
                                    break;
                                }
                                else {
                                    userCart.addProduct(found, quant);
                                    found.decreaseStock(quant);
                                    store.saveUsersCarts(cusName, userCart);
                                    System.out.println("Added to Cart"); 
                                }
                            }
                            else if(cartOrWhis.equalsIgnoreCase("2")){
                                Product found= store.findProduct(prodName);
                                store.addToWishList(cusName, found);
                            }
                        
                            }
                        }
                } break;
                
                case 2: {
                    System.out.println("In " + user.getName() +" Cart: \n");
                    for (CartItem item: userCart.getCartItems()){
                        System.out.println(item.getProduct().getName() + "#"+item.getQuantity());
                    }
                    System.out.println("Total: " + userCart.getTotalPrice() + " SAR\n");
                    
                    System.out.println("Enter '-r' to remove a product\t\t or 'N' to keep to Checkout \t\t '0' to back");
                    String removePorK = scan.nextLine();
                    if (removePorK.equals("-r")){
                        System.out.println("Eneter product name to remove: \t\t or '0' to cancel remove");
                        String removeP = scan.nextLine();
                        if(removeP.equalsIgnoreCase("0")){
                            break;
                        }
                        else {
                            Product toRemove = store.findProduct(removeP);
                        
                            if(toRemove != null){
                                userCart.removeProduct(toRemove);
                                store.saveUsersCarts(cusName, userCart);
                                System.out.println("Product removed");
                             }
                            else{
                                System.out.println("product not found");
                            }
                        }
                        
                    }
                    else if(removePorK.equalsIgnoreCase("N")){
                        if (userCart.getCartItems().isEmpty()){
                            System.out.println("Cart is Empry!");
                        }
                        else{
                        Order order = new Order(user, userCart.getCartItems());
                        order.generateInvoice();
                        userCart = new Cart();
                        store.saveUsersCarts(cusName, userCart);
                        System.out.println("Checkout Complete");    
                        }
                    }
                    
                    System.out.println("");
                    
                    
                } break;
                
                case 3:{
                    boolean w = true;
                    while(w){
                        System.out.println("- 1. Show whishlist\n- 2. remove from whislist\n- 0. back");
                        int wCho = scan.nextInt();
                        scan.nextLine();
                        switch(wCho){
                            case 1:{
                                var wishList = store.getUserWhishList(cusName);
                                if(wishList.isEmpty()){
                                    System.out.println("your Wish List is empty!");
                                }
                                else{
                                    System.out.println("\n Your Wish List:");
                                    for(Product p: wishList){
                                        System.out.println(p.getDetails() + " | ");
                                    }
                                }
                            } break;
                            
                            case 2:{
                                var wishList = store.getUserWhishList(cusName);
                                if (wishList.isEmpty()){
                                    System.out.println("your wishlidt is empty");
                                    break;
                                }
                                else{
                                    System.out.println("Enter product name to remove from wishlist");
                                    String removeW = scan.nextLine();
                                    Product found = store.findProduct(removeW);
                                    if(found != null){
                                        store.removeFromWishList(cusName, found);
                                    }
                                    else {
                                        System.out.println("Product didnt exist in whish list!");
                                    }
                                }
                            } break;
                            
                            case 0 :{
                                w = false;
                            }
                        }
                        
                    }
                } break;

                case 0:{
                    x = false;
                } break;
            }
            
        }
    }
}
