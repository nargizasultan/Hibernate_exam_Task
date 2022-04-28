package peaksoft.house.models;

import jakarta.persistence.*;
import lombok.Data;
import peaksoft.house.enums.Supplier_Status;

@Data
@Entity
public class Supplier {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone_number")
    private int phoneNumber;
    
    @Column(name = "status")
    private Supplier_Status status;

}
