public class Main {
    public static void main(String[] args) {
        MyClass myObject = new MyClass();
        System.out.println("Constant value from constructor: " + myObject.getConstantValue());
    }
}

class MyClass {
    private final int CONSTANT_VALUE;

    public MyClass() {
        CONSTANT_VALUE = 7;
    }

    public int getConstantValue() {
    }
}
