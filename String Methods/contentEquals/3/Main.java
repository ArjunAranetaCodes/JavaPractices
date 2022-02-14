public class Main {
    public static void main(String[] args) {
        StringBuffer buffer1 = new StringBuffer("Programming");
        StringBuffer buffer2 = new StringBuffer("Programming");
        boolean result = buffer1.toString().contentEquals(buffer2);
        System.out.println("Are the StringBuffers equal? " + result);
    }
}
   