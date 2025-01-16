import Model.CGPStudent;
import Model.Student;
import Model.Teacher;
import util.QueryItem;
import util.QueryList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!\n");

        List<Student> students = new ArrayList<>();

        for (int i=0; i<10; i++) {
            students.add(new Student());
        }
        students.add(new CGPStudent());
        printStudentList(students);


        System.out.println("-".repeat(60));

        List<CGPStudent> cgpStudents = new ArrayList<>();
        for (int i=0; i<10; i++) {
            cgpStudents.add(new CGPStudent());
        }

        printStudentList(cgpStudents);

        System.out.println("-".repeat(60));

        testList(new ArrayList<String>(List.of("Mahendran", "OPPO", "MAC")));
        testList(new ArrayList<Integer>(List.of(95,45, 15)));

        System.out.println("-".repeat(60));

        var queryItem = new QueryList<>(cgpStudents);
        var matches = queryItem.getMatches("Course", "Java");
        printStudentList(matches);

        System.out.println("-".repeat(60));

        var get2020Matches = QueryList.getMatches(students, "YearStarted", "2020");
        printStudentList(get2020Matches);
    }

    public static void printStudentList(List<? extends Student> students) {

        for (var student: students) {
            System.out.println(student);
        }
        System.out.println();
    }

    public static void testList(List<?> list) {
        for (Object value: list) {
            if (value instanceof String s) {
                System.out.println("String: " + s.toUpperCase());
            } else if (value instanceof Integer a) {
                System.out.println("Integer: " + a.floatValue());
            }
        }
    }
}