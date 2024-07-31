package com.api.vtv.repository;

import com.api.vtv.entity.Vehicle;
import lombok.Data;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Repository
public interface IRepositoryVehicle extends JpaRepository<Vehicle, Integer> {

    @Query(value = "SELECT vehicles.id_vehicle FROM vehicles WHERE vehicles.domain = :domain", nativeQuery = true)
    public Optional<Integer> searchVehicleByDomain(@Param("domain") String domain);

    @Modifying
    @Query(value = "UPDATE vehicles SET expiration_vtv = ?1 WHERE vehicles.id_vehicle = ?2", nativeQuery = true)
    public int setFechaExpiration(@Param("expiration_vtv") LocalDate expiration_vtv, @Param("id_vehicle") Integer id_vehicle);

}
