## Problem: 
Implementing a Leaderboard

## Description: 
Create a program that demonstrates the use of TreeMap to implement a leaderboard.

## Input:

Player scores: {"John Doe", 100}, {"Alice Smith", 90}, {"Bob Johnson", 80}

## Output:

Leaderboard:

John Doe = 100

Alice Smith = 90

Bob Johnson = 80

## Code Answer:
```Java
import java.util.TreeMap;

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

class ScoreComparator implements Comparator<Interger>{
    @Overide
    public int compare(Integer n1, Integer n2){
        return n2-n1;
    }
}
```

File Name: Leaderboard.java

This program demonstrates the use of TreeMap to implement a leaderboard. The Leaderboard class uses a TreeMap to store player scores, and a custom comparator to sort the scores in descending order. The addScore method adds a new player score to the leaderboard. The program prints the leaderboard entries in sorted order by score, with the highest score first.

Note: TreeMap is a collection that stores key-value pairs in a sorted order, and it provides methods for navigating and searching the elements in the map. It is useful for implementing sorted dictionaries, phonebooks, and other similar data structures.