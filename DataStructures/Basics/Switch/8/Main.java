class Animal { }

public class Main {
    public static void main(String[] args) {
        Animal cat = new Animal();

        if (cat instanceof Animal) {
            System.out.println("cat is an instance of Animal");
        } else {
            System.out.println("cat is not an instance of Animal");
        }
    }
}
