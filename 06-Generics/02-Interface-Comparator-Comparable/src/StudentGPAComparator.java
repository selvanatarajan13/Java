import java.util.Comparator;

public class StudentGPAComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return Double.valueOf(o1.gpa).compareTo(Double.valueOf(o2.gpa));
    }
}
