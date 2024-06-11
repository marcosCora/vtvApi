package com.api.vtv.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "measurings")
@PrimaryKeyJoinColumn(referencedColumnName = "fk_control")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Measuring {
    private String typeMeasuring;
}
