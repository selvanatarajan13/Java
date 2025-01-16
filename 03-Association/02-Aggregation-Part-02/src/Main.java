import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Student selva = new Student(953420106031L, "SELVANATARAJAN S","ECE");
        Student sundar = new Student(953420107014L, "SHANMUGA SUNDAR","EEE");
        Student abi = new Student(95420106001L, "KE ABIRAM", "ECE");
        Student suther = new Student(953420107012L, "SUTHER", "EEE");
        Student arun = new Student(953420106004L, "ARUN SIVA", "ECE");

        List<Student> eceStudents = new ArrayList<>();
        eceStudents.add(selva);
        eceStudents.add(abi);
        eceStudents.add(arun);

        List<Student> eeeStudents = new ArrayList<>();
        eeeStudents.add(sundar);
        eeeStudents.add(suther);

        Course ece = new Course("ECE", eceStudents);
        Course eee = new Course("EEE", eeeStudents);

        List<Course> courses = new ArrayList<>();
        courses.add(ece);
        courses.add(eee);

        College vv = new College("VV College Of Engineering", courses);

        System.out.println(vv.countStudents());
    }
}