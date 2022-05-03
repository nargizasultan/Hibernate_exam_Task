package peaksoft.house;

import peaksoft.house.enums.OrderStatus;
import peaksoft.house.services.CustomerService;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        CustomerService customerService = new CustomerService();

        customerService.findAllOrders(1L, OrderStatus.DELIVERED);
        System.out.println( "Hello World!" );
    }
}
