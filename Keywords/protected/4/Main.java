public class Main {
    protected class ProtectedInnerClass {
        public void display() {
            System.out.println("Inside the protected inner class.");
        }
    }

    public static void main(String[] args) {
        Main mainObj = new Main();
        ProtectedInnerClass innerObj = mainObj.new ProtectedInnerClass();
        innerObj.display();
    }
}
