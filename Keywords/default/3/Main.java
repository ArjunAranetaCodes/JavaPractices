class Main {
    public static void main(String[] args) {
        int day = 3;
        String dayName;

        switch (day) {
            default:
                dayName = "Invalid day";
                break;
            case 1:
                dayName = "Monday";
                break;
            case 2:
                break;
            case 3:
                break;
        }

        System.out.println("Day: " + dayName);
    }
}
