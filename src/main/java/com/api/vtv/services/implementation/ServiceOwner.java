package com.api.vtv.services.implementation;

import com.api.vtv.dto.OwnerDTO;
import com.api.vtv.entity.OwnerVehicle;
import com.api.vtv.mapper.OwnerMapper;
import com.api.vtv.repository.IRepositoryOwnerVehicle;
import com.api.vtv.services.IServiceOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
public class ServiceOwner implements IServiceOwner {

    @Autowired
    private IRepositoryOwnerVehicle repository;
    @Autowired
    private OwnerMapper mapper;

    @Override
    public List<OwnerDTO> getAllOwner() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<OwnerDTO> getOwnerById(Integer id)  {
        return  repository.findById(id).map(mapper::toDTO);
    }

    @Override
    public String createOwner(OwnerVehicle owner) {
        repository.save(owner);
        return "Owner created";
    }

    @Override
    public String createOwners(List<OwnerVehicle> owner) {
        repository.saveAll(owner);
        return "Owner created";
    }

    @Override
    public String updateOwner(Integer id, OwnerVehicle ownerUpdated) throws Exception{
        OwnerVehicle ownerVehicle = repository.findById(id).
                                    orElseThrow(() -> new Exception("Owner not found"));
        repository.save(ownerUpdated);
        return "Owner updated";
    }

    @Override
    public String deleteOwner(Integer id) throws Exception{
        repository.findById(id).
                orElseThrow(() -> new Exception("Owner not found"));
        repository.deleteById(id);
        return "Owner deleted";
    }
}
