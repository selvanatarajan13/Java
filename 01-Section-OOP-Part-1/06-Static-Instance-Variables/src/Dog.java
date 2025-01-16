public class Dog {

    private static String name; // this is the static variable

    public Dog(String name) {
        Dog.name = name;
    }

    public void printName() {
        System.out.println("name : " + name);
    }
}
