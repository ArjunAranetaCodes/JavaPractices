import java.io.*;

class MyClass implements Serializable {
    transient int[] transientArray = {1, 2, 3};
    int[] nonTransientArray = {4, 5, 6};
}

public class Main {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        System.out.println("Transient Array: " + Arrays.toString(obj.transientArray));
        System.out.println("Non-Transient Array: " + Arrays.toString(obj.nonTransientArray));
    }
}
