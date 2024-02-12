public class Algorithm {
    public static void main(String[] args) {
        int num = 10; // You can change this number as per your requirement

        // Left Shift
        int leftShiftResult = leftShift(num, 2);
        System.out.println("Left Shift Result: " + leftShiftResult);

        // Right Shift
        int rightShiftResult = rightShift(num, 2);
        System.out.println("Right Shift Result: " + rightShiftResult);

        // Unsigned Right Shift
        int unsignedRightShiftResult = unsignedRightShift(num, 2);
        System.out.println("Unsigned Right Shift Result: " + unsignedRightShiftResult);
    }

    // Method to perform left shift operation
    private static int leftShift(int num, int shiftCount) {
        return num << shiftCount;
    }

    // Method to perform right shift operation
    private static int rightShift(int num, int shiftCount) {
        return num >> shiftCount;
    }

    // Method to perform unsigned right shift operation
    private static int unsignedRightShift(int num, int shiftCount) {
        return num >>> shiftCount;
    }
}
