package com.api.vtv.services.implementation;

import com.api.vtv.entity.Inspector;
import com.api.vtv.services.IServiceInspector;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceInspector implements IServiceInspector {
    @Override
    public List<Inspector> getAllInspectors() {
        return List.of();
    }

    @Override
    public Inspector getInspectorById(Integer id) {
        return null;
    }

    @Override
    public Inspector createInspector(Inspector inspector) {
        return null;
    }

    @Override
    public Inspector updateInspector(Integer id, Inspector inspector) {
        return null;
    }

    @Override
    public void deleteInspector(Integer id) {

    }
}
