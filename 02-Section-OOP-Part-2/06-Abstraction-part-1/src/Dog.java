public class Dog extends Animal {

    private String name;

    public Dog(String type, String name, String size, double weight) {
        super(type, size, weight);
        this.name = name;
    }

    @Override
    public void move(String speed) {
        System.out.println("The " + name + " " + getType() + " is run " + speed + "..");
    }

    @Override
    public void makeNoise() {
        if (getType().toUpperCase() == "WOLF") {
            System.out.println("Howling..");
        } else {
            System.out.println("Lol lol!...");
        }
    }
}
