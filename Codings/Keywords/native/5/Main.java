public class Main {
    public native void myNativeMethod(int number);

    public static void main(String[] args) {
        Main main = new Main();
        main.myNativeMethod(42);
    }
}
