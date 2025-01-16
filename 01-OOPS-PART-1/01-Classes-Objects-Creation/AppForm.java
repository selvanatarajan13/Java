/* This function express the basics of how to create a classes and objects */
public class AppForm {

    // Define variables
    long rollno;
    String name;
    float cut_off;

    // Define main function and create object
    public static void main(String[] args) {
        AppForm data = new AppForm();
        data.setValues(953420106031L, "Selvanatarajan", 128.8f);
        // data.rollno = 953420106031L;
        // data.name = "Selvanatarajan";
        // data.cut_off = 128.8f;
        data.display();
    }

    public void display() {
        System.out.println(rollno + "\n" + name + "\n" + cut_off);
    }

    public void setValues(long value1, String value2, float value3) {
        rollno = value1;
        name = value2;
        cut_off = value3;
    }
}
