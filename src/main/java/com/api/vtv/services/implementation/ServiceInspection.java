package com.api.vtv.services.implementation;

import com.api.vtv.dto.InputInspectionDTO;

import com.api.vtv.dto.OutputInspectionDTO;
import com.api.vtv.entity.*;
import com.api.vtv.mapper.InspectionMapper;
import com.api.vtv.repository.IRepositoryInspection;
import com.api.vtv.repository.IRepositoryInspector;
import com.api.vtv.repository.IRepositoryVehicle;
import com.api.vtv.services.IServiceInspection;
import com.api.vtv.services.IServiceInspector;
import com.api.vtv.services.IServiceVehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceInspection implements IServiceInspection {

    @Autowired
    private IRepositoryInspection repository;
    @Autowired
    private InspectionMapper mapper;
    @Autowired
    private ServiceVehicle serviceVehicle;
    @Autowired
    private IServiceInspector serviceInspector;

    @Override
    public List<InputInspectionDTO> getAllInspection() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<InputInspectionDTO> getInspectionById(Integer id) {
        return repository.findById(id).map(mapper::toDTO);
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

    @Override
    public String createInspection(OutputInspectionDTO inspectionDTO) throws Exception {
        //obtengo de la base de datos el id del inspector
        Inspector inspector = serviceInspector.getInspectorByDni(inspectionDTO.getDniInspector());

        //obtengo de la base de datos el id del vehicle
        Vehicle vehicle = serviceVehicle.getVehicleByDomain(inspectionDTO.getDomainVehicle());

        Inspection inspection = new Inspection();
        inspection.setDateInspection(LocalDate.now());

        inspection.setVehicles(vehicle);
        inspection.setInspector(inspector);

        inspection.setMeasurings(inspectionDTO.getMeasurings());
        inspection.setObservations(inspectionDTO.getObservations());
        inspection = calculatedResult(inspection);

        repository.save(inspection);

        return "Inspection created";

    }

    public Inspection calculatedResult(Inspection inspection){

        String rtaObservation = calculateResulControls(inspection.getObservations());
        String rtaMeasuring = calculateResulControls(inspection.getMeasurings());
        if(rtaMeasuring.equalsIgnoreCase("APTO") && rtaObservation.equalsIgnoreCase("APTO")){
            inspection.setResult("APTO");
            serviceVehicle.setFechaExpiration(inspection.getVehicles().getIdVehicle());
        }else if(rtaMeasuring.equalsIgnoreCase("RECHAZADO") || rtaObservation.equalsIgnoreCase("RECHAZADO")){
            inspection.setResult("RECHAZADO");
        }else {
            inspection.setResult("CONDICIONAL");
        }
        return inspection;
    }

    public String calculateResulControls(List<? extends Control> control){
        String rta = "Rechazado";
        for (Control c : control){
            if(c.getResult().equalsIgnoreCase("APTO")){
                rta = "APTO";
            } else if (c.getResult().equalsIgnoreCase("CONDICIONAL")) {
                rta = "CONDICIONAL";
            }else{
                rta = "RECHAZADO";
            }
        }
        return rta;
    }


}
