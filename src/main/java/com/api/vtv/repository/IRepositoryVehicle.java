package com.api.vtv.repository;

import com.api.vtv.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRepositoryVehicle extends JpaRepository<Vehicle, Integer> {

    @Query(value = "SELECT vehicles.id_vehicle FROM vehicles WHERE vehicles.domain = :domain", nativeQuery = true)
    public Optional<Integer> searchVehicleByDomain(@Param("domain") String domain);
}
