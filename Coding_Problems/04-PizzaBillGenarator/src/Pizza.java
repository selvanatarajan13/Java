public class Pizza {

    private double price;
    private Boolean veg;
    private double extraCheese = 100;
    private double extraToppings = 150;
    private double takeAway = 25;
    private double basePrice;
    private Boolean isAddExtraCheese = false;
    private Boolean isAddExtraToppings = false;
    private Boolean isTakeAway = false;

    public Pizza(Boolean veg) {
        this.veg = veg;
        if (this.veg) {
            this.price = 300.00;
        } else {
            this.price = 400.00;
        }
        this.basePrice = this.price;
    }

    public void addExtraCheese() {
        isAddExtraCheese = true;
        price += extraCheese;
    }

    public void addExtraToppings() {
        isAddExtraToppings = true;
        price += extraToppings;
    }

    public void takeAway() {
        isTakeAway = true;
        price += takeAway;
    }

    public void getBill() {
        System.out.println("Pizza : " + basePrice);
        if (isAddExtraCheese) {
            System.out.println("Extra Cheese : " + extraCheese);
        }
        if (isAddExtraToppings) {
            System.out.println("Extra Toppings : " + extraToppings);
        }
        if (isTakeAway) {
            System.out.println("Take Away bag charge : " + takeAway);
        }
        System.out.println("------------------------");
        System.out.println("Total Amt : " + price);
        System.out.println("------------------------");
    }
}
