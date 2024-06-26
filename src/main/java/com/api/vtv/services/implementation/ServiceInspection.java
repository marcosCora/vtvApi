package com.api.vtv.services.implementation;

import com.api.vtv.dto.InspectionDTO;
import com.api.vtv.entity.Inspection;
import com.api.vtv.mapper.InspectionMapper;
import com.api.vtv.repository.IRepositoryInspection;
import com.api.vtv.services.IServiceInspection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceInspection implements IServiceInspection {

    @Autowired
    private IRepositoryInspection repository;
    @Autowired
    private InspectionMapper mapper;

    @Override
    public List<InspectionDTO> getAllInspection() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<Inspection> getAllInspectionNotDto() {
        return repository.findAll();
    }

    @Override
    public Optional<InspectionDTO> getInspectionById(Integer id) {
        return repository.findById(id).map(mapper::toDTO);
    }

    @Override
    public String createInspection(Inspection inspection) {
        repository.save(inspection);
        //crear resultado
        return "Inspection created";

    }

    @Override
    public String updateInspection(Integer id, Inspection inspectionUpdated) throws Exception {
        Inspection inspection = repository.findById(id)
                .orElseThrow(() -> new Exception("Inspection not found"));
        repository.save(inspectionUpdated);
        return "Inspection updated";
    }

    @Override
    public String deleteInspection(Integer id) throws Exception{
        repository.findById(id)
                .orElseThrow(() -> new Exception("Inspection not found"));
        repository.deleteById(id);
        return "Inspection deleted";
    }


}
