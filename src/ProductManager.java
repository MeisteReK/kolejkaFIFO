import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private static final String PRODUCTS_FILE = "products.csv"; // Plik CSV przechowujący produkty

    public void addProduct(Product product) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PRODUCTS_FILE, true))) {
            writer.write(product.getProductId() + "," + product.getName() + "," + product.getPrice() + "," + product.getQuantity());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(String productId) {
        List<Product> products = getAllProducts();

        // Usuń produkt o wskazanym productId
        products.removeIf(product -> product.getProductId().equals(productId));

        // Zapisz zmienioną zawartość do pliku CSV
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PRODUCTS_FILE))) {
            for (Product product : products) {
                writer.write(product.getProductId() + "," + product.getName() + "," + product.getPrice() + "," + product.getQuantity());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();

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

        return products;
    }
}