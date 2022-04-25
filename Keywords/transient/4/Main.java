import java.io.*;

class MyClass implements Serializable {
    transient static int transientStaticVariable = 10;
    static int nonTransientStaticVariable = 20;
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Transient Static Variable: " + MyClass.transientStaticVariable);
        System.out.println("Non-Transient Static Variable: " + MyClass.nonTransientStaticVariable);
    }
}
  