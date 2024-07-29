package com.api.vtv.dto;

import com.api.vtv.entity.Measuring;
import com.api.vtv.entity.Observation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OutputInspectionDTO {

    private Integer idInspection;
    private List<Measuring> measurings;
    private List<Observation> observations;
    private String domainVehicle;
    private String dniInspector;
}
