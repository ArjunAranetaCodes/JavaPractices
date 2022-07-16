public class Main {
    // Native method declaration
    public native void myNativeMethod();

    // Native method implementation
    static {
        System.loadLibrary("MyLibrary"); // Load the native library
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.myNativeMethod();
    }
}
