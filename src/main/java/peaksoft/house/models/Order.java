package peaksoft.house.models;

import jakarta.persistence.*;
import lombok.Data;
import peaksoft.house.enums.Order_Status;

import java.time.LocalDate;

@Data
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
    private Order_Status status;

}
