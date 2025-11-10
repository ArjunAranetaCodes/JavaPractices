/**
 * Tutorial: Annotation Retention
 * Demonstrates retention policies
 */
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// SOURCE - discarded by compiler
@Retention(RetentionPolicy.SOURCE)
@interface SourceAnnotation {
    String value();
}

// CLASS - retained in class file but not at runtime
@Retention(RetentionPolicy.CLASS)
@interface ClassAnnotation {
    String value();
}

// RUNTIME - available at runtime via reflection
@Retention(RetentionPolicy.RUNTIME)
@interface RuntimeAnnotation {
    String value();
}

@SourceAnnotation("Source")
@ClassAnnotation("Class")
@RuntimeAnnotation("Runtime")
class RetentionExample {
}

public class AnnotationRetention {
    public static void main(String[] args) {
        Class<?> clazz = RetentionExample.class;
        
        // Only RUNTIME annotations are accessible
        java.lang.annotation.Annotation[] annotations = clazz.getAnnotations();
        System.out.println("Runtime annotations: " + annotations.length);
        
        for (java.lang.annotation.Annotation annotation : annotations) {
            System.out.println("  " + annotation.annotationType().getSimpleName());
        }
    }
}

