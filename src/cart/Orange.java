package cart;

public class Orange extends Item {

    private String type;

    public Orange() {
        super("orange", "orng");
    }

    public Orange(int quantity, float price) {
        super(quantity, price);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    
    
}
