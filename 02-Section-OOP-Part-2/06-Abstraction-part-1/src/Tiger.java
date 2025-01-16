public class Tiger extends Animal {

    private String name;

    public Tiger(String type, String name, String size, double weight) {
        super(type, size, weight);
        this.name = name;
    }

    @Override
    public void move(String speed) {
        System.out.println("The " + name + " " + getType() + " is run " + speed + "..");
    }

    @Override
    public void makeNoise() {
        System.out.println("Roar Roar..");
    }
}
