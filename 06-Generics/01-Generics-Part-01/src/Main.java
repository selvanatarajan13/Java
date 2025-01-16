interface Player{}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        BaseBallTeam thunderGuys = new BaseBallTeam("Thunder Guys");
        BaseBallTeam rockers = new BaseBallTeam("Rockers");

        scoreResult(thunderGuys, 3, rockers, 5);

        BaseBallPlayer roa = new BaseBallPlayer("Roa", "center");
        thunderGuys.addTeamMember(roa);

        thunderGuys.listTeamMember();

        System.out.println("-".repeat(60));

        SportTeam astros = new SportTeam("Houston astros");
        SportTeam phillies = new SportTeam("Philadelphia Phillies");

        scoreResult(astros, 5, phillies, 4);
        FootBallPlayer nazir = new FootBallPlayer("Nazeer ahamad", "center right");

        astros.addTeamMember(nazir);
        astros.addTeamMember(roa);
        astros.listTeamMember();

        System.out.println("-".repeat(60));

        Team<FootBallPlayer> getterGang = new Team<>("Getter Gang Soui");
        Team<FootBallPlayer> astros2 = new Team<>("Houston Astros");

        scoreResult(getterGang, 10, astros2, 12);
        getterGang.addTeamMember(nazir);
        getterGang.listTeamMember();
    }

    private static void scoreResult(BaseBallTeam team1, int team1Score, BaseBallTeam team2, int team2Score) {
        String message = team1.setScore(team1Score, team2Score);
        team2.setScore(team2Score, team1Score);

        System.out.printf("%s %s %s %n", team1, message, team2);
    }

    private static void scoreResult(SportTeam team1, int team1Score, SportTeam team2, int team2Score) {
        String message = team1.setScore(team1Score, team2Score);
        team2.setScore(team2Score, team1Score);

        System.out.printf("%s %s %s %n", team1, message, team2);
    }

    private static void scoreResult(Team team1, int team1Score, Team team2, int team2Score) {
        String message = team1.setScore(team1Score, team2Score);
        team2.setScore(team2Score, team1Score);

        System.out.printf("%s %s %s %n", team1, message, team2);
    }
}