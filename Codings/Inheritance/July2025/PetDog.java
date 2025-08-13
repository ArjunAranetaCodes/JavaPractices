/**
 * PetDog class - demonstrates multiple inheritance through interfaces
 * Extends Dog class and implements Pet interface
 */
public class PetDog extends Dog implements Pet {
    // Additional fields specific to PetDog
    private String ownerName;
    private boolean isVaccinated;
    
    // Default constructor
    public PetDog() {
        super(); // Call parent constructor
        this.ownerName = "Unknown";
        this.isVaccinated = false;
    }
    
    // Parameterized constructor
    public PetDog(String name, int age, String habitat, String breed, 
                  boolean isTrained, String ownerName, boolean isVaccinated) {
        super(name, age, habitat, breed, isTrained); // Call parent constructor
        this.ownerName = ownerName;
        this.isVaccinated = isVaccinated;
    }
    
    // Method overriding - calling parent method and adding functionality
    @Override
    public void displayInfo() {
        super.displayInfo(); // Call parent method
        System.out.println("Owner: " + ownerName);
        System.out.println("Vaccinated: " + (isVaccinated ? "Yes" : "No"));
        System.out.println("Pet Type: " + PET_TYPE); // Interface constant
    }
    
    // Implementing Pet interface methods
    @Override
    public void play() {
        System.out.println(name + " is playing with " + ownerName);
    }
    
    @Override
    public void beFriendly() {
        System.out.println(name + " is being friendly to " + ownerName);
    }
    
    @Override
    public void getVaccinated() {
        if (!isVaccinated) {
            System.out.println(name + " is getting vaccinated");
            isVaccinated = true;
        } else {
            System.out.println(name + " is already vaccinated");
        }
    }
    
    // Overriding default method from interface
    @Override
    public void showAffection() {
        System.out.println(name + " is licking " + ownerName + "'s face");
    }
    
    // New methods specific to PetDog
    public void goForWalk() {
        System.out.println(name + " is going for a walk with " + ownerName);
    }
    
    public void sleepInBed() {
        System.out.println(name + " is sleeping in " + ownerName + "'s bed");
    }
    
    // Getters and setters for PetDog-specific fields
    public String getOwnerName() {
        return ownerName;
    }
    
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    
    public boolean isVaccinated() {
        return isVaccinated;
    }
    
    public void setVaccinated(boolean vaccinated) {
        isVaccinated = vaccinated;
    }
} 