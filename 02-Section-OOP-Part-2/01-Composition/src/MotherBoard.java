public class MotherBoard extends Product {

    private int ramSlot;
    private int cardSlot;
    private String bios;

    public MotherBoard(String model, String manufacture) {
        super(model, manufacture);
    }

    public MotherBoard(String model, String manufacture, int ramSlot, int cardSlot, String bios) {
        super(model, manufacture);
        this.ramSlot = ramSlot;
        this.cardSlot = cardSlot;
        this.bios = bios;
    }

    public void loadProgram(String programName) {
        System.out.println("Program " + programName + " is now loading..");
    }

    @Override
    public String toString() {
        return "MotherBoard{" +
                "ramSlot=" + ramSlot +
                ", cardSlot=" + cardSlot +
                ", bios='" + bios + '\'' +
                "} " + super.toString();
    }
}
