public class Main {
    public static void main(String[] args) {
        System.out.println("This program explain the Runtime or Dynamic Dispatch Polymorphism concept");

        Animal dog = new Dog();
        dog.speak();
        Animal wolf = new Wolf();
        wolf.speak();
    }
}