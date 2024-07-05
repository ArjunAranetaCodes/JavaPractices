import java.util.*;

public class Leaderboard {
    private SortedSet<Map.Entry<String, Integer>> entries;

    public Leaderboard() {
        this.entries = new TreeSet<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return e2.getValue().compareTo(e1.getValue());
            }
        });
    }

    public void addScore(String player, int score) {
        entries.add(new AbstractMap.SimpleEntry<>(player, score));
    }

    public void printLeaderboard() {
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Leaderboard leaderboard = new Leaderboard();

        leaderboard.addScore("Player1", 100);
        leaderboard.addScore("Player2", 50);
        leaderboard.addScore("Player3", 150);
        leaderboard.addScore("Player4", 75);

        leaderboard.printLeaderboard();
    }
}