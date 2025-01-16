import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        List<Animal> animals = new ArrayList<>();

        Animal dog = new Dog("Dog", "German Sheppard", "large", 120);
        doAnimalStuff(dog, animals);

        Animal tiger = new Tiger("Tiger", "West Bangal Tiger", "large", 250);
        doAnimalStuff(tiger, animals);

        System.out.println(animals);
    }

    private static void doAnimalStuff(Animal animal, List<Animal> animals) {
        animal.makeNoise();
        if (animal.getSize().toUpperCase().equals("LARGE")) {
            animal.move("fast");
        } else {
            animal.move("slow");
        }
        animals.add(animal);
    }
}