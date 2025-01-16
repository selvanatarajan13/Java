public class Burger extends Item {

    private Item toppings1;
    private Item toppings2;
    private Item toppings3;

    public Burger(String type, String name, double price) {
        super("Burger", name, price);
    }

    @Override
    public String getName() {
        return super.getName() + " Burger";
    }

    @Override
    public double getAdjustedPrice() {
        return super.getPrice() +
                ((toppings1 == null) ? 0 : toppings1.getAdjustedPrice()) +
                ((toppings2 == null) ? 0 : toppings2.getAdjustedPrice()) +
                ((toppings3 == null) ? 0: toppings3.getAdjustedPrice());
    }

    public double getExtraPrice(String toppingsName) {
        return switch (toppingsName.toUpperCase()) {
            case "AVOCADO", "CHEESE" -> 15;
            case "BACON", "HAM", "SALAMI" -> 30;
            default -> 0;
        };
    }

    public void addToppings(String toppings1, String toppings2, String toppings3) {
        this.toppings1 = new Item("TOPPINGS", toppings1, getExtraPrice(toppings1));
        this.toppings2 = new Item("TOPPINGS", toppings2, getExtraPrice(toppings2));
        this.toppings3 = new Item("TOPPINGS", toppings3, getExtraPrice(toppings3));
    }


}
