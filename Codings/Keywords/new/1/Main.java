public class Main {
    public static void main(String[] args) {
        // Creating a new object of the class MyClass using the new keyword
        MyClass myObject = new MyClass();
        
        // Perform operations on the created object
        myObject.display();
    }
}

class MyClass {
    void display() {
        System.out.println("Hello, I am an object!");
    }
}
