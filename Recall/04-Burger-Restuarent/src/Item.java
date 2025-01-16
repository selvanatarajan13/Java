public class Item {

    private String type;
    private String name;
    private double price;

    public Item() {

    }

    public Item(FoodType type, String name, double price) {
        this.type = String.valueOf(type);
        this.name = name;
        this.price = price;
    }

    public Item(FoodType type, String name) {
        this(type, name, String.valueOf(type).equals("BURGER") ? 4 : String.valueOf(type).equals("DRINK") ? 5 : 0);
    }

    public String getName() {
        return name;
    }

    protected double getBasePrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "%15s %20s".formatted(getType(), getName());
    }
}
