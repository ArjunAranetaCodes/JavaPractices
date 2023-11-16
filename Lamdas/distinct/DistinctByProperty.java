import java.util.Arrays;
import java.util.List;

class Product {
    String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

public class DistinctByProperty {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(new Product("Laptop"), new Product("Phone"),
                new Product("Laptop"), new Product("Tablet"));

        // Using distinct() with lambda expression to get distinct products based on their names
        products.stream()
                .map(Product::getName)
                .distinct()
                .forEach(System.out::println);
    }
}
