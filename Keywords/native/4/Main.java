public class Main {
    public native void myNativeMethod(); 

    public static void main(String[] args) {
        Main main = new Main();
        main.myNativeMethod();
    }

    static {
        System.loadLibrary("MyLibrary");
    }
}
