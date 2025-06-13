public class Main {
    public static void main(String[] args) {
        Person person = new Person("John", 30);

        // Use record pattern to extract values
        if (person instanceof Person(var name, var age)) {
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
        }
    }
}