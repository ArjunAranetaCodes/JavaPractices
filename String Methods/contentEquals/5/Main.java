public class Main {
    public static void main(String[] args) {
        String str = "Hello, World!";
        CharSequence subSeq = str.subSequence(0, 5);
        boolean result = "Hello".contentEquals(subSeq);
        System.out.println("Is the substring equal to 'Hello'? " + result);
    }
}
