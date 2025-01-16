public class Burger extends Item {

    private double basePrice;
    private int quantity = 1;
    private String size = "MEDIUM";


    public Burger(FoodType type, String name) {
        super(type, name);
    }

    public Burger(FoodType type, String name, int quantity) {
        super(type, name);
        this.quantity = quantity;
    }

    public void setSize(String size) {
        this.size = size.toUpperCase();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAdjPrice() {
        return switch (size) {
            case "SMALL" -> (getBasePrice() - 2) * quantity;
            case "LARGE" -> (getBasePrice() + 2) * quantity;
            default -> getBasePrice() * quantity;
        };
    }

    @Override
    public String toString() {
        return "%s %8d %10.2f $".formatted(super.toString(), getQuantity(), getAdjPrice());
    }
}
