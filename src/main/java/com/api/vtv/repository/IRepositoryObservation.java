package com.api.vtv.repository;

import com.api.vtv.entity.Observation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryObservation extends JpaRepository<Observation, Integer> {
}
