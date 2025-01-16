import java.util.List;

public class College {

    private String collegeName;
    private List<Course> courses;

    public College(String collegeName, List<Course> courses) {
        this.collegeName = collegeName;
        this.courses = courses;
    }

    // Returning number of students in a given college
    public int countStudents() {
        int studentsInCollege = 0;
        List<Student> students = List.of();
        for (Course course : courses) {
            students = course.studentsData();
            for (Student s : students) {
                studentsInCollege += 1;
            }
        }

        return studentsInCollege;
    }
}
