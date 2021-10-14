class CustomClass {
    private int value;

    public CustomClass(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "CustomClass [value=" + value + "]";
    }
}

public class Main {
    public static void main(String[] args) {
        CustomClass obj = new CustomClass(42);
        System.out.println(obj.toString());
    }
}
  