package com.api.vtv.mapper;

import com.api.vtv.dto.VehicleDTO;
import com.api.vtv.entity.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapper {

    public VehicleDTO toDTO(Vehicle vehicle){
        return new VehicleDTO(vehicle.getIdVehicle(), vehicle.getBrand(), vehicle.getModel(),
                    vehicle.getDomain(), vehicle.getExpirationVtv());
    }

    public Vehicle toEntity(VehicleDTO dto){
        Vehicle vehicle = new Vehicle();
        vehicle.setIdVehicle(dto.getIdVehicle());
        vehicle.setBrand(dto.getBrand());
        vehicle.setModel(dto.getModel());
        vehicle.setDomain(dto.getDomain());
        vehicle.setExpirationVtv(dto.getExpirationVtv());
        return vehicle;
    }

}
