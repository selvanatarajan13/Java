package repository;

import exception.DuplicateOrderException;
import exception.OrderNotFoundException;
import model.Order;

import java.util.*;
import java.util.stream.Collectors;

public class OrderRepository implements Repository<Order> {

    // DSA: HashMap for O(1) lookup instead of O(n) linear search
    private Map<String, Order> orderMap = new HashMap<>();

    // DSA: Stack for undo
    private Stack<Order> undoStack = new Stack<>();

    // DSA: Queue for a waiting list
    private Queue<Order> waitingQueue = new LinkedList<>();

    @Override
    public void save(Order order) {
        if (orderMap.containsKey(order.getOrderId())) {
            throw new DuplicateOrderException(order.getOrderId());
        }
        orderMap.put(order.getOrderId(), order);
        undoStack.push(order);
    }

    @Override
    public Optional<Order> findById(String id) {
        return Optional.ofNullable(orderMap.get(id));
    }

    @Override
    public List<Order> findAll() {
        return new ArrayList<>(orderMap.values());
    }

    @Override
    public void delete(String id) {
        if (!orderMap.containsKey(id)) {
            throw new OrderNotFoundException(id);
        }
        orderMap.remove(id);
    }

    // DSA: Stack — undo last-placed order
    public Optional<Order> undoLastOrder() {
        if (undoStack.isEmpty()) return Optional.empty();
        Order lastOrder = undoStack.pop();
        orderMap.remove(lastOrder.getOrderId());
        return Optional.of(lastOrder);
    }

    // DSA: Queue — waiting list when out of stock
    public void addToWaitingList(Order order) {
        waitingQueue.offer(order);
        System.out.println("Order " + order.getOrderId() + " added to waiting list.");
    }

    public Optional<Order> processNextWaiting() {
        return Optional.ofNullable(waitingQueue.poll());
    }

    // DSA: Heap — top N expensive orders using PriorityQueue
    public List<Order> getTopNExpensive(int n) {
        PriorityQueue<Order> maxHeap = new PriorityQueue<>(
                (a,b) -> Double.compare(
                        b.getProduct().getFinalPrice(),
                        a.getProduct().getFinalPrice()
                )
        );
        maxHeap.addAll(orderMap.values());

        List<Order> result = new ArrayList<>();
        for (int i=0; i<n && !maxHeap.isEmpty(); i++) {
            result.add(maxHeap.poll());
        }

        return result;
    }

    // DSA: Sorting — sort by final price using Comparator
    public List<Order> getSortedByPrice() {
        return orderMap.values().stream()
                .sorted(Comparator.comparingDouble(o -> o.getProduct().getFinalPrice()))
                .collect(Collectors.toList());
    }

    // DSA: Stream groupingBy — group orders by status
    public Map<String, List<Order>> groupByStatus() {
        return orderMap.values().stream()
                .collect(Collectors.groupingBy(o -> o.getOrderStatus().label()));
    }

    // DSA: Stream filter — find orders by customer ID
    public List<Order> findByCustomerId(String customerId) {
        return orderMap.values().stream()
                .filter(o -> o.getCustomer().getCustomerID().equals(customerId))
                .collect(Collectors.toList());
    }
}
