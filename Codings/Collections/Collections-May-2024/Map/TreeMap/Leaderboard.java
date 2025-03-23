import java.util.TreeMap;
import java.util.Comparator;
import java.util.Map;

public class Leaderboard {
    private TreeMap<Integer, String> scores;

    public Leaderboard() {
        this.scores = new TreeMap<>(new ScoreComparator());
    }

    public void addScore(String player, int score) {
        scores.put(score, player);
    }

    public static void main(String[] args) {
        Leaderboard leaderboard = new Leaderboard();

        leaderboard.addScore("John Doe", 100);
        leaderboard.addScore("Alice Smith", 90);
        leaderboard.addScore("Bob Johnson", 80);

        System.out.println("Leaderboard:");
        int rank = 1;
        for (Map.Entry<Integer, String> entry : leaderboard.scores.entrySet()) {
            System.out.println(rank + ". " + entry.getValue() + " = " + entry.getKey());
            rank++;
        }
    }
}

class ScoreComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer score1, Integer score2) {
        return score2 - score1;
    }
}