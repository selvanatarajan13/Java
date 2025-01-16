public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        ComputerCase c1 = new ComputerCase(
                "Circle Furious Mesh 240 ARG Mid-Tower", "Furious",
                "240V"
        );

        MotherBoard c2 = new MotherBoard(
                "Consistent DDR3 MotherBoard CMB H61", "Consistent",
                4,6, "v2.44"
        );

        Monitor c3 = new Monitor(
                "2208", "ACER", 27, "2450 x 1440"
        );

        PersonalComputer myPC = new PersonalComputer(
                "Dell", "Dell", c3, c2, c1
        );

        System.out.println(myPC.getComputerCase());
    }
}