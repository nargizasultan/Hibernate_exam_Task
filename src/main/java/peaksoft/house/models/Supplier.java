package peaksoft.house.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import peaksoft.house.enums.SupplierStatus;

@Entity
public class Supplier {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone_number")
    private int phoneNumber;
    
    @Column(name = "status")
    private SupplierStatus status;

}
