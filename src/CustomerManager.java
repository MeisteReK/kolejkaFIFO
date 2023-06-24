import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    private static final String CUSTOMERS_FILE = "customers.csv"; // Plik CSV przechowujący klientów

    public void addCustomer(Customer customer) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CUSTOMERS_FILE, true))) {
            writer.write(customer.getCustomerId() + "," + customer.getFirstName() + "," + customer.getLastName() + "," + customer.getAddress());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(String customerId) {
        List<Customer> customers = getAllCustomers();

        // Usuń klienta o wskazanym customerId
        customers.removeIf(customer -> customer.getCustomerId().equals(customerId));

        // Zapisz zmienioną zawartość do pliku CSV
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CUSTOMERS_FILE))) {
            for (Customer customer : customers) {
                writer.write(customer.getCustomerId() + "," + customer.getFirstName() + "," + customer.getLastName() + "," + customer.getAddress());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayAllCustomers() {
        List<Customer> customers = getAllCustomers();

        for (Customer customer : customers) {
            System.out.println("Customer ID: " + customer.getCustomerId());
            System.out.println("First Name: " + customer.getFirstName());
            System.out.println("Last Name: " + customer.getLastName());
            System.out.println("Address: " + customer.getAddress());
            System.out.println("-------------------------");
        }
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(CUSTOMERS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    String customerId = data[0];
                    String firstName = data[1];
                    String lastName = data[2];
                    String address = data[3];

                    Customer customer = new Customer(customerId, firstName, lastName, address);
                    customers.add(customer);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return customers;
    }
}