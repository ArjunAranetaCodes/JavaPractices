class Main {
    private int x;
    private int y;

    public Main() {
        this(0, 0); // Calls another constructor using "this" 
    }

    public Main(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void displayCoordinates() {
        System.out.println("X: " + this.x + ", Y: " + this.y);
    }

    public static void main(String[] args) {
        Main point = new Main();
        point.displayCoordinates();
    }
}
