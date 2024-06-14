package com.api.vtv.services;

import com.api.vtv.dto.OwnerDTO;
import com.api.vtv.entity.OwnerVehicle;

import java.util.List;
import java.util.Optional;

public interface IServiceOwner {

    public List<OwnerDTO> getAllOwner();
    public Optional<OwnerDTO> getOwnerById(Integer id);
    public String createOwner(OwnerVehicle owner);
    public String  updateOwner(Integer id, OwnerVehicle ownerUpdated) throws Exception;
    public String deleteOwner(Integer id) throws Exception;

}
