import java.util.HashMap;
import java.util.Map;

public class ProductCatalog {
    private HashMap<String, Product> products;

    public ProductCatalog() {
        products = new HashMap<>();
    }

    public void addProduct(String name, String description, double price) {
        products.put(name, new Product(description, price));
    }

    public Product getProduct(String name) {
        return products.get(name);
    }

    public static void main(String[] args) {
        ProductCatalog catalog = new ProductCatalog();

        catalog.addProduct("Product1", "Description1", 10.99);
        catalog.addProduct("Product2", "Description2", 9.99);
        catalog.addProduct("Product3", "Description3", 12.99);

        System.out.println("Product catalog:");
        for (Map.Entry<String, Product> entry : catalog.products.entrySet()) {
            Product product = entry.getValue();
            System.out.println(entry.getKey() + " = " + product.getDescription() + " ($" + product.getPrice() + ")");
        }
    }
}

class Product {
    private String description;
    private double price;

    public Product(String description, double price) {
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
}