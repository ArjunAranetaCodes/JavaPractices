public class Main {
    // Native method declaration with parameters
    public native void myNativeMethod(int number);

    public static void main(String[] args) {
        Main main = new Main();
        main.myNativeMethod(42);
    }
}
