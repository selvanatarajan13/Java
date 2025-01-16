public class Person {

    private int id;
    private String name;
    private String email;
    private String Department;

    public Person() {}

    public Person(int id, String name, String email, String department) {
        this.id = id;
        this.name = name;
        this.email = email;
        Department = department;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", Department='" + Department + '\'' +
                '}';
    }
}
