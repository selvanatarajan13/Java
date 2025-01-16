public class Product {

    private String model;
    private String manufacture;

    public Product(String model, String manufacture) {
        this.model = model;
        this.manufacture = manufacture;
    }

    @Override
    public String toString() {
        return "Product{" +
                "model='" + model + '\'' +
                ", manufacture='" + manufacture + '\'' +
                '}';
    }
}
