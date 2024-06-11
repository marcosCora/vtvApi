package com.api.vtv.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity(name = "vehicles")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVehicle;
    private String brand;
    private String model;
    private String domain;
    private Date expirationVtv;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_person",
                referencedColumnName = "idPerson")
    @JsonIgnoreProperties(value = "vehicles")
    private OwnerVehicle owner;

}
