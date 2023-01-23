public class Main {
    public static void main(String[] args) {
        char[] letters = {'a', 'b', 'c', 'd'};
        int index = 2;

        switch (letters[index]) {
            case 'a':
                System.out.println("Letter is 'a'");
                break;
            case 'b':
                System.out.println("Letter is 'b'");
                break;
            // Add cases for other letters as needed
            default:
        }
    }
}
