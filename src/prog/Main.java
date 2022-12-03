package prog;

import cart.Apple;
import cart.Item;
import cart.Orange;

public class Main {

    public static void main(String[] args) {
        
        // Item apple = new Item("apple", "appl");
        // Item orange = new Item("orange", "orng");

        // apple.setPrice(0.5f);
        // apple.setQuantity(10);
        // System.out.printf("$%f\n", apple.totalCost());

        // orange.setPrice(2.50f);
        // orange.setQuantity(20);
        // System.out.printf("$%f\n", orange.totalCost());

        Item apple = new Apple();
        //apple is an instance of Apple class but it is of an Item type hence you can't access the Apple class methods
        Item orange = new Orange();

        System.out.printf("Item: %s, Type: %s\n", apple.getName(), apple.getCode());

        // Assigning the subclass to the parent class
        // Can't access getType from Apple class 
        Item item = apple;
        System.out.printf("Item: %s, Type: %s\n", item.getName(), item.getCode());

        // Casting the item into an Apple class
        Apple washington = (Apple)item;
        System.out.printf("Type: %s\n", washington.getType());

        // Test if the object taken from item if that object is part of the subclass you're interested in
        System.out.printf("Is item an Orange", item instanceof Orange);
        if(item instanceof Orange) {
            orange = (Orange)item; //Error during execution
        }

        // 
        // orange = (Orange)item;


    }
    
}
