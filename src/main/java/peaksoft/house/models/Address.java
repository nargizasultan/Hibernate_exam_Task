package peaksoft.house.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "region")
    private String region;

    @Column(name = "street")
    private String street;

}
