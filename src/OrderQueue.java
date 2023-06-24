import java.util.LinkedList;
import java.util.Queue;
public class OrderQueue {
    private Queue<Order> queue;

    public OrderQueue() {
        queue = new LinkedList<>();
    }

    public void enqueue(Order order) {
        queue.add(order);
    }

    public Order dequeue() {
        return queue.poll();
    }

    public Order peek() {
        return queue.peek();
    }

    public void removeOrder(Order order) {
        queue.remove(order);
    }

    public void displayAllOrders() {
        for (Order order : queue) {
            System.out.println("Order ID: " + order.getOrderId());
            System.out.println("Product Name: " + order.getProductName());
            System.out.println("Quantity: " + order.getQuantity());
            System.out.println("-------------------------");
        }
    }


}
