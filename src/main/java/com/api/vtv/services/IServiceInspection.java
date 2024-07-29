package com.api.vtv.services;

import com.api.vtv.dto.InputInspectionDTO;

import com.api.vtv.dto.OutputInspectionDTO;
import com.api.vtv.entity.Inspection;
import com.api.vtv.entity.Inspector;

import java.util.List;
import java.util.Optional;


public interface IServiceInspection {
    public List<InputInspectionDTO> getAllInspection();
    public Optional<InputInspectionDTO> getInspectionById(Integer id);
    public String createInspection(OutputInspectionDTO inspection);
    public String updateInspection(Integer id, Inspection inspectionUpdated) throws Exception;
    public String deleteInspection(Integer id) throws Exception;
}
