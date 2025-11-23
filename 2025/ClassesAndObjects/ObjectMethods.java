/**
 * Tutorial: Object Class Methods
 * Demonstrates toString(), equals(), hashCode(), getClass()
 */
public class ObjectMethods {
    private String name;
    private int id;
    
    public ObjectMethods(String name, int id) {
        this.name = name;
        this.id = id;
    }
    
    // Override toString()
    @Override
    public String toString() {
        return "ObjectMethods{name='" + name + "', id=" + id + "}";
    }
    
    // Override equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ObjectMethods that = (ObjectMethods) obj;
        return id == that.id && name.equals(that.name);
    }
    
    // Override hashCode()
    @Override
    public int hashCode() {
        return name.hashCode() * 31 + id;
    }
    
    public static void main(String[] args) {
        ObjectMethods obj1 = new ObjectMethods("Alice", 1);
        ObjectMethods obj2 = new ObjectMethods("Bob", 2);
        ObjectMethods obj3 = new ObjectMethods("Alice", 1);
        
        // toString()
        System.out.println("obj1: " + obj1);
        System.out.println("obj2: " + obj2);
        
        // equals()
        System.out.println("\nobj1.equals(obj2): " + obj1.equals(obj2));
        System.out.println("obj1.equals(obj3): " + obj1.equals(obj3));
        
        // hashCode()
        System.out.println("\nobj1.hashCode(): " + obj1.hashCode());
        System.out.println("obj2.hashCode(): " + obj2.hashCode());
        System.out.println("obj3.hashCode(): " + obj3.hashCode());
        
        // getClass()
        System.out.println("\nobj1.getClass(): " + obj1.getClass());
        System.out.println("obj1.getClass().getName(): " + obj1.getClass().getName());
    }
}
















