package com.shishodia.basic.presentation;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import com.shishodia.basic.entity.Employee;

public class EmployeeClient1 
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
			System.out.println("No is :" +employee.getEmpNo());
			System.out.println("Name is :" +employee.getEmpName());
			System.out.println("Salary is :" +employee.getEmpSal());
		}
		entityManager.close();
		entityManagerFactory.close();
		scanner.close();
	}

}
