import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private static final String PRODUCTS_FILE = "products.csv"; // Plik CSV przechowujący produkty
    private List<Product> products;

    public ProductManager() {
        products = new ArrayList<>();
        loadFromFile();
    }

    public void addProduct(Product product) {
        products.add(product);
        saveProductsToFile();
    }

    public void deleteProduct(String productId) {
        products.removeIf(product -> product.getProductId().equals(productId));
        saveProductsToFile();
    }

    public void displayAllProducts() {
        for (Product product : products) {
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Name: " + product.getName());
            System.out.println("Price: " + product.getPrice());
            System.out.println("Quantity: " + product.getQuantity());
            System.out.println("-------------------------");
        }
    }

    public void updateProduct(String productId, String newName, double newPrice, int newQuantity) {
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                product.setName(newName);
                product.setPrice(newPrice);
                product.setQuantity(newQuantity);
                break;
            }
        }
        saveProductsToFile();
    }

    private void saveProductsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PRODUCTS_FILE))) {
            for (Product product : products) {
                writer.write(product.getProductId() + "," + product.getName() + "," + product.getPrice() + "," + product.getQuantity());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(PRODUCTS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    String productId = data[0];
                    String name = data[1];
                    double price = Double.parseDouble(data[2]);
                    int quantity = Integer.parseInt(data[3]);

                    Product product = new Product(productId, name, price, quantity);
                    products.add(product);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}