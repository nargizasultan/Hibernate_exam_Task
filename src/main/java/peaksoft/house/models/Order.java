package peaksoft.house.models;

import jakarta.persistence.*;
import lombok.Data;
import peaksoft.house.enums.OrderStatus;

import java.time.LocalDate;

@Entity
public class Order {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "price")
    private int price;

    @Column(name = "status")
    private OrderStatus status;

}
