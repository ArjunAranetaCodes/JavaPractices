/**
 * Tutorial: Custom Annotations
 * Demonstrates creating and using custom annotations
 */
import java.lang.annotation.*;

// Marker annotation (no elements)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TestMethod {
}

// Single element annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
    String value();
}

// Multi-element annotation
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@interface Info {
    String author();
    String date();
    int version() default 1;
}

// Using annotations
@Author("John Doe")
@Info(author = "John Doe", date = "2025-01-01", version = 2)
class MyClass {
    @TestMethod
    public void testMethod1() {
        System.out.println("Test method 1");
    }
    
    @TestMethod
    public void testMethod2() {
        System.out.println("Test method 2");
    }
    
    public void regularMethod() {
        System.out.println("Regular method");
    }
}

public class CustomAnnotations {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        
        // Check annotations at runtime
        if (MyClass.class.isAnnotationPresent(Author.class)) {
            Author author = MyClass.class.getAnnotation(Author.class);
            System.out.println("Author: " + author.value());
        }
        
        if (MyClass.class.isAnnotationPresent(Info.class)) {
            Info info = MyClass.class.getAnnotation(Info.class);
            System.out.println("Info - Author: " + info.author());
            System.out.println("Info - Date: " + info.date());
            System.out.println("Info - Version: " + info.version());
        }
    }
}














