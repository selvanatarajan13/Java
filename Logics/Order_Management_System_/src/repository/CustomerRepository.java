package repository;

import exception.CustomerAlreadyExist;
import exception.CustomerNotFounException;
import model.Customer;

import java.util.*;

public class CustomerRepository implements Repository<Customer> {

    private Map<String, Customer> customerMap = new HashMap<>();

    @Override
    public void save(Customer customer) {
        if (customerMap.containsKey(customer.getCustomerID())) {
            throw new CustomerAlreadyExist();
        }
        customerMap.put(customer.getCustomerID(), customer);
    }

    @Override
    public Optional<Customer> findById(String id) {
        return Optional.ofNullable(customerMap.get(id));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public void delete(String id) {
        if (!customerMap.containsKey(id)) {
            throw new CustomerNotFounException(id);
        }
        customerMap.remove(id);
    }
}
