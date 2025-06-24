import java.lang.foreign.*;
import java.util.Arrays;

public class MemoryManagement {
    public static void main(String[] args) {
        // Example 1: Confined Arena
        try (Arena confined = Arena.ofConfined()) {
            MemorySegment segment = confined.allocate(100);
            System.out.println("Allocated 100 bytes in confined arena");
            
            // Write some data
            for (int i = 0; i < 10; i++) {
                segment.set(ValueLayout.JAVA_INT, i * 4, i);
            }
            
            // Read the data back
            for (int i = 0; i < 10; i++) {
                System.out.println("Value at " + i + ": " + segment.get(ValueLayout.JAVA_INT, i * 4));
            }
        } // Memory automatically freed here
        
        // Example 2: Shared Arena
        Arena shared = Arena.ofShared();
        try {
            MemorySegment sharedSegment = shared.allocate(50);
            System.out.println("\nAllocated 50 bytes in shared arena");
            
            // Write a string
            sharedSegment.setUtf8String(0, "Hello from shared memory!");
            
            // Read it back
            String result = sharedSegment.getUtf8String(0);
            System.out.println("Read from shared memory: " + result);
        } finally {
            shared.close(); // Explicitly close shared arena
        }
        
        // Example 3: Automatic Arena
        try (Arena auto = Arena.ofAuto()) {
            MemorySegment autoSegment = auto.allocate(200);
            System.out.println("\nAllocated 200 bytes in automatic arena");
            
            // Write an array of doubles
            double[] values = {1.1, 2.2, 3.3, 4.4, 5.5};
            for (int i = 0; i < values.length; i++) {
                autoSegment.set(ValueLayout.JAVA_DOUBLE, i * 8, values[i]);
            }
            
            // Read back as array
            double[] readValues = new double[values.length];
            for (int i = 0; i < values.length; i++) {
                readValues[i] = autoSegment.get(ValueLayout.JAVA_DOUBLE, i * 8);
            }
            System.out.println("Read values: " + Arrays.toString(readValues));
        }
    }
} 