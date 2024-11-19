## Problem: 
Implementing a Leaderboard

## Description: 
Create a program that demonstrates the use of SortedSet to implement a leaderboard.

## Input:

Player scores: ["Player1", 100], ["Player2", 50], ["Player3", 150], ["Player4", 75]

## Output:

Leaderboard:

Player3: 150

Player1: 100

Player4: 75

Player2: 50

## Code Answer:
```Java
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
```

File Name: Leaderboard.java

This program demonstrates the use of SortedSet to implement a leaderboard. The Leaderboard class uses a SortedSet to store entries (player and score pairs) in descending order by score. The addScore method adds a new entry to the leaderboard, and the printLeaderboard method prints all entries in the leaderboard.
Note: SortedSet is a collection that stores elements in a sorted order, and it uses a tree for storage. It is useful for storing a collection of elements in a sorted order, making it suitable for implementing a leaderboard.