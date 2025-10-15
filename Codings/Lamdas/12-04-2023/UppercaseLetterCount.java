import java.util.function.Predicate;

public class UppercaseLetterCount {
    public static void main(String[] args) {
        Predicate<Character> isUpperCase = Character::isUpperCase;

        String text = "Java Programming Is Fun";
        long count = text.chars().filter(c -> isUpperCase.test((char)c)).count();

        System.out.println("Uppercase letter count: " + count);
    }
}