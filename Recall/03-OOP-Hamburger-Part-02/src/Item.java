public class Item {

    private String type;
    private String name;
    private double price;
    private String size = "MEDIUM";

    public Item(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public double getBasePrice() {
        return price;
    }

    public String getName() {
        return type + " " + name;
    }

    public void setSize(String size) {
        this.size = size.toUpperCase();
    }

    public double getAdjustedPrice() {
        return switch (size) {
            case "SMALL" -> getBasePrice() + 5;
            case "MEDIUM" -> getBasePrice() + 6;
            case  "LARGE" -> getBasePrice() + 8;
            case "EXTRA LARGE" -> getBasePrice() + 10;
            default -> getBasePrice() + 6;
        }
    }

    public void printItem() {
        printItem(getName(), getAdjustedPrice());
    }

    public static void printItem(String itemName, double itemPrice) {
        System.out.println();
    }
}
