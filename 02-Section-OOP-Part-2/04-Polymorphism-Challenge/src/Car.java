import javax.sound.midi.SysexMessage;

public class Car {

    // define fields
    private String description;

    // define constructor

    public Car(String description) {
        this.description = description;
    }

    // define some methods
    public void startEngine() {
        String carType = this.getClass().getSimpleName();
        System.out.println("The " + carType + " engine is starting..");
    }

    public void drive() {
        System.out.println( this.getClass().getSimpleName() + " is driving...");
        runEngine();
    }

    protected void runEngine() {
        System.out.println(this.getClass().getSimpleName() + " Engine is running..");
    }
}
