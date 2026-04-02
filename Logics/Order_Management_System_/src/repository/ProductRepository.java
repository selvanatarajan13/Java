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
}
