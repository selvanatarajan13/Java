import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Employee jack = new Employee("Jack",25000);
        Employee john = new Employee("john",27000);
        Manager robert = new Manager("Robert", 50000);

        System.out.println(jack.getSalary());

        ArrayList<Employee> objects = new ArrayList<>();
        objects.add(jack);
        objects.add(john);
        objects.add(robert);

        robert.addBonus(12000);

        objects.get(0).addIncreament(10);
        objects.get(1).addIncreament(10);
        objects.get(2).addIncreament(10);


        System.out.println(objects);

        for (Employee object : objects) {
            System.out.println("Name : " + object.getName() + ", Salary : " + object.getSalary());
        }

    }
}