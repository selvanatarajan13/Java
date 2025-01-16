public class OrderCard {

    private Item side;
    private Item drink;
    private Burger burger;
    private double totalPrice;

    public OrderCard() {
        this("regular", "fries", "coke");
    }


    public OrderCard( String burgerName, String sideName, String drinkName) {
        this.burger = new Burger(burgerName, 5);
        this.side = new Item("side", sideName, 4);
        this.drink = new Item("drink", drinkName, 3);
    }

    public void setExtraToppings(String topping1, String topping2, String topping3) {
        burger.addToppings(topping1,topping2,topping3);
    }

    public void setDrinkSize(String size) {
        drink.setSize(size);
    }

    public double getTotalPrice() {
        return side.getAdjustedPrice() + drink.getAdjustedPrice() + burger.getAdjustedPrice();
    }

    public void printItemizedList() {
        side.printItem();
        drink.printItem();
        burger.printItemizedList();
    }

    public void printItem() {
        burger.printItem();
        side.printItem();
        drink.printItem();
        System.out.println("-".repeat(43));
        System.out.printf("%30s : $ %5.2f%n","Total Amt", getTotalPrice());
        System.out.println("-".repeat(43));
    }
}
