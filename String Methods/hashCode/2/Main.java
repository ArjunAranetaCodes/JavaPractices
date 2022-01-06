public class Main {
    public static void main(String[] args) {
        // Creating an object with a custom class
        CustomClass exampleObject = new CustomClass(42, "Sample");
        int hashCode = exampleObject.hashCode();
        System.out.println("HashCode of the custom object: " + hashCode);
    }
}

class CustomClass {
    private int number;
    private String name;

    public CustomClass(int number, String name) {
        this.number = number; 
        this.name = name;
    }

    @Override
    public int hashCode() {
        // Custom hashCode implementation for the object
        return Objects.hash(number, name);
    }
}
