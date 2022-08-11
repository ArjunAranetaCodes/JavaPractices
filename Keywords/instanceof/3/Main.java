public class Main {
    public static void main(String[] args) {
        Object[] objects = {"Hello", 42, 3.14, new Main()};

        for (Object obj : objects) {
            if (obj instanceof String) {
                System.out.println(obj + " is a String");
            } else if (obj instanceof Integer) {
                System.out.println(obj + " is an Integer");
            } else {
                System.out.println(obj + " is of unknown type");
            }
        }
    }
}
