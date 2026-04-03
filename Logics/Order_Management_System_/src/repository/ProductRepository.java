package repository;

import exception.ProductNotFoundException;
import model.product.Product;

import java.util.*;

public class ProductRepository implements Repository<Product> {

    Map<String, Product> productMap = new HashMap<>();

    @Override
    public void save(Product product) {
        productMap.put(product.getProductId(), product);
    }

    @Override
    public Optional<Product> findById(String id) {
        return Optional.ofNullable(productMap.get(id));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void delete(String id) {
        if (!productMap.containsKey(id)) {
            throw new ProductNotFoundException(id);
        }
        productMap.remove(id);
    }

    // DSA: Heap — top N expensive orders using PriorityQueue
    public List<Product> getTopNExpensiveProducts(int n) {
        PriorityQueue<Product> maxHeap = new PriorityQueue<>(
                (a,b) -> Double.compare(
                        b.getFinalPrice(),
                        a.getFinalPrice()
                )
        );
        maxHeap.addAll(productMap.values());

        List<Product> result = new ArrayList<>();
        for (int i=0; i<n && !maxHeap.isEmpty(); i++) {
            result.add(maxHeap.poll());
        }

        return result;
    }
}
