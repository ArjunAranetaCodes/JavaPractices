public class Main {
    public static void main(String[] args) {
        try {
            method1();
        } catch (Exception e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }

    static void method1() throws Exception {
        method2();
    }

    static void method2() throws Exception {
        throw new Exception("Exception thrown in method2");
    }
}
 