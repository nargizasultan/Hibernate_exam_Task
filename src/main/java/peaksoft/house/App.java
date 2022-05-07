package peaksoft.house;

import peaksoft.house.enums.OrderStatus;
import peaksoft.house.enums.SupplierStatus;
import peaksoft.house.models.Address;
import peaksoft.house.models.Customer;
import peaksoft.house.models.Order;
import peaksoft.house.models.Supplier;
import peaksoft.house.services.CustomerService;
import peaksoft.house.services.OrderService;
import peaksoft.house.services.SupplierService;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
        OrderService orderService = new OrderService();
        SupplierService supplierService = new SupplierService();

        Address address = new Address("Kyrgyzstan", "Bishkek", "October", "Tokombaeva 34");
        Address address1 = new Address("Kyrgyzstan", "Bishkek", "May1", "Beisheeva A2");
        Address address2 = new Address("Kyrgyzstan", "Bishkek", "Leninskiy", "51/4");
        Address address3 = new Address("Kyrgyzstan", "Bishkek", "Sverdlovskiy", "Jetibaev 45C");
        Address address4 = new Address("Kyrgyzstan", "Bishkek", "Sverdlovskiy", "Malaev 5");
        Address address5 = new Address("Kyrgyzstan", "Bishkek", "Sverdlovskiy", "Mir 341/A");
        Address address6 = new Address("Kyrgyzstan", "Bishkek", "Sverdlovskiy", "Nabrerezhnaya 234");
        Address address8 = new Address("Kyrgyzstan", "Bishkek", "Sverdlovskiy", "Isaev 765");

        Order order = new Order(LocalDateTime.now(), 700, OrderStatus.FREE, address, address8);
        Order order1 = new Order(LocalDateTime.now(), 900, OrderStatus.CANCELED, address1, address6);
        Order order2 = new Order(LocalDateTime.now(), 1000, OrderStatus.IN_PROGRESS, address2, address5);
        Order order3 = new Order(LocalDateTime.now(), 500, OrderStatus.IN_PROGRESS, address3, address4);

        Customer customer = new Customer("Nargiza", 706677560, address);
        Customer customer1 = new Customer("Nurisa", 706456567, address1);
//        Customer customer2 = new Customer("Nurzhan", 704897896, address2);
//        Customer customer3 = new Customer("Ulan", 702890567, address3);
//        Customer customer4 = new Customer("Mirbek", 702897867, address4);
//        Customer customer5 = new Customer("Nurlan", 702845567, address5);
//        Customer customer6 = new Customer("Azat", 702890345, address6);
//        Customer customer7 = new Customer("Azamat", 702898743, address8);



        Supplier supplier = new Supplier("Bektur", 708475432, SupplierStatus.FREE);
        Supplier supplier1 = new Supplier("Beka", 706457459, SupplierStatus.BUSY);
        Supplier supplier2 = new Supplier("Aman", 700678234, SupplierStatus.FREE);
        Supplier supplier3 = new Supplier("Amir", 707123047, SupplierStatus.BUSY);

//        customerService.save(customer);
//        customerService.save(customer1);



//        orderService.save(order);
//        orderService.save(order1);
//        orderService.save(order2);
//        orderService.save(order3);

//        supplierService.save(supplier);
//        supplierService.save(supplier1);
//        supplierService.save(supplier2);
//        supplierService.save(supplier3);
//        Customer customer11 = customer1;
//
//       Order order4=new Order(LocalDateTime.now(), 900,OrderStatus.FREE,  address, address1);
//
//       customer11.setOrders(List.of(order1, order4));
//       order4.setCustomer(customer11);
//       order1.setCustomer(customer11);
//       order1.setSupplier(supplier);
//       order4.setSupplier(supplier1);
//       customerService.save(customer11);


//       orderService.findAllOrders().forEach(System.out::println);
//        supplierService.findAllOrders(2L).forEach(System.out::println);
supplierService.findAllBusySuppliers().forEach(System.out::println);





    }
}
