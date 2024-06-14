package com.api.vtv.dto;

import com.api.vtv.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InspectionDTO {

    private Integer idInspection;
    private Date dateInspection;
    private String result;
    private Vehicle vehicle;
    private InspectorDTO inspector;

}
