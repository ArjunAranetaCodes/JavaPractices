// Program 4
public class Main {
    enum Direction {
        NORTH, SOUTH, EAST, WEST
    }

    public static void main(String[] args) {
        Direction myDirection = Direction.EAST;

        switch (myDirection) {
            case NORTH:
                System.out.println("Heading North");
                break;
            case SOUTH:
                System.out.println("Heading South");
                break;
            case EAST:
                System.out.println("Heading East");
                break;
            case WEST:
                System.out.println("Heading West");
                break;
            default:
                System.out.println("Invalid direction");
        }
    }
}
