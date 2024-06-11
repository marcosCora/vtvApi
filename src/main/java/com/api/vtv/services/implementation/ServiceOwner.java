package com.api.vtv.services.implementation;

import com.api.vtv.entity.OwnerVehicle;
import com.api.vtv.services.IServiceOwner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceOwner implements IServiceOwner {


    @Override
    public List<OwnerVehicle> getAllOwner() {
        return List.of();
    }

    @Override
    public OwnerVehicle getOwnerById(Integer id) {
        return null;
    }

    @Override
    public OwnerVehicle createOwner(OwnerVehicle owner) {
        return null;
    }

    @Override
    public OwnerVehicle updateOwner(Integer id, OwnerVehicle ownerUpdated) {
        return null;
    }

    @Override
    public void deleteOwner(Integer id) {

    }
}
