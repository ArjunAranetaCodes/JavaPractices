public class Main {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("Java is ");
        stringBuilder.append("awesome!");
        int builderLength = stringBuilder.length();
        System.out.println("StringBuilder length: " + builderLength);
    }
}
