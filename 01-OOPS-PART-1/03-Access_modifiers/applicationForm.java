/* In this program, i had been learned how to use Access modifiers. Access modifiers helps to restrict the scope of the class, constructor, variable and method. It provide the security, accessibility and etc, to the user depanding upon the access modifier used with the element. There are 4 Access modifier in Java such that are default, public, private and protected... */

public class applicationForm {
    long rollno;
    String name;
    float cut_off;

    public void display() {
        System.out.println(rollno + "\n" + name + "\n" + cut_off);
    }

    public void setValues(long value1, String value2, float value3) {
        rollno = value1;
        name = value2;
        cut_off = value3;
    }

}

class Maighjn {

    public static void main(String[] args) {
        applicationForm object = new applicationForm();
        object.setValues(953420106031L, "Selvanatarajan", 128.8f);
        object.display();
    }
}

/*
 * In this program, I was understood Access modifiers, that is if you want to
 * access another class private variable or attribute, here you will use setter
 * and getter function technique.
 */