package com.shishodia.basic.presentation;

import java.util.Scanner;

import com.shishodia.basic.Dao.EmployeeDao1;
import com.shishodia.basic.Dao.EmployeeDaoImpl1;
import com.shishodia.basic.entity.Employee;

public class EmployeeLayerImpl implements EmployeeLayer {

	Integer empNo;
	String empName;
	Double empSal;
	Employee employee = new Employee();
	EmployeeDao1 employeeDao1=	 new EmployeeDaoImpl1();
	Scanner scanner = new Scanner(System.in);
	
	@Override
	public void addRecord() {

		System.out.println("Enter the no:");
		empNo = scanner.nextInt();
		System.out.println("Enter the name:");
		empName = scanner.next();
		System.out.println("Enter the salary:");
		empSal = scanner.nextDouble();
		employee.setEmpNo(empNo);
		employee.setEmpName(empName);
		employee.setEmpSal(empSal);
		String count = employeeDao1.addRecord(employee);
		System.out.println(count+ " ");

	}

	@Override
	public void findRecord() {
		System.out.println("Enter the no:");
		empNo = scanner.nextInt();
		employee = employeeDao1.findRecord(empNo);
		if(employee==null) {
			System.out.println("Object not found");
		}
		else 
		{
			System.out.println("No is :" +employee.getEmpNo());
			System.out.println("Name is :" +employee.getEmpName());
			System.out.println("Salary is :" +employee.getEmpSal());
	   }
		
	}

	@Override
	public void deleteRecord() {
		System.out.println("Enter the no:");
		empNo = scanner.nextInt();
		String s = employeeDao1.deleteRecord(empNo);
		System.out.println(s);
		
	}

	@Override
	public void updateRecord() {
		System.out.println("Enter the no:");
		empNo = scanner.nextInt();
		employee = employeeDao1.findRecord(empNo);
		if(employee==null) 
		{
			System.out.println("Object not found");
		}
		else 
		{
			System.out.println("Enter employee name:");
			empName = scanner.next();
			System.out.println("Enter employee salary:");
			empSal = scanner.nextDouble();
			employee.setEmpName(empName);
			employee.setEmpSal(empSal);
			String emp = employeeDao1.updateRecord(employee);
			System.out.println(emp);
		}
		
	}

}
