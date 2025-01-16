// define class using class keyword called Car.
// class is the blueprint of the object.
public class Car { // Car is an object

    // fields or attributes or properties
    private String carCompany;
    private String model;
    private String color;


    // getter and setter methods
    public String getCarCompany() {
        return carCompany;
    }

    public void setCarCompany(String carCompany) {
        this.carCompany = carCompany;
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

    // method or behaviour
    public void describeCar() {
        System.out.println("This is the " + carCompany + " " + color + " car. Model - " + model);
    }

}
