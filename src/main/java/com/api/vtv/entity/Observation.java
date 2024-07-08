package com.api.vtv.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "observations")
@PrimaryKeyJoinColumn(referencedColumnName = "idControl")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Observation extends Control{
    private String componentInspected;
}
