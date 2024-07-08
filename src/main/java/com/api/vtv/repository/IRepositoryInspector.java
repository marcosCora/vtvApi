package com.api.vtv.repository;

import com.api.vtv.entity.Inspector;
import com.sun.jdi.IntegerValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryInspector extends JpaRepository<Inspector, Integer> {
}
