public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // Loosely Coupled
        System.out.println("-".repeat(30));
        System.out.println("Loosely Coupled");

        Laptop laptop = new Laptop();
        Desktop desktop = new Desktop();
        LooselyCoupled looselyCoupled = new LooselyCoupled();

        looselyCoupled.code(laptop);
        looselyCoupled.code(desktop);

        System.out.println("-".repeat(30));

        // Tightly coupled
        System.out.println("Tight Coupled");

        TightCoupled tightCoupled = new TightCoupled();
        tightCoupled.code(laptop);
        // we can't change the source of compiler instead of dektop
        // tightCoupled.code(desktop);
    }
}