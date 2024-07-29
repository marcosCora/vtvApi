package com.api.vtv.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InputInspectionDTO {

    private Integer idInspection;
    private LocalDate dateInspection;
    private String result;
    private String domainVehicle;
    private String dniInspector;
}
