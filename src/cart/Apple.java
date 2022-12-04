package cart;

public class Apple extends Item {

    private String type = "";
    
    public Apple() {
        super("apple", "appl");
    }

    public Apple(int quantity, float price) {
        super(quantity, price, "apple", "appl");
    
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    

    
}


