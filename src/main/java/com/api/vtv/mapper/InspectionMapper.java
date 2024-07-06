package com.api.vtv.mapper;

import com.api.vtv.dto.InspectionDTO;
import com.api.vtv.dto.InspectorDTO;
import com.api.vtv.entity.Inspection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InspectionMapper {

    @Autowired
    private InspectorMapper inspectorMapper;

    public InspectionDTO toDTO(Inspection inspection){
        //InspectorDTO inspectorDTO = inspectorMapper.toDTO(inspection.getInspector());
        return new InspectionDTO(inspection.getIdInspection(), inspection.getDateInspection(),
                inspection.getResult(), inspection.getVehicles().getDomain(), inspection.getInspector().getDni());
    }

    public Inspection toEntity(InspectionDTO inspectionDTO){

        Inspection inspection = new Inspection();
        inspection.setIdInspection(inspectionDTO.getIdInspection());
        inspection.setDateInspection(inspectionDTO.getDateInspection());
        inspection.setResult(inspectionDTO.getResult());
        //inspection.setVehicles(inspectionDTO.getVehicle());
        //inspection.setInspector(inspectorMapper.toEntity(inspectionDTO.getInspector()));
        return inspection;
    }



}
