public class Main {
    public static void main(String[] args) {
        String mainString = "Programming is fun!";
        String searchString = "is";

        if (mainString.contains(searchString)) {
            System.out.println("Substring '" + searchString + "' found in the main string.");
        } else {
            System.out.println("Substring '" + searchString + "' not found in the main string.");
        }
    }
}
