public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        Hamburger hamburger = new Hamburger(
                "Classic Cheese Burger", "meat", 5
        );
        hamburger.setPattyQuantity(3);
        hamburger.addExtraToppings("avocoda");
        hamburger.addExtraToppings("Mushroom");
        hamburger.printItem();
    }
}