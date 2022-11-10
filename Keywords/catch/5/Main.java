public class Main {
    enum Season {
        SPRING, SUMMER, AUTUMN, WINTER
    }

    public static void main(String[] args) {
        Season currentSeason = Season.SUMMER;

        switchSeason(currentSeason);
    }

    static void switchSeason(Season season) {
        switch (season) {
            case SPRING:
                System.out.println("It's Spring!");
                break;
            case SUMMER:
                System.out.println("It's Summer!");
                break;
            case AUTUMN:
                System.out.println("It's Autumn!");
                break;
            case WINTER:
                System.out.println("It's Winter!");
                break;
        }
    }
}
