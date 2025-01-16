public class Toppings {

    private String type;
    private double price;

    public Toppings(String type) {
        this.type = type.toUpperCase();
    }

    public double getBasePrice() {
        return price;
    }

    public double getAdjustedPrice() {
        return switch (type) {
            case "AVOCODA","BACON" -> getBasePrice() + 3;
            case "TOMATO SAUCE" -> getBasePrice() + 2;
            case "MUSHROOM", "Extra CHEESE" -> getBasePrice() + 3.5;
            default -> getBasePrice();
        };
    }

    public String getName() {
        return type + " " + "Topping";
    }

    public void printItem() {
//        System.out.println("-".repeat(50));
//        System.out.printf("%20s %12s   %8s %n","Description", "Quantity", "Price");
//        System.out.println("-".repeat(50));
        System.out.printf("%20s  %22.2f $%n", getName(), getAdjustedPrice());
    }
}
