public class Main {
    public static void main(String[] args) {
        // Przykład użycia kolejki zamówień
        OrderQueue orderQueue = new OrderQueue();


        Order order1 = new Order("1", "Myszka", 2);
        orderQueue.enqueue(order1);

        Order order2 = new Order("2", "Klawiatura", 1);
        orderQueue.enqueue(order2);

        Order order3 = new Order("3", "Monitor", 6);
        orderQueue.enqueue(order3);

        Order order4 = new Order("4", "Procesor", 4);
        orderQueue.enqueue(order4);

        //orderQueue.displayAllOrders();

        Order processedOrder = orderQueue.dequeue();
        System.out.println("Processed Order: " + processedOrder.getOrderId() + ", " + processedOrder.getProductName());

        Order nextOrder = orderQueue.peek();
        System.out.println("Next Order: " + nextOrder.getOrderId() + ", " + nextOrder.getProductName());

        Order processedOrder2 = orderQueue.dequeue();
        System.out.println("Processed Order: " + processedOrder2.getOrderId() + ", " + processedOrder2.getProductName());

        Order nextOrder2 = orderQueue.peek();
        System.out.println("Next Order: " + nextOrder2.getOrderId() + ", " + nextOrder2.getProductName());

        Order processedOrder3 = orderQueue.dequeue();
        System.out.println("Processed Order: " + processedOrder3.getOrderId() + ", " + processedOrder3.getProductName());

        Order nextOrder3 = orderQueue.peek();
        System.out.println("Next Order: " + nextOrder3.getOrderId() + ", " + nextOrder3.getProductName());

        // Przykład zarządzania produktami
        ProductManager productManager = new ProductManager();

        //Product product1 = new Product("1", "Myszka", 149.99, 20);
        //productManager.addProduct(product1);
        //productManager.deleteProduct("1");


        // Przykład zarządzania klientami
        CustomerManager customerManager = new CustomerManager();

        //Customer customer2 = new Customer("2", "konrad", "Kowalski", "Rzeszow");
        //customerManager.addCustomer(customer2);
        //customerManager.deleteCustomer("2");
        //customerManager.displayAllCustomers();



    }
}