public class Main {
    public static void main(String[] args) {
        int[] sourceArray = {10, 20, 30, 40, 50};
        int[] destinationArray = new int[sourceArray.length];

        System.arraycopy(sourceArray, 0, destinationArray, 0, sourceArray.length);

        System.out.println("Source Array: " + Arrays.toString(sourceArray));
        System.out.println("Copied Array: " + Arrays.toString(destinationArray));
    }
}
