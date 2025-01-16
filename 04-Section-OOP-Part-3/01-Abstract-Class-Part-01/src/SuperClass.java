abstract public class SuperClass {

    public SuperClass() {
        System.out.println( getClass().getSimpleName() + " Constructor");
    }

    public void method1() {
        System.out.println(getClass().getSimpleName() + " method1.");
    }

    abstract public void method2();
}
