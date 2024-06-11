package com.api.vtv.repository;

import com.api.vtv.entity.Measuring;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryMeasuring extends JpaRepository<Measuring, Integer> {
}
