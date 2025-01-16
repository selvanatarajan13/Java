public class SubClass extends SuperClass {

    @Override
    public void method2() {
        System.out.println("This is " + getClass().getSimpleName() + " method2.");
    }
}
