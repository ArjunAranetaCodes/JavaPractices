public class Main {
    public static void main(String[] args) {
        String date = "2022-01-24";
        String[] dateComponents = date.split("-");
        
        System.out.println("Year: " + dateComponents[0]);
        System.out.println("Month: " + dateComponents[1]);
        System.out.println("Day: " + dateComponents[2]);
    }
}
