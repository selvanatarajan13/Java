public class Person {

    private String name;
    private DOB dob;

    public Person(String name, DOB dob) {
        this.name = name;
        this.dob = dob;
    }

    public void printPerson() {
        System.out.println("Name   : " + name);
        dob.printDOB();
    }
}
