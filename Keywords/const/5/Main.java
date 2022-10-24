public class Main {
    public static void main(String[] args) {
        MyClass myObject = new MyClass();
        System.out.println("Constant value from constructor: " + myObject.getConstantValue());
    }
}

class MyClass {

    public MyClass() {
    }

    public int getConstantValue() {
    }
}
