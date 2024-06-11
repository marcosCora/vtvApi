package com.api.vtv.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "OwnerVehicles")
@PrimaryKeyJoinColumn(referencedColumnName = "fk_person")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OwnerVehicle extends Person{

    @OneToMany(mappedBy = "owner")
    @JsonIgnoreProperties(value = "owner")
    private List<Vehicle> vehicles;
    private String typeOwner;
}
