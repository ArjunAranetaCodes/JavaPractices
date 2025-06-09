import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(CustomDisplayNameGenerator.class)
public class ExampleTest {

    @Test
    void testMethodWithCamelCase() {
        // Test implementation
    }

    @Test
    void test_method_with_underscores() {
        // Test implementation
    }

    static class CustomDisplayNameGenerator extends DisplayNameGenerator.Standard {
        @Override
        public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
            String name = testMethod.getName();
            return name.replaceAll("([A-Z])", " $1")
                       .replaceAll("_", " ")
                       .toLowerCase()
                       .trim();
        }
    }
}