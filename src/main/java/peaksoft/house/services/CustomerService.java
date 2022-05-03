package peaksoft.house.services;

import peaksoft.house.enums.OrderStatus;
import peaksoft.house.models.Customer;
import peaksoft.house.models.Order;

import java.util.List;

/**
 * @author Beksultan
 */
public class CustomerService {

    public void save(Customer newCustomer) {
        // save a newCustomer to database
    }

    public void makeAnOrder(Long customerId, Order newOrder) {
        // find customer and give order to customer
    }

    public void cancelOrder(Long customerId, Long orderId) {
        // find customer with :customerId and find customer's order with id = :orderId
        // and setOrder status CANCELED
    }

    public void update(Long customerId, Customer newCustomer) {
        // update customer with id = :customerId to newCustomer
    }

    public List<Order> findAllOrders(Long customerId, OrderStatus orderStatus) {
        // find all orders by :orderStatus where customer id = :customerId
        return null;
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
