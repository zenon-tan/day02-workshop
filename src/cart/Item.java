package cart;

public class Item {

    // Members
    private String name; // String without initalising is null
    private String code;
    private float price; // Float -> class and float -> primitive
    // private Float price = new Float;
    private int quantity;

    // Constructor

    public Item(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public Item(int quantity, float price) {
        this.quantity = quantity;
        this.price = price;

    }

    public Item(int quantity, float price, String name, String code) {
        this.quantity = quantity;
        this.price = price;
        this.name = name;
        this.code = code;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float totalCost() {
        float total = this.quantity * this.price;
        return total;
    }


    



    
}

