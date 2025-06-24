import java.lang.foreign.*;
import java.lang.invoke.VarHandle;

public class StructHandling {
    // Define a C struct equivalent to:
    // struct Point {
    //     int x;
    //     int y;
    //     double value;
    // };
    private static final GroupLayout POINT_STRUCT = MemoryLayout.structLayout(
        ValueLayout.JAVA_INT.withName("x"),
        ValueLayout.JAVA_INT.withName("y"),
        ValueLayout.JAVA_DOUBLE.withName("value")
    );

    public static void main(String[] args) {
        try (Arena arena = Arena.ofConfined()) {
            // Allocate memory for the struct
            MemorySegment point = arena.allocate(POINT_STRUCT);
            
            // Get var handles for each field
            VarHandle xHandle = POINT_STRUCT.varHandle(MemoryLayout.PathElement.groupElement("x"));
            VarHandle yHandle = POINT_STRUCT.varHandle(MemoryLayout.PathElement.groupElement("y"));
            VarHandle valueHandle = POINT_STRUCT.varHandle(MemoryLayout.PathElement.groupElement("value"));
            
            // Set values
            xHandle.set(point, 10);
            yHandle.set(point, 20);
            valueHandle.set(point, 3.14159);
            
            // Read values back
            System.out.println("Point struct values:");
            System.out.println("x: " + xHandle.get(point));
            System.out.println("y: " + yHandle.get(point));
            System.out.println("value: " + valueHandle.get(point));
            
            // Create an array of points
            MemorySegment points = arena.allocateArray(POINT_STRUCT, 3);
            
            // Set values for each point in the array
            for (int i = 0; i < 3; i++) {
                xHandle.set(points, (long) i, i * 10);
                yHandle.set(points, (long) i, i * 20);
                valueHandle.set(points, (long) i, i * 1.5);
            }
            
            // Read values from the array
            System.out.println("\nArray of points:");
            for (int i = 0; i < 3; i++) {
                System.out.printf("Point %d: x=%d, y=%d, value=%.2f%n",
                    i,
                    xHandle.get(points, (long) i),
                    yHandle.get(points, (long) i),
                    valueHandle.get(points, (long) i)
                );
            }
        }
    }
} 