public class Main {
    public static void main(String[] args) {
        System.out.printf("%40s%n%n","Welcome Bills Hamburger Restaurant");

        OrderCard n1 = new OrderCard("Regular", "fries", "Coke");
        n1.setDrinkSize("small");
        n1.setExtraToppings("cheese","ham","tomato");
        n1.printItem();
    }
}