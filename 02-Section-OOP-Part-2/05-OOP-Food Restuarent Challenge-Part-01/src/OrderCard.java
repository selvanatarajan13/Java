import java.util.HashMap;
import java.util.Map;

public class OrderCard {

    private Item drinks;
    private Item sides;
    private Item item;

    public OrderCard(String drinkName, String sidesName) {
        this.drinks = new Item("Drink", drinkName, 40);
        this.sides = new Item("Side", sidesName, 80);
    }


    public double getTotalPrice() {
        return drinks.getAdjustedPrice() + sides.getAdjustedPrice();
    }


    public void printListItems() {
        drinks.printItem();
        sides.printItem();
        System.out.println("-".repeat(35));
        sides.printItem("Total Price", getTotalPrice());
        System.out.println("-".repeat(35));
    }

    public void setDrinkSize(String size) {
        drinks.setSize(size);
    }
}
