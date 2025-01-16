import Dev.Model.CGPStudent;
import Dev.Model.Student;
import Dev.util.QueryList;
import Dev.util.StudentCGPAComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        List<Student> students = new ArrayList<>();
        for (int i=0; i<10; i++) {
            students.add(new Student());
        }

        printList(students);
        System.out.println("-".repeat(60));


        List<CGPStudent> cgpStudents = new ArrayList<>();
        for (int i=0; i<14; i++) {
            cgpStudents.add(new CGPStudent());
        }
        printList(cgpStudents);
        System.out.println("-".repeat(70));

        var queryList = new QueryList<>(cgpStudents);
        var getMatches = queryList.getMatches("Course", "Java");
        Comparator<CGPStudent> cgpStudentComparator = new StudentCGPAComparator();
        Collections.sort(getMatches, cgpStudentComparator.reversed());
        printList(getMatches);



        // System.out.println("-".repeat(70));

        // var getCourseMatches = QueryList.getMatches(cgpStudents, "Course", "PHP");
        // printList(getCourseMatches);
    }

    private static <T> void printList(List<T> data) {
        printLabel();
        for (T item: data) {
            System.out.println(item);
        }
        System.out.println();
    }

    private static void printLabel() {
        System.out.println("-".repeat(70));
        System.out.printf("%-15s %-15s %-15s %-15s %s%n", "ID", "Full Name", "Course", "StartYear", "CGPA");
        System.out.println("-".repeat(70));
    }
}