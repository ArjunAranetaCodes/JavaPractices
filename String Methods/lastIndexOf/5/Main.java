public class Main {
    public static void main(String[] args) {
        String line = "The quick brown fox jumps over the lazy brown dog.";
        int lastIndex = line.lastIndexOf('b', 30);
        System.out.println("Last index of 'b' before index 30: " + lastIndex);
    }
}
