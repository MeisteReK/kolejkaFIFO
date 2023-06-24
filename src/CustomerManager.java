import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    private static final String CUSTOMERS_FILE = "customers.csv"; // Plik CSV przechowujący klientów
    private List<Customer> customers;

    public CustomerManager() {
        customers = new ArrayList<>();
        loadFromFile();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        saveToFile();
    }

    public void deleteCustomer(String customerId) {
        customers.removeIf(customer -> customer.getCustomerId().equals(customerId));
        saveToFile();
    }

    public void updateCustomer(Customer customer) {
        for (Customer existingCustomer : customers) {
            if (existingCustomer.getCustomerId().equals(customer.getCustomerId())) {
                existingCustomer.setFirstName(customer.getFirstName());
                existingCustomer.setLastName(customer.getLastName());
                existingCustomer.setAddress(customer.getAddress());
                break;
            }
        }
        saveToFile();
    }

    public void displayAllCustomers() {
        for (Customer customer : customers) {
            System.out.println("Customer ID: " + customer.getCustomerId());
            System.out.println("First Name: " + customer.getFirstName());
            System.out.println("Last Name: " + customer.getLastName());
            System.out.println("Address: " + customer.getAddress());
            System.out.println("-------------------------");
        }
    }

    private void loadFromFile() {
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
    }

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CUSTOMERS_FILE))) {
            for (Customer customer : customers) {
                writer.write(customer.getCustomerId() + "," + customer.getFirstName() + "," + customer.getLastName() + "," + customer.getAddress());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}