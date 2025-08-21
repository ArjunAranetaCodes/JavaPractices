public class SystemInfo {
    // Load the native library
    static {
        try {
            System.loadLibrary("SystemInfo");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Native library 'SystemInfo' not found.");
            System.err.println("Please ensure the library is compiled and in the library path.");
            System.exit(1);
        }
    }

    // Native method declarations for system information
    public native String getOperatingSystem();
    public native String getArchitecture();
    public native long getTotalMemory();
    public native long getFreeMemory();
    public native int getProcessorCount();
    public native String getProcessorInfo();
    public native long getCurrentTimeMillis();
    public native String getCurrentWorkingDirectory();
    public native String getEnvironmentVariable(String name);
    public native String[] getEnvironmentVariables();
    public native int getCurrentProcessId();
    public native String getHostname();
    public native double getSystemLoad();
    public native String getSystemUptime();

    public static void main(String[] args) {
        System.out.println("=== JNI System Information Demo ===");
        
        SystemInfo sysInfo = new SystemInfo();
        
        // Test 1: Get operating system information
        System.out.println("\n1. Operating System Information:");
        String os = sysInfo.getOperatingSystem();
        System.out.println("OS: " + os);
        
        // Test 2: Get system architecture
        System.out.println("\n2. System Architecture:");
        String arch = sysInfo.getArchitecture();
        System.out.println("Architecture: " + arch);
        
        // Test 3: Get memory information
        System.out.println("\n3. Memory Information:");
        long totalMem = sysInfo.getTotalMemory();
        long freeMem = sysInfo.getFreeMemory();
        long usedMem = totalMem - freeMem;
        double memUsagePercent = ((double) usedMem / totalMem) * 100;
        
        System.out.println("Total Memory: " + formatBytes(totalMem));
        System.out.println("Free Memory: " + formatBytes(freeMem));
        System.out.println("Used Memory: " + formatBytes(usedMem));
        System.out.printf("Memory Usage: %.2f%%\n", memUsagePercent);
        
        // Test 4: Get processor information
        System.out.println("\n4. Processor Information:");
        int cpuCount = sysInfo.getProcessorCount();
        String cpuInfo = sysInfo.getProcessorInfo();
        System.out.println("CPU Count: " + cpuCount);
        System.out.println("CPU Info: " + cpuInfo);
        
        // Test 5: Get current time
        System.out.println("\n5. Current Time:");
        long currentTime = sysInfo.getCurrentTimeMillis();
        System.out.println("Current Time (ms): " + currentTime);
        System.out.println("Current Time: " + new java.util.Date(currentTime));
        
        // Test 6: Get current working directory
        System.out.println("\n6. Current Working Directory:");
        String cwd = sysInfo.getCurrentWorkingDirectory();
        System.out.println("CWD: " + cwd);
        
        // Test 7: Get specific environment variable
        System.out.println("\n7. Environment Variables:");
        String javaHome = sysInfo.getEnvironmentVariable("JAVA_HOME");
        String path = sysInfo.getEnvironmentVariable("PATH");
        System.out.println("JAVA_HOME: " + (javaHome != null ? javaHome : "Not set"));
        System.out.println("PATH: " + (path != null ? path.substring(0, Math.min(100, path.length())) + "..." : "Not set"));
        
        // Test 8: Get all environment variables
        System.out.println("\n8. All Environment Variables (first 10):");
        String[] envVars = sysInfo.getEnvironmentVariables();
        if (envVars != null) {
            int count = Math.min(10, envVars.length);
            for (int i = 0; i < count; i++) {
                System.out.println("  " + envVars[i]);
            }
            System.out.println("  ... and " + (envVars.length - count) + " more");
        }
        
        // Test 9: Get process information
        System.out.println("\n9. Process Information:");
        int pid = sysInfo.getCurrentProcessId();
        System.out.println("Current Process ID: " + pid);
        
        // Test 10: Get hostname
        System.out.println("\n10. Network Information:");
        String hostname = sysInfo.getHostname();
        System.out.println("Hostname: " + hostname);
        
        // Test 11: Get system load
        System.out.println("\n11. System Load:");
        double load = sysInfo.getSystemLoad();
        System.out.printf("System Load: %.2f\n", load);
        
        // Test 12: Get system uptime
        System.out.println("\n12. System Uptime:");
        String uptime = sysInfo.getSystemUptime();
        System.out.println("Uptime: " + uptime);
        
        // Test 13: Compare with Java system properties
        System.out.println("\n13. Comparison with Java System Properties:");
        System.out.println("Java OS: " + System.getProperty("os.name"));
        System.out.println("Java Arch: " + System.getProperty("os.arch"));
        System.out.println("Java Version: " + System.getProperty("java.version"));
        System.out.println("Java Runtime: " + Runtime.getRuntime().totalMemory() + " bytes");
        
        System.out.println("\n=== JNI System Information Demo Complete ===");
    }
    
    // Helper method to format bytes
    private static String formatBytes(long bytes) {
        if (bytes < 1024) return bytes + " B";
        int exp = (int) (Math.log(bytes) / Math.log(1024));
        String pre = "KMGTPE".charAt(exp-1) + "";
        return String.format("%.1f %sB", bytes / Math.pow(1024, exp), pre);
    }
} 