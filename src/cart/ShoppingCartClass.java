package cart;

import java.io.Console;
import java.util.LinkedList;
import java.util.List;

import cart.Apple;
import cart.Item;
import cart.Orange;

public class ShoppingCartClass {

    // TO DO: add and subtract existing quantity of the same item to the cart
    // Catch error when the input formatting is wrong

    public static void main(String[] args) {

    Console cons = System.console();
    List<Item> shoppingList = new LinkedList<Item>();

    boolean isQuit = false;

    float checkOutSum = 0f;

    System.out.println("");

    System.out.println("Welcome to your shopping cart");

    while(!isQuit) {

        String item = cons.readLine("> ").trim().toLowerCase();
        String[] splitString = item.split(" ");

        if(splitString.length == 1 && !splitString[0].equals("list") && !splitString[0].equals("quit")) {
            System.err.println("Please enter an object ");
        }

        switch(splitString[0]) {
            case "add":
            try {
                int quantity = Integer.parseInt(splitString[2]);
                float price = Float.valueOf(splitString[3]);
                boolean isExists = false;

                for(int j = 0; j < shoppingList.size(); j++) {

                    String stringName = (shoppingList.get(j)).getName();

                    if(stringName.equals(splitString[1])) {

                        System.out.printf("You have %s in your cart\n", splitString[1]);
                        isExists = true;

                    }


                }

                if(!isExists) {

                    if(splitString[1] == "apple") {
                        Item apple = new Apple(quantity, price);
                        shoppingList.add(apple);
                    }
    
                    else if(splitString[1] == "orange") {
                        Item orange = new Orange(quantity, price);
                        shoppingList.add(orange);
                    }
    
                    else {
    
                        Item other = new Item(quantity, price, splitString[1], splitString[1]);
                        shoppingList.add(other);

                    }
                    System.out.printf("%d x %s added to cart at $%.2f\n", quantity, splitString[1], price);
                    isExists = false;
                    checkOutSum += quantity * price;

                }

            } catch (ArrayIndexOutOfBoundsException e) {
                
            }
            

                break;

            case "delete":
            for(int i = 1; i < splitString.length; i++)
            {
                int listElement = Integer.parseInt(splitString[i]);
                try {

                    System.out.printf("%s removed from cart\n", (shoppingList.get(listElement - 1)).getName());
                    shoppingList.remove(listElement - 1);

                } catch(IndexOutOfBoundsException e) {
                    System.out.println("Incorrect item index");
                    System.out.println("Continue adding or deleting items, or list the items added");
                }
            
            }
                break;

            case "checkout":
                isQuit = true;
                System.out.println("Checking out...");
                System.out.println("Printing contents of the shopping cart: ");
                System.out.printf("The total price of %d items is $%.2f. \n", shoppingList.size(), checkOutSum);

            case "list":
                if(shoppingList.size() == 0) {
                    System.out.println("Your cart is empty");
                }

                else{
                    for(int i = 0; i < shoppingList.size(); i++) {
                        String getItemName = shoppingList.get(i).getName();
                        int getQuantity = shoppingList.get(i).getQuantity();
                        float getPrice = shoppingList.get(i).getPrice();

                        System.out.printf("%d. %s: %d x $%.2f -> $%.2f\n", i + 1, getItemName, getQuantity, getPrice, (getPrice * getQuantity));
                    }
                }
                break;

            default:
                break;

        }
     }
        
    }
    
}
