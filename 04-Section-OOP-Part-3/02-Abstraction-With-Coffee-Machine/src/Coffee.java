/*
    This class Coffee is the simple POJO class that only store a set of attributes without
    providing any logic...
 */

public class Coffee {

    private CoffeeSelection coffeeSelection;
    private double quantity;

    public Coffee(CoffeeSelection coffeeSelection, double quantity) {
        this.coffeeSelection = coffeeSelection;
        this.quantity = quantity;
    }
}
