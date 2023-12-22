package com.capg.springbootbatch.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.springbootbatch.model.Employee;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
