public class Monitor extends Product{

    private int size;
    private String resolution;

    public Monitor(String model, String manufacture) {
        super(model, manufacture);
    }

    public Monitor(String model, String manufacture, int size, String resolution) {
        super(model, manufacture);
        this.size = size;
        this.resolution = resolution;
    }

    public void getScreenSize() {
        System.out.println("Its " + resolution + "..." );
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "size=" + size +
                ", resolution='" + resolution + '\'' +
                "} " + super.toString();
    }
}
