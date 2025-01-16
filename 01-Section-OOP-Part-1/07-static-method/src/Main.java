public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Calculator.printSum(5,6);
        printHello();
        Calculator mul = new Calculator();
        mul.printMul(2,3);

    }

    public static void printHello() {
        System.out.println("Hello");
    }

    public void printSomething() {
        System.out.println("Expectation kills your happiness!");
        printHello();
    }
}