public class Main {
    public static void main(String[] args) {
        CustomClass obj = new CustomClass();
        obj.printInternedString();
    }
}

class CustomClass {
    String str = new String("CustomString").intern();
    
    public void printInternedString() {
        System.out.println(str); // Output: CustomString
    }
}
  