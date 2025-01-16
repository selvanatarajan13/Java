public class Item {

    private String type;
    private String name;
    private double price;
    private String size = "MEDIUM";

    public Item(String type, String name, double price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    // base price
    public double getPrice() {
        return price;
    }

    public String getName() {
        return size.toUpperCase() + " " + name;
    }

    // set the size
    public void setSize(String size) {
        this.size = size;
    }

    // adjusted price depands upon the size (drinks)
    public double getAdjustedPrice() {
        return switch (size.toUpperCase()) {
            case "SMALL" -> getPrice() - 30;
            case "LARGE" -> getPrice() + 50;
            default -> getPrice();
        };
    }

    public void printItem() {
        printItem(getName(), getAdjustedPrice());
    }

    public void printItem(String name, double price) {
        System.out.printf("%20s:%9.2f%n", name, price);
    }
}
