public class Main {
    public static void main(String[] args) {
        String str = "Programming is Fun";
        char[] charArray = str.toCharArray();

        int vowelCount = 0;
        for (char c : charArray) {
            if ("aeiouAEIOU".indexOf(c) != -1) {
                vowelCount++;
            }
        }

        System.out.println("Number of vowels in \"" + str + "\": " + vowelCount);
    }
}
