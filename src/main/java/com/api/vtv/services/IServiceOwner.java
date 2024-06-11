package com.api.vtv.services;

import com.api.vtv.entity.OwnerVehicle;

import java.util.List;

public interface IServiceOwner {

    public List<OwnerVehicle> getAllOwner();
    public OwnerVehicle getOwnerById(Integer id);
    public OwnerVehicle createOwner(OwnerVehicle owner);
    public OwnerVehicle updateOwner(Integer id, OwnerVehicle ownerUpdated);
    public void deleteOwner(Integer id);

}
