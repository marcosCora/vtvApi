package com.api.vtv.mapper;

import com.api.vtv.dto.InspectorDTO;
import com.api.vtv.entity.Inspector;
import org.springframework.stereotype.Component;

@Component
public class InspectorMapper {

    public InspectorDTO toDTO(Inspector inspector){
        return new InspectorDTO(inspector.getIdPerson(), inspector.getName(), inspector.getLastName(),
                inspector.getDni(), inspector.getAddress(), inspector.getPhone(), inspector.getSpecialty());
    }

    public Inspector toEntity(InspectorDTO inspectorDTO){
        Inspector inspector = new Inspector();
        inspector.setIdPerson(inspectorDTO.getIdPerson());
        inspector.setName(inspectorDTO.getName());
        inspector.setLastName(inspectorDTO.getLastName());
        inspector.setDni(inspectorDTO.getDni());
        inspector.setPhone(inspectorDTO.getPhone());
        inspector.setAddress(inspectorDTO.getAddress());
        inspector.setSpecialty(inspector.getSpecialty());
        return inspector;
    }
}
