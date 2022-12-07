import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import revision.shoppingcart.Apple;
import revision.shoppingcart.Item;
import revision.shoppingcart.Orange;


public class ShoppingCart {

    public static final String LIST = "list";
    public static final String ADD = "add";
    public static final String DELETE = "delete";
    public static final String EXIT = "exit";
    public static final List<String> COMMANDS_LIST = Arrays.asList(LIST, ADD, DELETE, EXIT);
    

    public static void main(String[] args) {


    // Create a scanner object for console input

    Scanner sc = new Scanner(System.in);

    // Create a LinkedList to add items
    HashMap<String, Item> shoppingList = new HashMap<String, Item>();
    List<String> shoppingListKey = new LinkedList<String>();

    //while 'exit' is not typed, program will not quit
    // Switch statement for different inputs

    boolean isQuit = false;

    System.out.println("Welcome to your shopping cart");

    while(!isQuit) {
        
        System.out.printf("> ");

        String input = sc.nextLine();
        String[] removeCommand = input.toLowerCase().trim().split(" ", 2);

        ArrayList<String[]> individualItems = new ArrayList<String[]>();

        String command = removeCommand[0];
        
        //String command = splitString[0];

        if(!COMMANDS_LIST.contains(command)) {
            System.out.println("Incorrect command, please retype");
        }

        switch (command) {
            case EXIT:
            System.out.println("Exiting Shopping Cart...");
            System.out.println("Printing Shopping Cart contents...");
            isQuit = true;

            case LIST:

                if(shoppingList.size() == 0) {
                    System.out.println("Your cart is empty");
                } else {
                    System.out.println("Your shopping list: ");
                    int counter = 1;
                    for(String item : shoppingList.keySet()) {
                        System.out.printf("%d. %s | Quantity: %d | Price: $%.2f\n", counter, item.toUpperCase(), shoppingList.get(item).getQuantity(), shoppingList.get(item).getPrice());
                        counter++;
                    
                    }
                }

                break;

            case ADD:
                String[] splitItems = removeCommand[1].split(",");

                //System.out.println(splitItems[1]);
                for(int i = 0; i < splitItems.length; i++) {
                    String[] tempList = splitItems[i].trim().split(" ");
                    individualItems.add(tempList);
                }

                for(int i = 0; i < individualItems.size(); i++) {
                    if (shoppingList.containsKey(individualItems.get(i)[0])) {
                        System.out.printf("You have %s in your cart\n", individualItems.get(i)[0]);
                    } else {
                        if(individualItems.get(i)[0] == "apple") {
                            Item apple = new Apple(Integer.parseInt(individualItems.get(i)[1]), Float.parseFloat(individualItems.get(i)[2]));
                            shoppingList.put(individualItems.get(i)[0], apple);

                        } else if(individualItems.get(i)[0] == "orange") {
                            Item orange = new Orange(Integer.parseInt(individualItems.get(i)[1]), Float.parseFloat(individualItems.get(i)[2]));
                            shoppingList.put(individualItems.get(i)[0], orange);

                        } else {
                            String name = individualItems.get(i)[0];
                            int quantity = Integer.parseInt(individualItems.get(i)[1]);
                            float price = Float.parseFloat(individualItems.get(i)[2]);
                            Item item = new Item(name, name, quantity, price);
                            shoppingList.put(name, item);

                        }
                        shoppingListKey.add(individualItems.get(i)[0]);

                        System.out.printf("%d * %s added to cart\n",Integer.parseInt(individualItems.get(i)[1]), individualItems.get(i)[0].toUpperCase());
                    }
                }

                break;

            case DELETE:

                try {
                    int deleteIndex = Integer.parseInt(removeCommand[1]);
                    
                    try {
                        System.out.printf("%s removed from cart\n", shoppingListKey.get(deleteIndex - 1));
                        shoppingList.remove(shoppingListKey.get(deleteIndex - 1));
                        shoppingListKey.remove(deleteIndex -1);
                        
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Index out of bounds, please check the cart");
                    }
                    
                    
                } catch (NumberFormatException e) {
                    if(shoppingListKey.contains(removeCommand[1])) {
                        System.out.printf("%s removed from cart\n",removeCommand[1].toUpperCase());
                        shoppingListKey.remove(removeCommand[1]);
                        shoppingList.remove(removeCommand[1]);
                        

                    } else {
                        System.out.printf("%s does not exist in the cart\n", removeCommand[1].toUpperCase());
                    }
                }
                break;

            default:
                break;

        

        
    }


        
    }



}
}

