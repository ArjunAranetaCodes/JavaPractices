public class Main {
    public final void finalMethod() {
        System.out.println("This is a final method."); 
    }

    public static void main(String[] args) {
        Main obj = new Main();
        obj.finalMethod();
    }
}
