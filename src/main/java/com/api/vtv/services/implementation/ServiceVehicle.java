package com.api.vtv.services.implementation;

import com.api.vtv.dto.VehicleDTO;
import com.api.vtv.entity.OwnerVehicle;
import com.api.vtv.entity.Vehicle;
import com.api.vtv.mapper.VehicleMapper;
import com.api.vtv.repository.IRepositoryOwnerVehicle;
import com.api.vtv.repository.IRepositoryVehicle;
import com.api.vtv.services.IServiceVehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ServiceVehicle implements IServiceVehicle {

    @Autowired
    private IRepositoryVehicle repository;
    @Autowired
    private VehicleMapper mapper;
    @Autowired
    private IRepositoryOwnerVehicle repositoryOwner;

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
    public String createVehicle(VehicleDTO vehicleDto) throws Exception{

        Optional<Integer> idOwner = repositoryOwner.searchOwnerByDni(vehicleDto.getDniOwner());
        OwnerVehicle owner = new OwnerVehicle();
        owner.setIdPerson((Integer) idOwner.orElseThrow(()-> new Exception("Owner not found")));

        Vehicle vehicle = mapper.toEntity(vehicleDto);
        vehicle.setOwner(owner);

        repository.save(vehicle);
        return "Vehicle created";
    }

    @Override
    public String createVehicles(List<Vehicle> vehicles) {
        repository.saveAll(vehicles);
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

    @Override
    public  void setFechaExpiration(Integer id){
        LocalDate fecha = LocalDate.now().plusYears(1);
        int response = repository.setFechaExpiration(fecha, id);
        //System.out.printf(response);
    }

}
