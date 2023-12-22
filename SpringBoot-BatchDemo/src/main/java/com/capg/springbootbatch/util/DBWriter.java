package com.capg.springbootbatch.util;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capg.springbootbatch.model.Employee;
import com.capg.springbootbatch.repo.EmployeeRepo;

@Component
public class DBWriter implements ItemWriter<Employee> {

	@Autowired
	EmployeeRepo repo;

	@Override
	public void write(List<? extends Employee> items) throws Exception {
		// TODO Auto-generated method stub

		for (Employee employee : items) {

			repo.save(employee);
		}

	}

}
