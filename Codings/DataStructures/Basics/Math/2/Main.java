public class Main {
    public static void main(String[] args) {
        int age = 18;
        boolean isStudent = true;

        if (age >= 18) {
            if (isStudent) {
                System.out.println("You are an adult student.");
            } else {
                System.out.println("You are an adult.");
            }
        } else {
            System.out.println("You are a minor.");
        }
    }
}
