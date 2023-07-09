package com.shishodia.basic.Dao;

import com.shishodia.basic.entity.Employee;

public interface EmployeeDao1 
{
	String addRecord(Employee employee);
	Employee findRecord(Integer employee);
	String deleteRecord(Integer empNo);
	String updateRecord(Employee employee);
	
}
