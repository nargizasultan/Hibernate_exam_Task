package peaksoft.house.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone_number")
    private long phoneNumber;

}
