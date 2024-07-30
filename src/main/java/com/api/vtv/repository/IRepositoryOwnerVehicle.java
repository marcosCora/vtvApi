package com.api.vtv.repository;

import com.api.vtv.entity.OwnerVehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRepositoryOwnerVehicle extends JpaRepository<OwnerVehicle, Integer> {
    @Query(value = "SELECT persons.id_person FROM persons WHERE persons.dni = :dni", nativeQuery = true)
    public Optional<Integer> searchOwnerByDni(@Param("dni") String dni);
}
