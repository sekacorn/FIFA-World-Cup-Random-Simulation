import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorldCupSimulation {

    private static JTextArea outputArea;
    private static Map<String, String> flagMap;
    private static Map<String, Integer> teamStats;
    private static List<String> matchHistory;

    public static void main(String[] args) {
        List<String> teams = List.of("Russia", "Saudi Arabia", "Egypt", "Uruguay", "Spain", "Portugal", "Iran", "Morocco",
                "France", "Denmark", "Peru", "Australia", "Croatia", "Argentina", "Nigeria", "Iceland", "Brazil",
                "Switzerland", "Serbia", "Costa Rica", "Sweden", "Mexico", "Korea Republic", "Germany", "Belgium",
                "England", "Tunisia", "Panama", "Colombia", "Japan", "Senegal", "Poland");
        
        initializeFlagMap();
        teamStats = new HashMap<>();
        matchHistory = new ArrayList<>();
        for (String team : teams) {
            teamStats.put(team, 0);
        }

        createAndShowGUI(teams);
    }

    private static void createAndShowGUI(List<String> teams) {
        JFrame frame = new JFrame("FIFA World Cup Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        Color bgColor = new Color(240, 248, 255);
        Color headerColor = new Color(0, 102, 204);
        Color textColor = new Color(34, 34, 34);

        JLabel header = new JLabel("FIFA World Cup Simulator", JLabel.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 20));
        header.setForeground(headerColor);
        frame.add(header, BorderLayout.NORTH);

        outputArea = new JTextArea(20, 60);
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Courier New", Font.PLAIN, 12));
        outputArea.setForeground(textColor);
        outputArea.setBackground(bgColor);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(bgColor);
        JButton startButton = new JButton("Start Simulation");
        startButton.setBackground(new Color(0, 153, 76));
        startButton.setForeground(Color.WHITE);
        JButton statsButton = new JButton("Show Team Stats");
        statsButton.setBackground(new Color(255, 153, 0));
        statsButton.setForeground(Color.WHITE);
        buttonPanel.add(startButton);
        buttonPanel.add(statsButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        startButton.addActionListener(e -> simulateTournament(teams));
        statsButton.addActionListener(e -> showTeamStats());

        frame.setVisible(true);
    }

    private static void initializeFlagMap() {
        flagMap = new HashMap<>();
        flagMap.put("Russia", "\uD83C\uDDF7\uD83C\uDDFA");
        flagMap.put("Saudi Arabia", "\uD83C\uDDF8\uD83C\uDDE6");
        flagMap.put("Egypt", "\uD83C\uDDEA\uD83C\uDDEC");
        flagMap.put("Uruguay", "\uD83C\uDDFA\uD83C\uDDFE");
        flagMap.put("Spain", "\uD83C\uDDEA\uD83C\uDDF8");
        flagMap.put("Portugal", "\uD83C\uDDF5\uD83C\uDDF9");
        flagMap.put("Iran", "\uD83C\uDDEE\uD83C\uDDF7");
        flagMap.put("Morocco", "\uD83C\uDDF2\uD83C\uDDE6");
        flagMap.put("France", "\uD83C\uDDEB\uD83C\uDDF7");
        flagMap.put("Denmark", "\uD83C\uDDE9\uD83C\uDDF0");
        flagMap.put("Peru", "\uD83C\uDDF5\uD83C\uDDEA");
        flagMap.put("Australia", "\uD83C\uDDE6\uD83C\uDDFA");
        flagMap.put("Croatia", "\uD83C\uDDED\uD83C\uDDF7");
        flagMap.put("Argentina", "\uD83C\uDDE6\uD83C\uDDF7");
        flagMap.put("Nigeria", "\uD83C\uDDF3\uD83C\uDDEC");
        flagMap.put("Iceland", "\uD83C\uDDEE\uD83C\uDDF8");
        flagMap.put("Brazil", "\uD83C\uDDE7\uD83C\uDDF7");
        flagMap.put("Switzerland", "\uD83C\uDDE8\uD83C\uDDED");
        flagMap.put("Serbia", "\uD83C\uDDF7\uD83C\uDDF8");
        flagMap.put("Costa Rica", "\uD83C\uDDE8\uD83C\uDDF7");
        flagMap.put("Sweden", "\uD83C\uDDF8\uD83C\uDDEA");
        flagMap.put("Mexico", "\uD83C\uDDF2\uD83C\uDDFD");
        flagMap.put("Korea Republic", "\uD83C\uDDF0\uD83C\uDDF7");
        flagMap.put("Germany", "\uD83C\uDDE9\uD83C\uDDEA");
        flagMap.put("Belgium", "\uD83C\uDDE7\uD83C\uDDEA");
        flagMap.put("England", "\uD83C\uDFF4\uDB40\uDC67\uDB40\uDC62\uDB40\uDC65\uDB40\uDC6E\uDB40\uDC67\uDB40\uDC7F");
        flagMap.put("Tunisia", "\uD83C\uDDF9\uD83C\uDDF3");
        flagMap.put("Panama", "\uD83C\uDDF5\uD83C\uDDE6");
        flagMap.put("Colombia", "\uD83C\uDDE8\uD83C\uDDF4");
        flagMap.put("Japan", "\uD83C\uDDEF\uD83C\uDDF5");
        flagMap.put("Senegal", "\uD83C\uDDF8\uD83C\uDDF3");
        flagMap.put("Poland", "\uD83C\uDDF5\uD83C\uDDF1");
    }

    private static void simulateTournament(List<String> teams) {
        outputArea.setText("");
        appendWithStyle("Starting World Cup Simulation...\n", Color.BLUE);

        List<List<String>> groups = createGroups(teams);
        appendWithStyle("=== Group Stage ===\n", Color.MAGENTA);
        List<String> round16 = playRound(groups, "Round of 16");

        appendWithStyle("=== Round of 16 Winners ===\n", Color.GREEN);
        appendTeams(round16);

        List<String> quarterFinals = playRound(createGroups(round16), "Quarter Finals");
        appendWithStyle("=== Quarter Finals ===\n", Color.ORANGE);
        appendTeams(quarterFinals);

        List<String> semiFinals = playRound(createGroups(quarterFinals), "Semi Finals");
        appendWithStyle("=== Semi Finals ===\n", Color.CYAN);
        appendTeams(semiFinals);

        List<String> finals = playRound(createGroups(semiFinals), "Finals");
        appendWithStyle("=== Finals ===\n", Color.RED);
        String winner = playFinals(finals);
        appendTeams(finals);
        appendWithStyle("The winner of the FIFA World Cup is " + flagMap.get(winner) + " " + winner + "!\n", Color.BLUE);
    }

    private static void appendWithStyle(String text, Color color) {
        outputArea.setForeground(color);
        outputArea.append(text);
        outputArea.setForeground(Color.BLACK);
    }

    private static void appendTeams(List<String> teams) {
        for (String team : teams) {
            outputArea.append(flagMap.get(team) + " " + team + "\n");
        }
        outputArea.append("\n");
    }

    private static List<List<String>> createGroups(List<String> teams) {
        List<List<String>> groups = new ArrayList<>();
        List<String> shuffledTeams = new ArrayList<>(teams);
        Collections.shuffle(shuffledTeams);

        for (int i = 0; i < 8; i++) {
            List<String> group = new ArrayList<>();
            for (int j = i * 4; j < Math.min((i * 4) + 4, shuffledTeams.size()); j++) {
                group.add(shuffledTeams.get(j));
            }
            groups.add(group);
        }
        return groups;
    }

    private static List<String> playRound(List<List<String>> groups, String roundName) {
        List<String> roundWinners = new ArrayList<>();
        appendWithStyle(roundName + " Matches:\n", Color.DARK_GRAY);

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

    private static String playMatch(String team1, String team2) {
        int goalsTeam1 = (int) (Math.random() * 5);
        int goalsTeam2 = (int) (Math.random() * 5);

        String result;
        String winner;
        if (goalsTeam1 > goalsTeam2) {
            result = flagMap.get(team1) + " " + team1 + " " + goalsTeam1 + " - " + goalsTeam2 + " " + team2 + " " + flagMap.get(team2) + ": " + team1 + " wins";
            winner = team1;
        } else if (goalsTeam1 < goalsTeam2) {
            result = flagMap.get(team1) + " " + team1 + " " + goalsTeam1 + " - " + goalsTeam2 + " " + team2 + " " + flagMap.get(team2) + ": " + team2 + " wins";
            winner = team2;
        } else {
            result = flagMap.get(team1) + " " + team1 + " " + goalsTeam1 + " - " + goalsTeam2 + " " + team2 + " " + flagMap.get(team2) + ": Tie, going to penalties...";
            winner = Math.random() > 0.5 ? team1 : team2;
            result += " " + winner + " wins on penalties!";
        }
        
        outputArea.append(result + "\n");
        matchHistory.add(result);
        teamStats.put(winner, teamStats.get(winner) + 1);
        return winner;
    }

    private static String playFinals(List<String> finals) {
        if (finals.size() != 2) {
            throw new IllegalArgumentException("Number of teams in the finals should be 2.");
        }
        return playMatch(finals.get(0), finals.get(1));
    }

    private static void showTeamStats() {
        StringBuilder stats = new StringBuilder("=== Team Statistics ===\n");
        for (Map.Entry<String, Integer> entry : teamStats.entrySet()) {
            stats.append(flagMap.get(entry.getKey())).append(" ").append(entry.getKey())
                 .append(": ").append(entry.getValue()).append(" wins\n");
        }
        stats.append("\n=== Match History ===\n");
        for (String match : matchHistory) {
            stats.append(match).append("\n");
        }
        JOptionPane.showMessageDialog(null, new JTextArea(stats.toString()), "Tournament Stats", JOptionPane.INFORMATION_MESSAGE);
    }
}
