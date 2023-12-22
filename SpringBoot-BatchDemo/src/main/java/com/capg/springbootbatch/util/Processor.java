package com.capg.springbootbatch.util;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.capg.springbootbatch.model.Employee;

@Component
public class Processor implements ItemProcessor<Employee, Employee>{

	@Override
	public Employee process(Employee emp) throws Exception {
		// TODO Auto-generated method stub
		emp.setEmployeeId(emp.getEmployeeId().concat("_FS"));
		return emp;
	}
	
	

}
