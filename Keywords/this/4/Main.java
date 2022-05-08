class Main {
    private int value;

    public Main(int value) {
        this.value = value;
    }

    public void printValue() {
        System.out.println("Value: " + this.value);
    }

    public void processValue(int newValue) {
        this.value = newValue;
        this.printValue();
    }

    public static void main(String[] args) {
        Main obj = new Main(10);
        obj.processValue(20);
    }
}
