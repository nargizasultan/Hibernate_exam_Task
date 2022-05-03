package peaksoft.house.services;

import com.sun.org.apache.xpath.internal.operations.Or;
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
    }

    public void update(Long supplierId, Supplier newSupplier) {
        // write your code here
        // you should find supplier with id = :supplierId
        // and replace with newSupplier
    }

    public List<Supplier> findAllSuppliers() {
        // write your code here
        // you should find all suppliers and return them
        return null;
    }

    public Supplier findById(Long supplierId) {
        // write your code here
        // you should return supplier with id = :supplierId
        return null;
    }

    public void getOrder(Long supplierId) {
        // give free order to supplier with id = :supplierId
    }

    public void deleteById(Long supplierId) {
        // write your code here
        // you should delete supplier with id = :supplierId
    }

    public List<Order> findAllOrders(Long supplierId) {
        // find all supplier's delivered orders
        return null;
    }

    public List<Supplier> findAllBusySuppliers() {
        // find all busy suppliers
        return null;
    }
}
