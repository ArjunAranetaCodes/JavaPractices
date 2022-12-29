public class Main {
    public static void main(String[] args) {
        String str = "Java programming is interesting";
        String substring = "ing";
        int fromIndex = 7;
        int index = str.indexOf(substring, fromIndex);
        System.out.println("Index of '" + substring + "' after position " + fromIndex + ": " + index);
    }
}
  