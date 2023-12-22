package com.capg.springbootbatch.model;

/*
 *– @Entity annotation indicates that the class is a persistent Java class.
– @Table annotation provides the table that maps this entity.
– @Id annotation is for the primary key.
– @GeneratedValue annotation is used to define generation strategy for the primary key. GenerationType.AUTO means Auto Increment field.
– @Column annotation is used to define the column in database that maps annotated field.
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private long id;
	    @Column(name = "emp_id")
	    private String employeeId;
	    @Column(name = "first_name")
	    private String firstName;
	    @Column(name = "last_name")
	    private String lastName;
	    @Column(name = "email")
	    private String email;


}
