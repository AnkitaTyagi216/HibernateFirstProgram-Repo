package com.shishodia.basic.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.shishodia.basic.entity.Employee;

public class EmployeeDaoImpl1 implements EmployeeDao1 
{
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("raj");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	Employee employee;
	@Override
	public String addRecord(Employee employee) 
	{
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		return "record added";
	}
	@Override
	public Employee findRecord(Integer empNo) 
	{
		return entityManager.find(Employee.class, empNo);
	}
	@Override
	public String deleteRecord(Integer empNo) 
	{
		employee=new Employee();
		employee = entityManager.find(Employee.class, empNo);
		if(employee==null) {
			return "Object not found";
		}else {
			entityTransaction.begin();
			entityManager.remove(employee);
			entityTransaction.commit();
		}
		return "Object deleted";
	}
	@Override
	public String updateRecord(Employee employee) 
	{
		entityTransaction.begin();
		employee.setEmpName(employee.getEmpName());
		employee.setEmpSal(employee.getEmpSal());
		entityTransaction.commit();
		return "Object Updated";
	}
}
