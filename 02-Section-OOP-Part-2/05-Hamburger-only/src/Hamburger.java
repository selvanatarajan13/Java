import java.util.ArrayList;
import java.util.List;

public class Hamburger {

    private String name;
    private Patty patty;
    private List<Toppings> extraToppings = new ArrayList<>();
    private double basePrice;
    private Toppings toppings;

    public Hamburger(String name, String patty, double basePrice) {
        this.name = name;
        this.patty = new Patty(patty);
        this.basePrice = basePrice;
    }

    public double getToppingPrice() {
        double price = 0;
        for (Toppings toppings1: extraToppings) {
             price = toppings1.getAdjustedPrice() + toppings1.getAdjustedPrice();
        }

        return price;
    }

    public void addExtraToppings(String toppingName) {
        toppings = new Toppings(toppingName);
        extraToppings.add(toppings);
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getAdjustedPrice() {
        return basePrice + patty.getTotPattyPrice() + getToppingPrice();
    }

    public String getName() {
        return name;
    }

    public void setPattyQuantity(int quantity) {
        patty.setQuantity(quantity);
    }

    public void printItem() {
        System.out.println("-".repeat(50));
        System.out.printf("%20s %12s   %8s %n","Description", "Quantity", "Price");
        System.out.println("-".repeat(50));
        System.out.printf("%20s  %21.2f $%n", getName(), getBasePrice());
        patty.printItem();
        if (extraToppings != null) {
            for (Toppings toppings3: extraToppings){
                System.out.printf("%20s  %22.2f $%n", toppings3.getName(), toppings3.getAdjustedPrice());
            }
        }
        System.out.println("-".repeat(50));
        System.out.printf("%20s %23.2f %n","Total", getAdjustedPrice());
        System.out.println("-".repeat(50));


    }

}
