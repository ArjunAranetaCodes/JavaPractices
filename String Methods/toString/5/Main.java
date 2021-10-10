class MyClass {
    private String name;

    public MyClass(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyClass [name=" + name + "]";
    }
}

public class Main {
    public static void main(String[] args) {
        MyClass obj = new MyClass("Object Example");
        System.out.println(obj.toString());
    }
}
   