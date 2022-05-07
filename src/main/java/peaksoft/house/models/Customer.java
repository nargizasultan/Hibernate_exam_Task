package peaksoft.house.models;

import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Customer  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone_number")
    private long phoneNumber;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Address address;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy ="customer", fetch = FetchType.EAGER )
    private List<Order> orders=new ArrayList<>();

    public Customer(String fullName, long phoneNumber, Address address) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address=address;


    }
    public void addOrder(Order order){
        this.orders.add(order);
    }
}
