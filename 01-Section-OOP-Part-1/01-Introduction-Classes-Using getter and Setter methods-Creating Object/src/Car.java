public class Car {

    // define fields
    private int door;
    private String company;
    private String model;
    private String color;

    // define method or behaviour
    public void describeCar() {
        System.out.println(
                "Car company " + company +", Model - " + model + ", Color - " + color + ", No.of doors "
                + door
        );
    }

    public int getDoor() {
        return door;
    }

    public void setDoor(int door) {
        this.door = door;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
