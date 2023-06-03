import java.util.ArrayList;
import java.util.List;

public class WorldCupSimulation {

    public static void main(String[] args) {
        List<String> teams = List.of("Russia", "Saudi Arabia", "Egypt", "Uruguay", "Spain", "Portugal", "Iran", "Morocco",
                "France", "Denmark", "Peru", "Australia", "Croatia", "Argentina", "Nigeria", "Iceland", "Brazil",
                "Switzerland", "Serbia", "Costa Rica", "Sweden", "Mexico", "Korea Republic", "Germany", "Belgium",
                "England", "Tunisia", "Panama", "Colombia", "Japan", "Senegal", "Poland");

        List<List<String>> groups = createGroups(teams);

        List<String> round16 = playRound(groups);

        System.out.println("===============================================");
        System.out.println("Round of 16 Winners");
        System.out.println(round16);
        System.out.println("===============================================");

        List<String> quarterFinals = playRound(createGroups(round16));

        System.out.println("***********************************************");
        System.out.println("Quarter Finals");
        System.out.println(quarterFinals);
        System.out.println("***********************************************");

        List<String> semiFinals = playRound(createGroups(quarterFinals));

        System.out.println("-----------------------------------------------");
        System.out.println("Semi Finals");
        System.out.println(semiFinals);
        System.out.println("-----------------------------------------------");

        List<String> finals = playRound(createGroups(semiFinals));

        System.out.println("################################################");
        System.out.println("Finals");
        System.out.println("################################################");

        String winner = playFinals(finals);

        System.out.println(finals);
        System.out.println("The winner for the current FIFA World Cup is " + winner);
    }

    public static List<List<String>> createGroups(List<String> teams) {
        List<List<String>> groups = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            List<String> group = new ArrayList<>();
            for (int j = i * 4; j < (i * 4) + 4; j++) {
                group.add(teams.get(j));
            }
            groups.add(group);
        }

        return groups;
    }

    public static List<String> playRound(List<List<String>> groups) {
        List<String> roundWinners = new ArrayList<>();

        for (List<String> group : groups) {
            for (int i = 0; i < group.size() - 1; i += 2) {
                String team1 = group.get(i);
                String team2 = group.get(i + 1);
                String winner = playMatch(team1, team2);
                roundWinners.add(winner);
            }
        }

        return roundWinners;
    }

    public static String playMatch(String team1, String team2) {
        int goalsTeam1 = (int) (Math.random() * 8);
        int goalsTeam2 = (int) (Math.random() * 8);

        if (goalsTeam1 > goalsTeam2) {
            System.out.println(team1 + " " + goalsTeam1 + " - " + goalsTeam2 + " " + team2 + ": " + team1 + " is the winner");
            return team1;
        } else if (goalsTeam1 < goalsTeam2) {
            System.out.println(team1 + " " + goalsTeam1 + " - " + goalsTeam2 + " " + team2 + ": " + team2 + " is the winner");
            return team2;
        } else {
            System.out.println(team1 + " " + goalsTeam1 + " - " + goalsTeam2 + " " + team2 + ": It's a tie. Playing again...");
            return playMatch(team1, team2);
        }
    }

    public static String playFinals(List<String> finals) {
        if (finals.size() != 2) {
            throw new IllegalArgumentException("Number of teams in the finals should be 2.");
        }

        String team1 = finals.get(0);
        String team2 = finals.get(1);

        return playMatch(team1, team2);
    }
}
