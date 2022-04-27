import java.io.Serializable;

class MyClass implements Serializable {
    transient int transientVariable = 10;
    int nonTransientVariable = 20;
}

public class Main {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        System.out.println("Transient Variable: " + obj.transientVariable);
        System.out.println("Non-Transient Variable: " + obj.nonTransientVariable);
    }
}
  