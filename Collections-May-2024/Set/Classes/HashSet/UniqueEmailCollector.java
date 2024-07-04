import java.util.*;

public class UniqueEmailCollector {
    public static void main(String[] args) {
        List<String> emailAddresses = Arrays.asList(
                "email1@example.com",
                "email2@example.com",
                "email1@example.com",
                "email3@example.com"
        );

        Set<String> uniqueEmailAddresses = new HashSet<>(emailAddresses);

        System.out.println("Unique email addresses: " + uniqueEmailAddresses);
    }
}