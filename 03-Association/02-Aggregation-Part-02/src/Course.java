import java.util.ArrayList;
import java.util.List;

public class Course {

    private String courseName;
    private List<Student> students;

    public Course(String courseName, List<Student> students) {
        this.courseName = courseName;
        this.students = students;
    }

    public List<String> studentsDataName() {
        List<Student> studentList = this.students;
        List<String> names = new ArrayList<>();

        for (Student student : studentList) {
            names.add(student.getName());
        }

        return names;
    }

    public List<Student> studentsData() {
        return students;
    }
}
