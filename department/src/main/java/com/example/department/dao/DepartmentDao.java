package com.example.department.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.department.entity.DepartmentEntity;

@Repository
public interface DepartmentDao extends JpaRepository<DepartmentEntity, Long> {

}
