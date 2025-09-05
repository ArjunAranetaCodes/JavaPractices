interface MyGenericInterface<T> {
    void process(T item);
}

class GenericClass implements MyGenericInterface<String> {
    @Override
    public void process(String item) {
        System.out.println("Processing: " + item);
    }
}

public class Main {
    public static void main(String[] args) {
        GenericClass obj = new GenericClass();
        obj.process("Generic Interface Example");
    }
}
