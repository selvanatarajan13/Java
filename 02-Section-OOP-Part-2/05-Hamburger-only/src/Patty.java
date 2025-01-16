public class Patty {

    private String type;
    private double price;
    private int quantity;

    public Patty(String type) {
        this.type = type.toUpperCase();
        this.quantity = 1;
    }

    public double getBasePrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAdjustedPrice() {
        return switch (type) {
            case "CHICKEN" -> getBasePrice() + 5;
            case "PORK", "BORK" -> getBasePrice() + 6;
            case "MEAT" -> getBasePrice() + 8;
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };
    }

    public double getTotPattyPrice() {
        if (quantity != 1) {
            return getAdjustedPrice() * quantity;
        }

        return getAdjustedPrice();
    }

    public String getName() {
        return type + " " + "Patty";
    }

    public void printItem() {
//        System.out.println("-".repeat(50));
//        System.out.printf("%20s %12s   %8s %n","Description", "Quantity", "Price");
//        System.out.println("-".repeat(50));
        System.out.printf("%20s %8d  %13.2f $%n", getName(), getQuantity(), getTotPattyPrice());
    }
}
