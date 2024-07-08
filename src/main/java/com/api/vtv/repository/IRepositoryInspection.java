package com.api.vtv.repository;

import com.api.vtv.entity.Inspection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryInspection extends JpaRepository<Inspection, Integer> {
}
