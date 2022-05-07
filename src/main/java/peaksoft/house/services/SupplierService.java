package peaksoft.house.services;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import peaksoft.house.configuration.Configuration;
import peaksoft.house.enums.OrderStatus;
import peaksoft.house.enums.SupplierStatus;
import peaksoft.house.models.Order;
import peaksoft.house.models.Supplier;


import java.util.List;

/**
 * @author Beksultan
 */
public class SupplierService {
    // create objects of repositories

    public void save(Supplier newSupplier) {
        // write your code here
        EntityManagerFactory entityManagerFactory = Configuration.createEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(newSupplier);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void update(Long supplierId, Supplier newSupplier) {
        // write your code here
        // you should find supplier with id = :supplierId
        // and replace with newSupplier
        EntityManagerFactory entityManagerFactory= Configuration.createEntityManagerFactory();
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("update Supplier set status=:status, fullName=:fullName, phoneNumber=:phoneNumber, orders=:orders  where id=:id")
                .setParameter("status", newSupplier.getOrders()).setParameter("phoneNumber", newSupplier.getPhoneNumber()).setParameter("fullName", newSupplier.getFullName())
                .setParameter("orders", newSupplier.getOrders()).setParameter("id", supplierId).executeUpdate();

        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public List<Supplier> findAllSuppliers() {
        EntityManagerFactory entityManagerFactory=Configuration.createEntityManagerFactory();
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Supplier> suppliers = entityManager.createQuery("select s from Supplier s", Supplier.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return suppliers;
    }

    public Supplier findById(Long supplierId) {
        // write your code here
        // you should return supplier with id = :supplierId
        EntityManagerFactory entityManagerFactory=Configuration.createEntityManagerFactory();
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.find(Supplier.class, supplierId);
        entityManager.getTransaction().commit();
        entityManager.close();
        return null;
    }

    public void getOrder(Long supplierId) {
        // give free order to supplier with id = :supplierId
        EntityManagerFactory entityManagerFactory= Configuration.createEntityManagerFactory();
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Order order = entityManager.find(Order.class, supplierId);
        order.setStatus(OrderStatus.FREE);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void deleteById(Long supplierId) {
        // write your code here
        // you should delete supplier with id = :supplierId
        EntityManagerFactory entityManagerFactory= Configuration.createEntityManagerFactory();
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Supplier.class, supplierId));
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public List<Order> findAllOrders(Long supplierId) {
        // find all supplier's delivered orders
        OrderStatus orderStatus=OrderStatus.DELIVERED;
        EntityManagerFactory entityManagerFactory=Configuration.createEntityManagerFactory();
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Order> orders = entityManager.createQuery("select o from Order  o join Supplier s on o.status=:orderStatus and s.id=:supID", Order.class).setParameter("orderStatus", orderStatus).setParameter("supID", supplierId).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return orders;

    }

    public List<Supplier> findAllBusySuppliers() {
        EntityManagerFactory entityManagerFactory= Configuration.createEntityManagerFactory();
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        SupplierStatus supplierStatus = SupplierStatus.BUSY;
        List<Supplier> resultList = entityManager.createQuery("select s from Supplier  s where s.status =:status", Supplier.class).setParameter("status", supplierStatus).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return resultList;
    }
}
