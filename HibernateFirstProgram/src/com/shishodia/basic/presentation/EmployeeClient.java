package com.shishodia.basic.presentation;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import com.shishodia.basic.entity.Employee;

public class EmployeeClient 
{
	public static void main(String[] args) 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("raj");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Employee employee = new Employee();
		employee.setEmpNo(194);
		employee.setEmpName("Arpita");
		employee.setEmpSal(291900.99);
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		System.out.println("save object");
		entityManager.close();
		entityManagerFactory.close();
	}
}
