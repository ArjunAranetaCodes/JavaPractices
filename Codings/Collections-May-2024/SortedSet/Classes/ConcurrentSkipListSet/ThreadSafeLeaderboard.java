import java.util.concurrent.ConcurrentSkipListSet;

public class ThreadSafeLeaderboard {
    public static void main(String[] args) {
        ConcurrentSkipListSet<Player> leaderboard = new ConcurrentSkipListSet<>();

        // Multiple threads adding players and scores concurrently
        Thread t1 = new Thread(() -> {
            leaderboard.add(new Player("Player1", 100));
            leaderboard.add(new Player("Player2", 50));
        });
        Thread t2 = new Thread(() -> {
            leaderboard.add(new Player("Player3", 150));
            leaderboard.add(new Player("Player4", 75));
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Leaderboard:");
        for (Player player : leaderboard) {
            System.out.println(player);
        }
    }
}

class Player implements Comparable<Player> {
    String name;
    int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Player other) {
        return Integer.compare(other.score, this.score);
    }

    @Override
    public String toString() {
        return name + " (" + score + ")";
    }
}