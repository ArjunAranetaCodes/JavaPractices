class Main {
    private static class InnerClass {
        void display() {
            System.out.println("This is a private inner class.");
        }
    }

    public static void main(String[] args) {
        InnerClass innerObj = new InnerClass();  
        innerObj.display();
    }
}
