public class Main {
    public static void main(String[] args) throws InterruptedException {
        throwCheckedException();
    }

    private static void throwCheckedException() throws InterruptedException {
        throw new InterruptedException("Checked exception thrown");
    }
}
