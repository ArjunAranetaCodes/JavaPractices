public class Main {
    // Native method declaration
    public native void myNativeMethod();

    public static void main(String[] args) {
        Main main = new Main();
        main.myNativeMethod();
    }

    // Load the native library
    static {
        System.loadLibrary("MyLibrary");
    }
}
