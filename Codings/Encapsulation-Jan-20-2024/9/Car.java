public class Car {
    private String make;
    private String model;
    private int year;

    // Constructor and other methods

    public void setYear(int year) {
        // Implement year update logic
    }

    public int getYear() {
        // Implement year retrieval logic
        return year;
    }

    public String getCarInfo() {
        // Implement car information retrieval logic
        return year + " " + make + " " + model;
    }
}
