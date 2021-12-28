public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");
        String str = sb.toString().intern();
        
        System.out.println(str); // Output: Hello
    }
}
