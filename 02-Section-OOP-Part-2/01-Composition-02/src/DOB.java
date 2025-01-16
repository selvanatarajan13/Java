public class DOB {

    private int day;
    private String month;
    private int year;

    public DOB(int day, String month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void printDOB() {
        System.out.println("Date of Birth : " + day + "-" + month + "-" + year);
    }
}
