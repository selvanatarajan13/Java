import java.awt.desktop.SystemEventListener;

public class PatroleumCar extends Car {

    private double avgKmPerLitre;
    private int cylinders;

    public PatroleumCar(String description) {
        super(description);
    }

    public PatroleumCar(String description, double avgKmPerLitre, int cylinders) {
        super(description);
        this.avgKmPerLitre = avgKmPerLitre;
        this.cylinders = cylinders;
    }

    @Override
    public void startEngine() {
        super.startEngine();
        System.out.printf(this.getClass().getSimpleName() + "-> All %d cylinders are fired up, Ready to drag%n", cylinders);
    }

    @Override
    public void drive() {
        super.drive();
        System.out.printf(this.getClass().getSimpleName() + "-> Usage exceeds the average: %.2f KmPL%n", avgKmPerLitre);
        System.out.println("---------------------------------------");
    }
}
