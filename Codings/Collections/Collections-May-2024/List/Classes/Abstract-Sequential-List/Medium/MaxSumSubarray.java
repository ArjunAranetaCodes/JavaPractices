// File name: MaxSumSubarray.java

import java.util.AbstractSequentialList;
import java.util.ListIterator;

public class MaxSumSubarray {
    public static void main(String[] args) {
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = maxSumSubarray(array);
        System.out.println("Maximum sum: " + maxSum);
        int[] result = printSubarray(array, maxSum);
        System.out.println("Subarray: " + java.util.Arrays.toString(result));
    }

    public static int maxSumSubarray(int[] array) {
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;
        int startIndex = 0;
        int endIndex = 0;
        int tempStartIndex = 0;

        for (int i = 0; i < array.length; i++) {
            maxEndingHere += array[i];

            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
                startIndex = tempStartIndex;
                endIndex = i;
            }

            if (maxEndingHere < 0) {
                maxEndingHere = 0;
                tempStartIndex = i + 1;
            }
        }

        return maxSoFar;
    }

    public static int[] printSubarray(int[] array, int maxSum) {
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = i; j < array.length; j++) {
                sum += array[j];
                if (sum == maxSum) {
                    startIndex = i;
                    endIndex = j;
                    break;
                }
            }
            if (startIndex != 0) {
                break;
            }
        }
        int[] subarray = new int[endIndex - startIndex + 1];
        System.arraycopy(array, startIndex, subarray, 0, endIndex - startIndex + 1);
        return subarray;
    }
}