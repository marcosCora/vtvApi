package com.api.vtv.repository;

import com.api.vtv.entity.Inspector;
import com.sun.jdi.IntegerValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRepositoryInspector extends JpaRepository<Inspector, Integer> {

    @Query(value = "SELECT persons.id_person FROM persons WHERE persons.dni = :dni", nativeQuery = true)
    public Optional<Integer> searchInspectorByDni(@Param("dni") String dni);

}
