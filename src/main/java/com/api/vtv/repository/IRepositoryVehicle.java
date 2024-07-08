package com.api.vtv.repository;

import com.api.vtv.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryVehicle extends JpaRepository<Vehicle, Integer> {
}
