class Main {
    public static void main(String[] args) {
        try {
            try {
            } catch (ArithmeticException e) {
                System.err.println("Inner catch block: " + e.getMessage());
            } finally {
                System.out.println("Inner finally block executed.");
            }
        } catch (Exception ex) {
            System.err.println("Outer catch block: " + ex.getMessage());
        } finally {
            System.out.println("Outer finally block executed.");
        }
    }
}
