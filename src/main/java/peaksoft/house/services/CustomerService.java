package peaksoft.house.services;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

import peaksoft.house.configuration.Configuration;
import peaksoft.house.enums.OrderStatus;
import peaksoft.house.models.Customer;
import peaksoft.house.models.Order;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Beksultan
 */
public class CustomerService {

    public void save(Customer newCustomer) {
        // save a newCustomer to database

        EntityManagerFactory entityManagerFactory = Configuration.createEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(newCustomer);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void makeAnOrder(Long customerId, Order newOrder) {
        // find customer and give order to customer
        EntityManagerFactory entityManagerFactory = Configuration.createEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Customer customer = entityManager.find(Customer.class, customerId);
        customer.addOrder(newOrder);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public void cancelOrder(Long customerId, Long orderId) {

        // find customer with :customerId and find customer's order with id = :orderId
        // and setOrder status CANCELED
        EntityManagerFactory entityManagerFactory = Configuration.createEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Customer customer = entityManager.find(Customer.class, customerId);
        Order order = entityManager.find(Order.class, orderId);
        order.setStatus(OrderStatus.CANCELED);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public void update(Long customerId, Customer newCustomer) {
        // update customer with id = :customerId to newCustomer
        EntityManagerFactory entityManagerFactory = Configuration.createEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("update Customer set Customer.address =:address, Customer .fullName=:fullName, Customer .orders=:orders, Customer .phoneNumber=:phoneNumber where id=:i");
        query.setParameter("i", customerId);
        query.setParameter("address", newCustomer.getAddress());
        query.setParameter("fullName", newCustomer.getFullName());
        query.setParameter("orders", newCustomer.getOrders());
        query.setParameter("phoneNumber", newCustomer.getPhoneNumber());
        query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        
    }

    public List<Order> findAllOrders(Long customerId, OrderStatus orderStatus) {

        // find all orders by :orderStatus where customer id = :customerId
        EntityManagerFactory entityManagerFactory = Configuration.createEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Order> status = entityManager.createQuery("select o from Order o join Customer c on c.id =?1 and o.status=:status", Order.class).setParameter(1, customerId).setParameter("status", orderStatus).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return status;

    }

    public List<Customer> findAll() {
        // return all customers from database
        EntityManagerFactory entityManagerFactory = Configuration.createEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Customer> customers = entityManager.createQuery("select c from Customer  c ", Customer.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return customers;
    }

    public Customer findById(Long customerId) {
        // find customer with id = :customerId from database and return it
        EntityManagerFactory entityManagerFactory = Configuration.createEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Customer customer = entityManager.find(Customer.class, customerId);
        entityManager.getTransaction().commit();
        entityManager.close();
        return customer;
    }

    public void deleteById(Long customerId) {
        // delete customer from database
        EntityManagerFactory entityManagerFactory = Configuration.createEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Customer.class, customerId));
        entityManager.getTransaction().commit();
        entityManager.close();


    }
}
