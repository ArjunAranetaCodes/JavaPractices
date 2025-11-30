/**
 * Tutorial: Getter and Setter Methods
 * Demonstrates proper encapsulation with getters and setters
 */
public class GetterSetter {
    private String name;
    private int age;
    private String email;
    
    // Getter for name
    public String getName() {
        return name;
    }
    
    // Setter for name with validation
    public void setName(String name) {
        if (name != null && name.length() > 0) {
            this.name = name;
        }
    }
    
    // Getter for age
    public int getAge() {
        return age;
    }
    
    // Setter for age with validation
    public void setAge(int age) {
        if (age >= 0 && age <= 120) {
            this.age = age;
        } else {
            System.out.println("Invalid age: " + age);
        }
    }
    
    // Getter for email
    public String getEmail() {
        return email;
    }
    
    // Setter for email with validation
    public void setEmail(String email) {
        if (email != null && email.contains("@")) {
            this.email = email;
        } else {
            System.out.println("Invalid email: " + email);
        }
    }
    
    // Read-only property (only getter)
    public String getInfo() {
        return "Name: " + name + ", Age: " + age + ", Email: " + email;
    }
    
    public static void main(String[] args) {
        GetterSetter person = new GetterSetter();
        
        person.setName("Alice");
        person.setAge(25);
        person.setEmail("alice@example.com");
        
        System.out.println(person.getInfo());
        
        // Invalid data
        person.setAge(150);
        person.setEmail("invalid-email");
    }
}


















