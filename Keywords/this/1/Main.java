class Main {
    private int number;

    public Main(int number) {
        this.number = number;
    }

    public void displayNumber() {
        System.out.println("Number: " + this.number);
    }

    public static void main(String[] args) {
        Main obj = new Main(42);
        obj.displayNumber();
    } 

}
