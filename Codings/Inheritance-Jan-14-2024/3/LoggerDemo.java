interface Logger {
    void logInfo(String message);
    void logWarning(String message);
    void logError(String message);
}

class ConsoleLogger implements Logger {
    @Override
    public void logInfo(String message) {
        System.out.println("Info: " + message);
    }

    @Override
    public void logWarning(String message) {
        System.out.println("Warning: " + message);
    }

    @Override
    public void logError(String message) {
        System.err.println("Error: " + message);
    }
}

class FileLogger implements Logger {
    @Override
    public void logInfo(String message) {
        // Implement file logging for info messages
        System.out.println("Info logged to file: " + message);
    }

    @Override
    public void logWarning(String message) {
        // Implement file logging for warning messages
        System.out.println("Warning logged to file: " + message);
    }

    @Override
    public void logError(String message) {
        // Implement file logging for error messages
        System.err.println("Error logged to file: " + message);
    }
}

class DatabaseLogger implements Logger {
    @Override
    public void logInfo(String message) {
        // Implement database logging for info messages
        System.out.println("Info logged to database: " + message);
    }

    @Override
    public void logWarning(String message) {
        // Implement database logging for warning messages
        System.out.println("Warning logged to database: " + message);
    }

    @Override
    public void logError(String message) {
        // Implement database logging for error messages
        System.err.println("Error logged to database: " + message);
    }
}

public class LoggerDemo {
    public static void main(String[] args) {
        Logger consoleLogger = new ConsoleLogger();
        consoleLogger.logInfo("This is an information message");
        consoleLogger.logWarning("This is a warning message");
    }
}
