public class Main {
    protected int protectedVariable = 10;

    public static void main(String[] args) {
        Main mainObj = new Main();  
        System.out.println("Protected Variable: " + mainObj.protectedVariable);
    }
} 
 