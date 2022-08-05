// Program 1
interface MyInterface {
    void myMethod();
}

class MyClass implements MyInterface {
    public void myMethod() {
        System.out.println("Implementation of myMethod");
    }
}

public class Main {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.myMethod();
    }
}
