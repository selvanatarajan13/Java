public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        DOB selvaDOB = new DOB(12, "JUNE", 2003);
        Person selva = new Person("SELVANATARAJAN S", selvaDOB);

        selva.printPerson();
    }
}