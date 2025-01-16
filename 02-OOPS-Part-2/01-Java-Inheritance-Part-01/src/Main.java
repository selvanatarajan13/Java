/*
    * This program is explain about Inheritance and how to write the code.
    * Here, "Bikes" is a super class or parent class. we know that the inheritance, the class whose
      features are inherited is known as a superclass/ parent class.
    * "SuperBike" is the subclass.The class is inherited the other class is known as the subclass or child class.
       This "SuperBike" class is inherited by "Bikes" class.
*/

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        SuperBike superBike = new SuperBike(
                "Yamaha","FZs Fi V4","Disc and ABS",136,"Black",
                149,7250,13,129785,"Liquid Cool"
        );
        doBikeStuff(superBike);
    }

    public static void doBikeStuff(Bikes bikes) {
        System.out.println(bikes);
    }
}