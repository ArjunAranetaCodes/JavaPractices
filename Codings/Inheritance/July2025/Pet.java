/**
 * Pet interface - demonstrates interface inheritance
 * Shows how interfaces can be used for multiple inheritance
 */
public interface Pet {
    // Interface constants (public static final by default)
    String PET_TYPE = "Domestic Animal";
    
    // Abstract methods (public abstract by default)
    void play();
    void beFriendly();
    void getVaccinated();
    
    // Default method (Java 8+)
    default void showAffection() {
        System.out.println("Showing affection to owner");
    }
    
    // Static method (Java 8+)
    static void petFact() {
        System.out.println("Pets provide companionship and emotional support");
    }
} 