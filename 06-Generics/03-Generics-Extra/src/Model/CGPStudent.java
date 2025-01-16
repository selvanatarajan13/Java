package Model;

public class CGPStudent extends Student {

    private double cgpa;

    public CGPStudent() {
        this.cgpa = random.nextDouble(10.0, 100.0);
    }

    @Override
    public String toString() {
        return "%s %8.1f%%".formatted(super.toString(), cgpa);
    }
}
