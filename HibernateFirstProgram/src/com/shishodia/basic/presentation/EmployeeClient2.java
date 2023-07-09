package com.shishodia.basic.presentation;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.shishodia.basic.entity.Employee;

public class EmployeeClient2 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("raj");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		System.out.println("Enter the employee no:");
		Integer empNo = scanner.nextInt();
		
		Employee employee = entityManager.find(Employee.class,empNo);
		if(employee==null) {
			System.out.println("Employee record not found");
		}else {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(employee);
			entityTransaction.commit();
			System.out.println("Employee Object is Removed...");
		}
		entityManager.close();
		entityManagerFactory.close();
		scanner.close();
	}

}
