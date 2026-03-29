package domain.train;

public class AcCoach extends Coach {

    public AcCoach(String coachNumber) {
        super(coachNumber, 48);
    }

    @Override
    public String getCoachType() {
        return "AC";
    }
}
