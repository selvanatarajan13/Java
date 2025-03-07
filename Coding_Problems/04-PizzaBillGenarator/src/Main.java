public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome Pizza World!");

        Pizza myPizza = new Pizza(false);
        myPizza.addExtraToppings();
        myPizza.takeAway();
        myPizza.getBill();
    }
}