package peaksoft.house.models;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import peaksoft.house.enums.OrderStatus;



import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @ToString.Exclude
    private Customer customer;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private Address PointA;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private Address PointB;

    @Column(name = "dateTime")
    private LocalDateTime date;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @ToString.Exclude
    private Supplier supplier;

    @Column(name = "price")
    private int price;

    @Column(name = "status")
    private OrderStatus status;

    public Order(LocalDateTime date, int price, OrderStatus status, Address addressA, Address addressB) {

        this.date = date;
        this.price = price;
        this.status = status;
        this.PointA=addressA;
        this.PointB=addressB;
    }
}
