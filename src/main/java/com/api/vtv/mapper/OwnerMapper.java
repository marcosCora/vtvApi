package com.api.vtv.mapper;

import com.api.vtv.dto.OwnerDTO;
import com.api.vtv.entity.OwnerVehicle;

import org.springframework.stereotype.Component;


@Component
public class OwnerMapper {

    public OwnerDTO toDTO(OwnerVehicle owner){
        return new OwnerDTO(owner.getIdPerson(), owner.getName(), owner.getLastName(),
                            owner.getDni(), owner.getAddress(), owner.getPhone(), owner.getTypeOwner());
    }

    public OwnerVehicle toEntity(OwnerDTO ownerDto){
        OwnerVehicle owner = new OwnerVehicle();
        owner.setIdPerson(ownerDto.getIdPerson());
        owner.setName(ownerDto.getName());
        owner.setLastName(ownerDto.getLastName());
        owner.setDni(ownerDto.getDni());
        owner.setPhone(ownerDto.getPhone());
        owner.setAddress(ownerDto.getAddress());
        owner.setTypeOwner(ownerDto.getTypeOwner());
        return owner;
    }
}
