package domain.train;

import java.util.List;

public class Train {
    private final String trainNumber;
    private final String name;
    private final String source;
    private final String destination;
    private final List<Coach> coaches;

    public Train(String trainNumber, String name, String source, String destination, List<Coach> coaches) {
        this.trainNumber = trainNumber;
        this.name = name;
        this.source = source;
        this.destination = destination;
        this.coaches = coaches;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public String getTrainNumber() {
        return trainNumber;
    }
}
