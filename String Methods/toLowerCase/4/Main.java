public class Main {
    public static void main(String[] args) {
        String[] words = {"Java", "Programming", "Language"};

        System.out.println("Original Array:");

        for (String word : words) {
            System.out.println(word);
        }

        System.out.println("\nArray in Lowercase:");

        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].toLowerCase();
            System.out.println(words[i]);
        }
    }
}
