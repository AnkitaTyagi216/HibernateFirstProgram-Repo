package com.shishodia.basic.presentation;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import com.shishodia.basic.entity.Employee;

public class EmployeeManagementSystem 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("raj");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Employee employee = new Employee();
		Integer empNo;
		String empName;
		Double empSal;
		while(true)
		{
			System.out.println("\t\t****************************");
			System.out.println("\t\t EMPLOYEE MANAGEMENT SYSTEM");
			System.out.println("\t\t****************************");
			System.out.println();
			System.out.println("\t1. ADD THE RECORD");
			System.out.println("\t2. FIND THE RECORD");
			System.out.println("\t3. DELETE THE RECORD");
			System.out.println("\t4. UPDATE THE RECORD");
			System.out.println("\t5. EXIT");
			System.out.println();
			System.out.println("ENTER THE OPTION");
			
			Integer option = scanner.nextInt();
			switch(option)
			{
			case 1:
				System.out.println("ENTER THE NUMBER:");
				empNo = scanner.nextInt();
				System.out.println("ENTER THE NAME:");
				empName = scanner.next();
				System.out.println("ENTER THE SALARY:");
				empSal = scanner.nextDouble();
				employee.setEmpNo(empNo);
				employee.setEmpName(empName);
				employee.setEmpSal(empSal);
				entityTransaction.begin();
				entityManager.persist(employee);
				entityTransaction.commit();
				System.out.println("Object Saved...");
				break;
				
			case 2:
				System.out.println("Enter the employee no:");
				empNo = scanner.nextInt();
				employee = entityManager.find(Employee.class,empNo);
				if(employee==null) {
					System.out.println("Object not found");
				}
				else 
				{
					System.out.println("No is :" +employee.getEmpNo());
					System.out.println("Name is :" +employee.getEmpName());
					System.out.println("Salary is :" +employee.getEmpSal());
			   }
				break;
				
			case 3:
				System.out.println("Enter the employee no:");
				empNo = scanner.nextInt();
				employee = entityManager.find(Employee.class, empNo);
				if(employee==null) {
					System.out.println("Object not found");
				}else {
					entityTransaction = entityManager.getTransaction();
					entityTransaction.begin();
					entityManager.remove(employee);
					entityTransaction.commit();
					System.out.println("Object removed...");
				}
				break;
				
			case 4:
				System.out.println("Enter employee no:");
				empNo = scanner.nextInt();
				employee = entityManager.find(Employee.class, empNo);
				if(employee==null) {
					System.out.println("Object not found");
				}else {
					System.out.println("Enter employee name:");
					empName = scanner.next();
					System.out.println("Enter employee salary:");
					empSal = scanner.nextDouble();
					entityTransaction = entityManager.getTransaction();
					entityTransaction.begin();
					employee.setEmpName(empName);
					employee.setEmpSal(empSal);
					entityTransaction.commit();
					System.out.println("Object updated...");
				}
				break;
				
			case 5:
				System.out.println("User wants to exit");
				System.exit(0);
				break;
				
			default:
				System.out.println("Invalid option");
				break;
			}
		}
	}
}