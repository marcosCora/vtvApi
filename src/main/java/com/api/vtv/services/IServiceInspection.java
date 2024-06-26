package com.api.vtv.services;

import com.api.vtv.dto.InspectionDTO;
import com.api.vtv.entity.Inspection;
import com.api.vtv.entity.Inspector;

import java.util.List;
import java.util.Optional;


public interface IServiceInspection {
    public List<InspectionDTO> getAllInspection();
    public Optional<InspectionDTO> getInspectionById(Integer id);
    public String createInspection(Inspection inspection);
    public String updateInspection(Integer id, Inspection inspectionUpdated) throws Exception;
    public String deleteInspection(Integer id) throws Exception;
    public List<Inspection> getAllInspectionNotDto();
}
