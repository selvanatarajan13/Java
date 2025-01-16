package Dev.Model;

public class CGPStudent extends Student {

    private double cgpa;

    public CGPStudent() {
        this.cgpa = random.nextDouble(50.0, 100.0);
    }

    public double getCgpa() {
        return cgpa;
    }

    @Override
    public String toString() {
        return "%s %15.1f".formatted(super.toString(), cgpa);
    }
}
