package com.api.vtv.services;

import com.api.vtv.entity.Inspection;
import com.api.vtv.entity.Inspector;
import com.api.vtv.entity.OwnerVehicle;

import java.util.List;

public interface IServiceInspector {
    public List<Inspector> getAllInspectors();
    public Inspector getInspectorById(Integer id);
    public Inspector createInspector(Inspector inspector);
    public Inspector updateInspector(Integer id, Inspector inspector);
    public void deleteInspector(Integer id);
}
