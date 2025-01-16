import javax.sound.midi.SysexMessage;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Map<Integer, Person> data = new HashMap<>();

        System.out.println("Hello world!");

        List<String> listCourses = Arrays.asList("Embedded System", "Professional Ethics","Communication Network");
        List<String> listCourses2 = Arrays.asList("LIC", "Admission Management");


        Employee ram = new Faculty(
                1, "Ram", "ram@gmail.com", "ECE", "Assitent Professor",
                854250, listCourses
        );

        Employee vel = new Faculty(
                2, "Vel", "vel@gmail.com", "ECE", "Assitant Professor",
                102454, listCourses2
        );

        Student mahend = new Student(
                3, "Mahendran", "mahendran@gmail.com", "ECE", "r20ec030",
                2020, "20/09/2020", 7.84
        );



        data.put(1012, ram);
        data.put(1013, vel);
        data.put(1014, mahend);

        System.out.println(data.get(1014));

    }
}