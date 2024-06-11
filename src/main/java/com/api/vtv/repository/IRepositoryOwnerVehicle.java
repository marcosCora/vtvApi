package com.api.vtv.repository;

import com.api.vtv.entity.OwnerVehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryOwnerVehicle extends JpaRepository<OwnerVehicle, Integer> {
}
