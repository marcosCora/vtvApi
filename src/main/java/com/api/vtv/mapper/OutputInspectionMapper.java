package com.api.vtv.mapper;

import com.api.vtv.dto.OutputInspectionDTO;
import com.api.vtv.entity.Inspection;
import com.api.vtv.entity.Inspector;
import com.api.vtv.entity.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class OutputInspectionMapper {

    public Inspection toEntity(OutputInspectionDTO inspectionDTO, Inspector inspector, Vehicle vehicle){
        Inspection inspection = new Inspection();
        inspection.setObservations(inspectionDTO.getObservations());
        inspection.setMeasurings(inspectionDTO.getMeasurings());
        inspection.setInspector(inspector);
        inspection.setVehicles(vehicle);
        return inspection;
    }

}
