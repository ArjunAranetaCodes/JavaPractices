public class HelloJNI {
    // Load the native library
    static {
        try {
            System.loadLibrary("HelloJNI");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Native library 'HelloJNI' not found.");
            System.err.println("Please ensure the library is compiled and in the library path.");
            System.exit(1);
        }
    }

    // Native method declarations
    public native void sayHello();
    public native int add(int a, int b);
    public native String getMessage();
    public native void printArray(int[] array);
    public native int[] createArray(int size);
    public native double calculateAverage(double[] numbers);

    // Java method to demonstrate interaction
    public void javaMethod() {
        System.out.println("This is a Java method calling native code!");
    }

    public static void main(String[] args) {
        System.out.println("=== JNI Demo Program ===");
        
        HelloJNI jni = new HelloJNI();
        
        // Test 1: Simple native method call
        System.out.println("\n1. Testing sayHello():");
        jni.sayHello();
        
        // Test 2: Native method with parameters and return value
        System.out.println("\n2. Testing add():");
        int result = jni.add(10, 20);
        System.out.println("10 + 20 = " + result);
        
        // Test 3: Native method returning String
        System.out.println("\n3. Testing getMessage():");
        String message = jni.getMessage();
        System.out.println("Message from native code: " + message);
        
        // Test 4: Native method with array parameter
        System.out.println("\n4. Testing printArray():");
        int[] testArray = {1, 2, 3, 4, 5};
        jni.printArray(testArray);
        
        // Test 5: Native method returning array
        System.out.println("\n5. Testing createArray():");
        int[] newArray = jni.createArray(5);
        System.out.print("Created array: ");
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + " ");
        }
        System.out.println();
        
        // Test 6: Native method with double array
        System.out.println("\n6. Testing calculateAverage():");
        double[] numbers = {10.5, 20.3, 15.7, 8.9, 12.1};
        double average = jni.calculateAverage(numbers);
        System.out.println("Average of numbers: " + average);
        
        // Test 7: Java method calling native method
        System.out.println("\n7. Testing Java-Native interaction:");
        jni.javaMethod();
        
        System.out.println("\n=== JNI Demo Complete ===");
    }
} 