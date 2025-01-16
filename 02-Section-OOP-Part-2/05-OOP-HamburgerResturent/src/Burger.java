import java.awt.*;

public class Burger extends Item {

    private Item extra1;
    private Item extra2;
    private Item extra3;

    public Burger(String type, double price) {
        super(type, "Burger", price);
    }

    @Override
    public String getName() {
        return super.getName() + " " + " BURGER";
    }



    @Override
    public double getAdjustedPrice() {
        return getBasePrice() +
                ((extra1==null) ? 0 : extra1.getAdjustedPrice()) +
                ((extra2==null) ? 0 : extra2.getAdjustedPrice()) +
                ((extra3==null) ? 0 : extra3.getAdjustedPrice());
    }

    public double getExtraPrice(String toppingsName) {
        return switch(toppingsName.toUpperCase()) {
            case "AVOCODA","CHEESE" -> 1.0;
            case "BACON", "HAM", "SALAMI" -> 1.5;
            case "MUSHROOMS", "TOMATO" -> 2;
            case "Sausage", "EGG" -> 2.5;
            default -> 0.0;
        };
    }

    public void addToppings(String extra1, String extra2, String extra3) {
        this.extra1 = new Item("Topping", extra1, getExtraPrice(extra1));
        this.extra2 = new Item("Topping", extra2, getExtraPrice(extra2));
        this.extra3 = new Item("Topping", extra3, getExtraPrice(extra3));
    }

    public void printItemizedList() {
        printItem("Base Burger", getBasePrice());
        if (extra1 != null) {
            extra1.printItem();
        }

        if (extra2 != null) {
            extra2.printItem();
        }

        if (extra3 != null) {
            extra3.printItem();
        }
    }

    @Override
    public void printItem() {
        printItemizedList();
    }
}
