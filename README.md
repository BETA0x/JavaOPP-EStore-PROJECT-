# Java OOP E-Store project

Until now there is just a normal code, the project will have a GUI code as soon as we can

**----Bad news.. no GUI will be in this project (Will take a long time)**

So now what is in E-Store project, let me explain what I can.

At first, the project was too simple, a basic E-Store with a little bet of features,  
but while we coding.. line by line, we inspired a new idea and as soon as we well tried it,  
and by used the concept of Object Oriented Programming with the medium into high level commands,  
now we have this E-Store Project that all of us work on it!

---

## My Team 'LEGENDS'  
Leader: BETATui (me)  
member: Weasam (n/a)  
member: Haitem (@Haitem0097)  


## Class Overview  
  
#### Product {
An abstract class. defines the shared structure for all type of products:
  
- ID  
- Name  
- Category  
- Price  
- Stock quantity
    
Why abstract?
cuz we dont want to creat a generic "Product directly.

it include:
- Abstract method getDetails(), which subclasses must implement.
- Basic methods for price, quantity, reduce stock.
#### }

#### Products {
A concrete implementation of Product class  

this class let you creat a real product, and even add custom or Extra attributes like:   
- Author fo books
- Warranty for electronics
    
- Uses a HashMap<String,String> to store attributes key-value pairs.  

- As an Example:
Product.setAttribute("color","Black");

- getDetails() is Overriding to include extra attributes if they exist.
  #### }

#### User{
user with:
- ID
- Name
- Email
- Wishlist (stored as ArrayList<Product>)

The Wishlist manage locally with:
- addToWishlist(Product p)
- removeFromWishlist(Product p)
- getWishlist

#### }

#### CartItem {
- Product
- Quantity
  ..
it has getSubtotal() method to multiply price into quantity
#### }

#### Cart {

- Uses ArrayList<CartItem> to store what user adds

- you can addProduct and remove and getTotalPrice

#### }

#### Order {
- orderID --> auto incremented by static counter
- User who placsed the order
- list of cartItems
- Total price
- Generate Invoce
#### }

#### Store {
- Stores everything, Categorys products users..
- Uses multiple HashMaps for orgnaization

The Categorys = list of products  
The Users = User objects  
usersCarts = personal shopping carts  

- Each user has a persistent cart and wishlist.
- Whene user login his data retrieve by username

Also support wishlist management and display all products and categorys.
#### }

#### UsingMode {
This class handles Switching between Sellar and Customer Modes  
  
- Seller Mode:  
Add categorys, products, Manage and show them .

- Customer Mode:  
    Make an own account, brows categorys and products, add your wishlist, show cart and checkout     
#### }

#### Main? {  

The main class is turn on the console use main that is in UsingMode; cuz when we create this program we keen to make sure that it was ready to add GUI.  

#### }

##Technical Notes:
- Lambda used in Cart class "removeIf()" to remove a product based on reference.
- HashMaps
- Data stores in memory, no DB or Files i/o.
- Abstract + inheritance used where it actually made sense.
 
