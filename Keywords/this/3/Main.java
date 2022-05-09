class Main {
    private String message;

    public Main setMessage(String message) {
        this.message = message;
        return this;
    }

    public void displayMessage() {
        System.out.println("Message: " + this.message);
    }

    public static void main(String[] args) {
        Main obj = new Main();
        obj.setMessage("Hello, ").displayMessage();
    }
}
 