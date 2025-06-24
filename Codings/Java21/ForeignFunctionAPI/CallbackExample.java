import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class CallbackExample {
    // Define the callback function type
    private static final FunctionDescriptor CALLBACK_DESCRIPTOR = FunctionDescriptor.of(
        ValueLayout.JAVA_INT,
        ValueLayout.JAVA_INT
    );

    public static void main(String[] args) throws Throwable {
        Linker linker = Linker.nativeLinker();
        
        // Create a callback function
        MethodHandle callback = MethodHandles.lookup().findStatic(
            CallbackExample.class,
            "callbackFunction",
            MethodType.methodType(int.class, int.class)
        );
        
        // Create a function pointer from the callback
        MemorySegment callbackPtr = linker.upcallStub(
            callback,
            CALLBACK_DESCRIPTOR,
            Arena.ofAuto()
        );
        
        // Define a function that takes a callback
        MethodHandle processWithCallback = linker.downcallHandle(
            linker.defaultLookup().find("process_with_callback").orElseThrow(),
            FunctionDescriptor.of(
                ValueLayout.JAVA_INT,
                ValueLayout.ADDRESS,
                ValueLayout.JAVA_INT
            )
        );
        
        // Call the function with our callback
        int result = (int) processWithCallback.invoke(callbackPtr, 5);
        System.out.println("Result from native function: " + result);
    }
    
    // The callback function that will be called from native code
    public static int callbackFunction(int value) {
        System.out.println("Callback called with value: " + value);
        return value * 2;
    }
} 