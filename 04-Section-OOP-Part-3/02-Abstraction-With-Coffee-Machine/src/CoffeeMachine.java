import java.util.Map;

public class CoffeeMachine {

    private Map<CoffeeSelection, CoffeeBean> bean;

    public CoffeeMachine(Map<CoffeeSelection, CoffeeBean> bean) {
        this.bean = bean;
    }

    public Coffee brewCoffee(CoffeeSelection coffeeSelection) {
        coffeeSelectionCoffee coffee = new Coffee();
    }
}
