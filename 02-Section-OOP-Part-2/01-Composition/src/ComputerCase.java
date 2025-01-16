public class ComputerCase extends Product {

    private String powerSupply;

    public ComputerCase(String model, String manufacture) {
        super(model, manufacture);
    }

    public ComputerCase(String model, String manufacture, String powerSupply) {
        super(model, manufacture);
        this.powerSupply = powerSupply;
    }

    public void pressPowerButton() {
        System.out.println("The System is ON...");
    }
}
