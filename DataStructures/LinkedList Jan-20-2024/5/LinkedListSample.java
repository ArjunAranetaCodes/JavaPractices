import java.util.LinkedList;

public class LinkedListSample {
    public static void main(String[] args) {
        LinkedList<Character> characters = new LinkedList<>();
        characters.add('A');
        characters.add('B');
        characters.add('C');

        System.out.println("Size of LinkedList: " + characters.size());
    }
}
