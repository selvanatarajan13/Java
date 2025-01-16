import java.util.ArrayList;
import java.util.List;

public class SportTeam {

    private String teamName;
    private List<Player> teamMembers = new ArrayList<>();
    private int totWins = 0;
    private int totLoss = 0;
    private int totTies = 0;

    public SportTeam(String teamName) {
        this.teamName = teamName;
    }

    public void addTeamMember(Player player) {
        if (!teamMembers.contains(player)) {
            teamMembers.add(player);
        }
    }

    public void listTeamMember() {
        System.out.println("Team Name: " + teamName);
        System.out.println(teamMembers);
    }

    public int ranking() {
        return (totLoss * 2) + totTies + 1;
    }

    public String setScore(int ourScore, int theirScore) {
        String message = " lose to ";
        if (ourScore > theirScore) {
            totWins++;
            message = " beat ";
        } else if (ourScore == theirScore) {
            totTies++;
            message = " tied ";
        } else {
            totLoss++;
        }

        return message;
    }

    @Override
    public String toString() {
        return teamName + "( " + ranking() + " ) ";
    }
}
