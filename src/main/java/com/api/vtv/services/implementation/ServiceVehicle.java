package com.api.vtv.services.implementation;

import com.api.vtv.dto.VehicleDTO;
import com.api.vtv.entity.Vehicle;
import com.api.vtv.mapper.VehicleMapper;
import com.api.vtv.repository.IRepositoryVehicle;
import com.api.vtv.services.IServiceVehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceVehicle implements IServiceVehicle {

    @Autowired
    private IRepositoryVehicle repository;
    @Autowired
    private VehicleMapper mapper;

    @Override
    public List<VehicleDTO> getAllVehicle() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<VehicleDTO> getVechicleById(Integer id) {
        return repository.findById(id).map(mapper::toDTO);
    }

    @Override
    public String createVehicle(Vehicle vehicle) {
        repository.save(vehicle);
        return "Vehicle created";
    }

    @Override
    public String updateVehicle(Integer id, Vehicle vehicleUpdated) throws Exception {
        Vehicle vehicle = repository.findById(id)
                .orElseThrow(()-> new Exception("Vehicle not found"));
         repository.save(vehicleUpdated);
        return "Vehicle updated";
    }

    @Override
    public String deleteVehicle(Integer id) throws Exception {
        Vehicle vehicle = repository.findById(id)
                .orElseThrow(()-> new Exception("Vehicle not found"));
        repository.deleteById(id);
        return "Vehicle deleted";
    }
}
