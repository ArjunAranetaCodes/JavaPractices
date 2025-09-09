class Main {
    private void displayMessage() {
        System.out.println("This is a private method.");
    }

    public static void main(String[] args) {
        Main obj = new Main();
        obj.displayMessage();
    }
}
 