public class Main {
    public static void main(String[] args) {
        String inputString = "Hello,World,Java";
        String[] resultArray = inputString.split(",");
        
        for (String element : resultArray) {
            System.out.println(element);
        }
    }
}
 