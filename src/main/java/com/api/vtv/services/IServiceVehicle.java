package com.api.vtv.services;

import com.api.vtv.dto.VehicleDTO;
import com.api.vtv.entity.Vehicle;
import org.apache.catalina.LifecycleState;

import java.util.List;
import java.util.Optional;

public interface IServiceVehicle {

    public List<VehicleDTO> getAllVehicle();
    public Optional<VehicleDTO> getVechicleById(Integer id);
    public String createVehicle(Vehicle vehicle);
    public String updateVehicle(Integer id, Vehicle vehicleUpdated) throws Exception;
    public String deleteVehicle(Integer id) throws Exception;
    

}
