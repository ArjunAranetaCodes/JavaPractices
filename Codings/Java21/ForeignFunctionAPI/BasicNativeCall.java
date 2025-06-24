import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;

public class BasicNativeCall {
    public static void main(String[] args) throws Throwable {
        // Get the default linker
        Linker linker = Linker.nativeLinker();
        
        // Get the default lookup
        SymbolLookup stdlib = linker.defaultLookup();
        
        // Find the 'printf' function
        MethodHandle printf = linker.downcallHandle(
            stdlib.find("printf").orElseThrow(),
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS)
        );
        
        // Create a memory segment for the string
        try (Arena arena = Arena.ofConfined()) {
            MemorySegment str = arena.allocateUtf8String("Hello from Java FFM API!\n");
            
            // Call printf
            int result = (int) printf.invoke(str);
            System.out.println("printf returned: " + result);
        }
    }
} 