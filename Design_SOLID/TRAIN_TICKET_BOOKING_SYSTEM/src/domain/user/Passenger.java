package domain.user;

public class Passenger {
    private final String name;
    private final int age;
    private final PassengerType type;

    public Passenger(String name, int age, PassengerType type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public PassengerType getType() {
        return type;
    }
}
