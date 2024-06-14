package com.api.vtv.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity(name = "inspections")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Inspection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInspection;
    private Date dateInspection;
    private String Result;
    @OneToMany
    private List<Observation> observations;
    @OneToMany
    private List<Measuring> measurings;
    @OneToOne
    private Vehicle vehicles;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_person",
            referencedColumnName = "idPerson")
    @JsonIgnoreProperties(value = "inspections")
    private Inspector inspector;

}
