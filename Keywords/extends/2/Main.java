interface Flyable {
    void fly();
}

class Bird implements Flyable {
    public void fly() {
        System.out.println("Bird is flying");
    }
}

public class Main {
    public static void main(String[] args) {
        Bird myBird = new Bird();
        myBird.fly();
    }
}
