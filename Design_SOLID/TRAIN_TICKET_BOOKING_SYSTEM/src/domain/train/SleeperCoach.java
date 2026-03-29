package domain.train;

public class SleeperCoach extends Coach {

    public SleeperCoach(String coachNumber) {
        super(coachNumber, 72);
    }

    @Override
    public String getCoachType() {
        return "SLEEPER";
    }
}
