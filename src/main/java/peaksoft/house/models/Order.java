package peaksoft.house.models;

import jakarta.persistence.*;
import lombok.Data;
import peaksoft.house.enums.OrderStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "dateTime")
    private LocalDateTime date;

    @Column(name = "price")
    private int price;

    @Column(name = "status")
    private OrderStatus status;

}
