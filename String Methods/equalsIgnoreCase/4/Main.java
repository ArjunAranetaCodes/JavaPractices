public class Main {
    public static void main(String[] args) {
        String[] array1 = {"apple", "banana", "orange"};
        String[] array2 = {"Apple", "Banana", "Orange"};

        boolean arraysEqual = true;

        for (int i = 0; i < array1.length; i++) {
            if (!array1[i].equalsIgnoreCase(array2[i])) {
                arraysEqual = false;
                break;
            }
        }

        if (arraysEqual) {
            System.out.println("Arrays are equal (case-insensitive).");
        } else {
            System.out.println("Arrays are not equal.");
        }
    }
}
