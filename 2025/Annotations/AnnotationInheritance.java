/**
 * Tutorial: Annotation Inheritance
 * Demonstrates inherited annotations
 */
import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@interface InheritedAnnotation {
    String value();
}

@InheritedAnnotation("Parent")
class Parent {
}

class Child extends Parent {
}

public class AnnotationInheritance {
    public static void main(String[] args) {
        // Child inherits annotation from Parent
        if (Child.class.isAnnotationPresent(InheritedAnnotation.class)) {
            InheritedAnnotation annotation = Child.class.getAnnotation(InheritedAnnotation.class);
            System.out.println("Child has inherited annotation: " + annotation.value());
        }
        
        // Parent has its own annotation
        if (Parent.class.isAnnotationPresent(InheritedAnnotation.class)) {
            InheritedAnnotation annotation = Parent.class.getAnnotation(InheritedAnnotation.class);
            System.out.println("Parent has annotation: " + annotation.value());
        }
    }
}











