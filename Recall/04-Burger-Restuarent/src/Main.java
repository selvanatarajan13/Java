public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Burger burger = new Burger(FoodType.BURGER, "Regular Burger");
        burger.setQuantity(3);
        System.out.println(burger);
    }
}