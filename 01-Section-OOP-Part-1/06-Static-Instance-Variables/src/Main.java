public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Dog rex = new Dog("rex");
        Dog flubby = new Dog("Flubby"); // In static, once we made a change, all the instance see what made it. so, Flubby is printed twice.
        rex.printName();
        flubby.printName();
    }
}