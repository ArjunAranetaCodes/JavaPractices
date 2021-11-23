public class Main {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("This is a sample sentence.");
        stringBuilder.replace(11, 17, "example");
        System.out.println(stringBuilder.toString());
    }
}
   