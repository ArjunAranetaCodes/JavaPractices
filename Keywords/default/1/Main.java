interface MyInterface {
    default void display() {
        System.out.println("Default method in interface");
    }
}

class Main implements MyInterface {
    public static void main(String[] args) {
        Main obj = new Main();
        obj.display();
    }
}
