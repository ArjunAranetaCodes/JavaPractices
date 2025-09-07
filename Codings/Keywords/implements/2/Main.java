interface Interface1 {
    void method1();
}

interface Interface2 {
    void method2();
}

class MultiInterfaceClass implements Interface1, Interface2 {
    @Override
    public void method1() {
        System.out.println("Implementing Interface1");
    }

    @Override
    public void method2() {
        System.out.println("Implementing Interface2");
    }
}

public class Main {
    public static void main(String[] args) {
        MultiInterfaceClass obj = new MultiInterfaceClass(); 
        obj.method1();
        obj.method2();
    }
}
