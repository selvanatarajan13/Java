public class Meal {

    private double base = 5.0;

    private Item burger;
    private Item drink;
    private Item side;

    private class Item {

        private String type;
        private String name;
        private double price;

        public Item(String type, String name) {
            this.type = type;
            this.name = name;
            this.price = type.equals("Burger") ? base : 0;
        }

        public Item(String type, String name, double price) {
            this.type = type;
            this.name = name;
            this.price = price;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "%10s %15s %5.2f $".formatted(type, name, price);
        }
    }

    public Meal() {
        burger = new Item("Burger", "Beef Burger");
        drink = new Item("Drink", "Coca Cola", 3);
        side = new Item("Side item", "Franch fries", 4);
    }

    private double getTotalAmt() {
        return burger.getPrice() + drink.getPrice() + side.getPrice();
    }

    @Override
    public String toString() {
        return "%s%n%s%n%s%n%28s%.2f".formatted(burger, drink, side, "Total Price ", getTotalAmt());
    }
}
