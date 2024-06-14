package com.api.vtv.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "inspector")
@PrimaryKeyJoinColumn(referencedColumnName = "idPerson")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Inspector extends Person{
    private String specialty;
    @OneToMany(mappedBy = "inspector")
    @JsonIgnoreProperties(value = "inspector")
    private List<Inspection> inspections;
}
