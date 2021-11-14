public class Main {
    public static void main(String[] args) {
        String originalString = "Java is amazing!";
        String replacedString = originalString.replaceAll("(?i)java", "Python");
        System.out.println(replacedString);
    }
}
