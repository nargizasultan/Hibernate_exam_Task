package peaksoft.house.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import peaksoft.house.configuration.Configuration;
import peaksoft.house.models.Order;
import java.util.List;

/**
 * @author Beksultan
 */
public class OrderService {

    public void save(Order newOrder) {

        EntityManagerFactory entityManagerFactory = Configuration.createEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(newOrder);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void update(Long orderId, Order newOrder) {
        // update order with id = orderId
        EntityManagerFactory entityManagerFactory = Configuration.createEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Order order = entityManager.find(Order.class, orderId);
        Query q=entityManager.createQuery("update Order set Order.customer=:customer ,Order.PointA=:adrressA, Order.PointB=:adrressB , Order.date=:date, Order.supplier=:suppliyer, Order.price=:price, Order.status=:status where id=:i");
        q.setParameter("i",orderId );
        q.setParameter("customer", newOrder.getCustomer());
        q.setParameter("PointA",newOrder.getPointA() );
        q.setParameter("PointB", newOrder.getPointB());
        q.setParameter("date", newOrder.getDate());
        q.setParameter("supplier", newOrder.getSupplier());
        q.setParameter("price", newOrder.getPrice());
        q.setParameter("status", newOrder.getStatus());
        q.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();


    }

    public List<Order> findAllOrders() {
        // find all orders
        EntityManagerFactory entityManagerFactory=Configuration.createEntityManagerFactory();
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Order> orders = entityManager.createQuery("select o from Order  o", Order.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return orders;
    }

    public Order findById(Long orderId) {
        // find order by id from database and return it!
        EntityManagerFactory entityManagerFactory=Configuration.createEntityManagerFactory();
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Order order = entityManager.createQuery("select o from Order  o", Order.class).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return order;

    }

    public void deleteById(Long orderId) {
        // delete order from database where id = :orderId
        EntityManagerFactory entityManagerFactory=Configuration.createEntityManagerFactory();
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Order.class, orderId));
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
