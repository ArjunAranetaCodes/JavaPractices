public class NestedUnnamedPattern {
    record Address(String city, String country) {}
    record Person(String name, Address address) {}

    public static void main(String[] args) {
        Person person = new Person("Alice", new Address("London", "UK"));

        // Only care about the city, ignore the country and name
        if (person instanceof Person(_, Address(String city, _))) {
            System.out.println("City: " + city);
        }
    }
} 