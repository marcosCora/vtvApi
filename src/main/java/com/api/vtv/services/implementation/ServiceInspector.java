package com.api.vtv.services.implementation;

import com.api.vtv.dto.InspectorDTO;
import com.api.vtv.dto.OwnerDTO;
import com.api.vtv.entity.Inspector;
import com.api.vtv.entity.OwnerVehicle;
import com.api.vtv.mapper.InspectorMapper;
import com.api.vtv.repository.IRepositoryInspector;
import com.api.vtv.services.IServiceInspector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceInspector implements IServiceInspector {

    @Autowired
    private IRepositoryInspector repository;
    @Autowired
    private InspectorMapper mapper;

    @Override
    public List<InspectorDTO> getAllInspectors() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<InspectorDTO> getInspectorById(Integer id) {
        return repository.findById(id).map(mapper::toDTO);
    }

    @Override
    public String createInspector(Inspector inspector) {
        repository.save(inspector);
        return "Inspector created";
    }

    @Override
    public String createInspectors(List<Inspector> inspector) {
        repository.saveAll(inspector);
        return "Inspector created";
    }

    @Override
    public String updateInspector(Integer id, Inspector inspectorUptdated) throws Exception {
        Inspector inspector = repository.findById(id).
                orElseThrow(() -> new Exception("Inspector not found"));
        repository.save(inspectorUptdated);
        return "Inspector updated";
    }

    @Override
    public String deleteInspector(Integer id) throws Exception {
        repository.findById(id).
                orElseThrow(() -> new Exception("Inspector not found"));
        repository.deleteById(id);
        return "Inspector deleted";
    }

    @Override
    public Inspector getInspectorByDni(String dni) throws Exception{
        Optional<Integer> inspectorOptional = repository.searchInspectorByDni(dni);
        Inspector inspector = new Inspector();
        inspector.setIdPerson((Integer) inspectorOptional.orElseThrow(()->
                new Exception("Inspector not found")));
        return inspector;
    }
}
