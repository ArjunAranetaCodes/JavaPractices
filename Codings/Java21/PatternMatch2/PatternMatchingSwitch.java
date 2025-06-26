public class PatternMatchingSwitch {
    public static void main(String[] args) {
        int day = 2;
        switch (day) {
            case 1, 2, 3 -> System.out.println("Monday, Tuesday, or Wednesday");
            case 4, 5 -> System.out.println("Thursday or Friday");
            default -> System.out.println("Weekend");
        }
    }
}