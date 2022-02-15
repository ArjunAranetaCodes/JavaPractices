public class Main {
    public static void main(String[] args) {
        StringBuilder builder1 = new StringBuilder("Java");
        StringBuilder builder2 = new StringBuilder("Java");
        boolean result = builder1.toString().contentEquals(builder2);
        System.out.println("Are the StringBuilders equal? " + result);
    }
}
