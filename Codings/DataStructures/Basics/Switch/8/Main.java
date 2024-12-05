public class Main {
    public static void main(String[] args) {
        int category = 2;
        int subCategory = 1;

        switch (category) {
            case 1:
                System.out.print("Category 1: ");
                switch (subCategory) {
                    case 1:
                        System.out.println("Subcategory 1");
                        break;
                    case 2:
                        System.out.println("Subcategory 2");
                        break;
                    default:
                        System.out.println("Unknown subcategory");
                }
                break;
            case 2:
                System.out.println("Category 2");
                break;
            default:
                System.out.println("Unknown category");
        }
    }
}
