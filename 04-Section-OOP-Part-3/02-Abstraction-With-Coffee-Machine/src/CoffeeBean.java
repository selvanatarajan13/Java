/*
    This CoffeeBean class is a simple POJO class that only store a set of attributes
    without providing any logic.
 */

public class CoffeeBean {

    private String name;
    private double quantity;

    public CoffeeBean(String name, double quantity) {
        this.name = name;
        this.quantity = quantity;
    }
}
