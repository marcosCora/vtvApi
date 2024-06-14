package com.api.vtv.services;

import com.api.vtv.dto.InspectorDTO;
import com.api.vtv.dto.OwnerDTO;
import com.api.vtv.entity.Inspection;
import com.api.vtv.entity.Inspector;
import com.api.vtv.entity.OwnerVehicle;

import java.util.List;
import java.util.Optional;

public interface IServiceInspector {
    public List<InspectorDTO> getAllInspectors();
    public Optional<InspectorDTO> getInspectorById(Integer id);
    public String createInspector(Inspector inspector);
    public String updateInspector(Integer id, Inspector inspectorUptdated) throws Exception;
    public String deleteInspector(Integer id) throws Exception;

}
