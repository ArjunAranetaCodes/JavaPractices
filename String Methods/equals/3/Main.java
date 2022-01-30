class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return name.equals(person.name);
    }
}

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("John");  
        Person person2 = new Person("John");
        
        boolean result = person1.equals(person2);
        System.out.println("Are person1 and person2 equal? " + result);
    }
}
