package peaksoft.house.services;

import peaksoft.house.models.Customer;

import java.util.List;

/**
 * @author Beksultan
 */
public class CustomerService {

    public void save(Customer newCustomer) {
        // save a newCustomer to database
    }

    public void update(Long customerId, Customer newCustomer) {
        // update customer with id = :customerId to newCustomer
    }

    public List<Customer> findAll() {
        // return all customers from database
        return null;
    }

    public Customer findById(Long customerId) {
        // find customer with id = :customerId from database and return it
        return null;
    }

    public void deleteById(Long customerId) {
        // delete customer from database
    }
}
