public class Main {
    // Loading a native library
    static {
        System.loadLibrary("MyLibrary");
    }

    public native void myNativeMethod();

    public static void main(String[] args) {
        Main main = new Main();
        main.myNativeMethod();
    }
}
