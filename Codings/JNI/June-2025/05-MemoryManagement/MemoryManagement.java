public class MemoryManagement {
    // Load the native library
    static {
        try {
            System.loadLibrary("MemoryManagement");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Native library 'MemoryManagement' not found.");
            System.err.println("Please ensure the library is compiled and in the library path.");
            System.exit(1);
        }
    }

    // Native method declarations for memory management
    public native long allocateMemory(int size);
    public native boolean freeMemory(long address);
    public native boolean writeToMemory(long address, byte[] data);
    public native byte[] readFromMemory(long address, int size);
    public native long getMemoryUsage();
    public native void clearMemory(long address, int size);
    public native boolean isValidAddress(long address);
    public native long[] allocateArray(int size);
    public native boolean freeArray(long[] addresses);
    public native void memoryCopy(long source, long destination, int size);
    public native void memorySet(long address, byte value, int size);
    public native String getMemoryInfo();
    public native void forceGarbageCollection();
    public native long getTotalAllocatedMemory();
    public native int getActiveAllocations();
    public native void resetMemoryStats();

    public static void main(String[] args) {
        System.out.println("=== JNI Memory Management Demo ===");
        
        MemoryManagement memMgr = new MemoryManagement();
        
        // Test 1: Basic memory allocation and deallocation
        System.out.println("\n1. Basic Memory Operations:");
        System.out.println("Memory info before allocation: " + memMgr.getMemoryInfo());
        
        int size = 1024; // 1KB
        long address = memMgr.allocateMemory(size);
        System.out.println("Allocated " + size + " bytes at address: " + address);
        System.out.println("Address valid: " + memMgr.isValidAddress(address));
        
        System.out.println("Memory info after allocation: " + memMgr.getMemoryInfo());
        
        boolean freed = memMgr.freeMemory(address);
        System.out.println("Memory freed: " + freed);
        System.out.println("Memory info after deallocation: " + memMgr.getMemoryInfo());
        
        // Test 2: Memory read/write operations
        System.out.println("\n2. Memory Read/Write Operations:");
        long addr = memMgr.allocateMemory(100);
        System.out.println("Allocated 100 bytes at: " + addr);
        
        // Write data to memory
        String testData = "Hello from JNI Memory Management!";
        byte[] data = testData.getBytes();
        boolean written = memMgr.writeToMemory(addr, data);
        System.out.println("Data written: " + written);
        
        // Read data from memory
        byte[] readData = memMgr.readFromMemory(addr, data.length);
        String readString = new String(readData);
        System.out.println("Data read: " + readString);
        System.out.println("Data matches: " + testData.equals(readString));
        
        memMgr.freeMemory(addr);
        
        // Test 3: Memory clearing
        System.out.println("\n3. Memory Clearing:");
        long clearAddr = memMgr.allocateMemory(50);
        System.out.println("Allocated 50 bytes at: " + clearAddr);
        
        // Write some data
        byte[] testBytes = {1, 2, 3, 4, 5};
        memMgr.writeToMemory(clearAddr, testBytes);
        
        // Clear memory
        memMgr.clearMemory(clearAddr, 50);
        
        // Read back (should be zeros)
        byte[] clearedData = memMgr.readFromMemory(clearAddr, 10);
        System.out.print("Cleared memory (first 10 bytes): ");
        for (int i = 0; i < 10; i++) {
            System.out.print(clearedData[i] + " ");
        }
        System.out.println();
        
        memMgr.freeMemory(clearAddr);
        
        // Test 4: Array allocation
        System.out.println("\n4. Array Allocation:");
        int arraySize = 5;
        long[] addresses = memMgr.allocateArray(arraySize);
        System.out.println("Allocated " + arraySize + " memory blocks:");
        for (int i = 0; i < addresses.length; i++) {
            System.out.println("  Block " + i + ": " + addresses[i]);
        }
        
        // Write different data to each block
        for (int i = 0; i < addresses.length; i++) {
            String blockData = "Block " + i;
            memMgr.writeToMemory(addresses[i], blockData.getBytes());
        }
        
        // Read data from each block
        for (int i = 0; i < addresses.length; i++) {
            byte[] blockRead = memMgr.readFromMemory(addresses[i], 10);
            String blockString = new String(blockRead).trim();
            System.out.println("  Block " + i + " contains: " + blockString);
        }
        
        memMgr.freeArray(addresses);
        
        // Test 5: Memory copy operations
        System.out.println("\n5. Memory Copy Operations:");
        long srcAddr = memMgr.allocateMemory(20);
        long dstAddr = memMgr.allocateMemory(20);
        
        String copyData = "Copy this data";
        memMgr.writeToMemory(srcAddr, copyData.getBytes());
        
        memMgr.memoryCopy(srcAddr, dstAddr, copyData.length());
        
        byte[] copiedData = memMgr.readFromMemory(dstAddr, copyData.length());
        String copiedString = new String(copiedData);
        System.out.println("Original: " + copyData);
        System.out.println("Copied: " + copiedString);
        System.out.println("Copy successful: " + copyData.equals(copiedString));
        
        memMgr.freeMemory(srcAddr);
        memMgr.freeMemory(dstAddr);
        
        // Test 6: Memory set operations
        System.out.println("\n6. Memory Set Operations:");
        long setAddr = memMgr.allocateMemory(10);
        
        memMgr.memorySet(setAddr, (byte)0xAA, 10);
        
        byte[] setData = memMgr.readFromMemory(setAddr, 10);
        System.out.print("Memory set with 0xAA: ");
        for (int i = 0; i < 10; i++) {
            System.out.printf("0x%02X ", setData[i] & 0xFF);
        }
        System.out.println();
        
        memMgr.freeMemory(setAddr);
        
        // Test 7: Memory statistics
        System.out.println("\n7. Memory Statistics:");
        System.out.println("Total allocated memory: " + memMgr.getTotalAllocatedMemory() + " bytes");
        System.out.println("Active allocations: " + memMgr.getActiveAllocations());
        System.out.println("Current memory usage: " + memMgr.getMemoryUsage() + " bytes");
        
        // Test 8: Memory leak prevention
        System.out.println("\n8. Memory Leak Prevention:");
        System.out.println("Allocating multiple memory blocks...");
        
        long[] leakTestAddresses = new long[10];
        for (int i = 0; i < 10; i++) {
            leakTestAddresses[i] = memMgr.allocateMemory(1024);
            System.out.println("  Allocated block " + i + " at: " + leakTestAddresses[i]);
        }
        
        System.out.println("Active allocations before cleanup: " + memMgr.getActiveAllocations());
        
        // Properly free all memory
        for (int i = 0; i < 10; i++) {
            memMgr.freeMemory(leakTestAddresses[i]);
        }
        
        System.out.println("Active allocations after cleanup: " + memMgr.getActiveAllocations());
        
        // Test 9: Garbage collection
        System.out.println("\n9. Garbage Collection:");
        System.out.println("Memory usage before GC: " + memMgr.getMemoryUsage() + " bytes");
        memMgr.forceGarbageCollection();
        System.out.println("Memory usage after GC: " + memMgr.getMemoryUsage() + " bytes");
        
        // Test 10: Error handling
        System.out.println("\n10. Error Handling:");
        
        // Try to access invalid address
        boolean valid = memMgr.isValidAddress(0x12345678);
        System.out.println("Invalid address valid: " + valid);
        
        // Try to free invalid address
        boolean freedInvalid = memMgr.freeMemory(0x12345678);
        System.out.println("Freed invalid address: " + freedInvalid);
        
        // Test 11: Performance test
        System.out.println("\n11. Performance Test:");
        int numAllocations = 1000;
        long[] perfAddresses = new long[numAllocations];
        
        long startTime = System.nanoTime();
        for (int i = 0; i < numAllocations; i++) {
            perfAddresses[i] = memMgr.allocateMemory(100);
        }
        long allocTime = System.nanoTime() - startTime;
        
        startTime = System.nanoTime();
        for (int i = 0; i < numAllocations; i++) {
            memMgr.freeMemory(perfAddresses[i]);
        }
        long freeTime = System.nanoTime() - startTime;
        
        System.out.printf("Allocated %d blocks in %d ns (%.2f ns/block)\n", 
                         numAllocations, allocTime, (double)allocTime / numAllocations);
        System.out.printf("Freed %d blocks in %d ns (%.2f ns/block)\n", 
                         numAllocations, freeTime, (double)freeTime / numAllocations);
        
        // Test 12: Memory reset
        System.out.println("\n12. Memory Statistics Reset:");
        memMgr.resetMemoryStats();
        System.out.println("Memory stats after reset: " + memMgr.getMemoryInfo());
        
        System.out.println("\n=== JNI Memory Management Demo Complete ===");
    }
} 