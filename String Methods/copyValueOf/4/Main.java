public class Main {
    public static void main(String[] args) {
        CharSequence charSeq1 = "Java";
        CharSequence charSeq2 = new StringBuilder("Java");
        boolean result = charSeq1.toString().contentEquals(charSeq2);
        System.out.println("Are the CharSequences equal? " + result);
    }
}
