package revision.shoppingcart;

public class Item {

    private String name; // String without initalising is null
    private String code;
    private float price; // Float -> class and float -> primitive
    // private Float price = new Float;
    private int quantity;

    // Getters
    public String getName() {
        return name;
    }
    public String getCode() {
        return code;
    }
    public float getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }

     // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Constructors

    public Item(String name, String code, int quantity, float price) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.quantity = quantity;
    }

    public Item(float price, int quantity) {
        this.name = "Item";
        this.code = "itm";
        this.price = price;
        this.quantity = quantity;
    }

    
    
    
}
