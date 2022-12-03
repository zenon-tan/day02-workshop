package cart;

import java.io.Console;
import java.util.LinkedList;
import java.util.List;

import cart.Apple;
import cart.Item;
import cart.Orange;

public class ShoppingCartClass {

    public static void main(String[] args) {

    Console cons = System.console();
    List<Item> shoppingList = new LinkedList<Item>();

    boolean isQuit = false;

    System.out.println("");

    System.out.println("Welcome to your shopping cart");

    while(!isQuit) {

        String item = cons.readLine("> ").trim().toLowerCase().replaceAll(",", "");
            String[] splitString = item.split(" ");

        if(splitString.length == 1 && !splitString[0].equals("list") && !splitString[0].equals("quit")) {
            System.out.println("Please enter an object ");
        }

        switch(splitString[0]) {
            case "add":
            for(int i = 1; i < splitString.length; i++)
            {
                boolean isExists = false;

                for(int j = 0; j < shoppingList.size(); j++) {

                    String stringName = (shoppingList.get(j)).getName();

                    if(stringName.equals(splitString[i])) {

                        System.out.printf("You have %s in your cart\n", splitString[i]);
                        isExists = true;

                    }


                }
                
                if(splitString[i] == "apple" && !isExists) {
                    Item apple = new Apple();
                    shoppingList.add(apple);
                    System.out.printf("%s added to cart\n", splitString[i]);
                    isExists = false;
                }

                else if(splitString[i] == "orange" && !isExists) {
                    Item orange = new Orange();
                    shoppingList.add(orange);
                    System.out.printf("%s added to cart\n", splitString[i]);
                    isExists = false;

                }

                else if(!isExists) {

                    Item other = new Item(splitString[i], splitString[i]);
                    shoppingList.add(other);
                    System.out.printf("%s added to cart\n", splitString[i]);
                    isExists = false;

                }


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

            case "quit":
                isQuit = true;
                System.out.println("Shopping cart exited");
                System.out.println("Printing contents of the shopping cart: ");

            case "list":
                if(shoppingList.size() == 0) {
                    System.out.println("Your cart is empty");
                }

                else{
                    for(int i = 0; i < shoppingList.size(); i++) {
                        String getItemName = shoppingList.get(i).getName();

                        System.out.printf("%d. %s\n", i + 1, getItemName);
                    }
                }
                break;


            default:
                break;

        }
     }
        
    }
    
}
