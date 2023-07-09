package com.shishodia.basic.presentation;
import java.util.Scanner;
import com.shishodia.basic.Dao.EmployeeDao1;
import com.shishodia.basic.Dao.EmployeeDaoImpl1;
import com.shishodia.basic.entity.Employee;

public class EmployeeManagementDao 
{
	public static void main(String[] args) 
	{
		Integer empNo;
		String empName;
		Double empSal;
		Employee employee = new Employee();
		EmployeeDao1 employeeDao1=null;
		employeeDao1 = new EmployeeDaoImpl1();
		while(true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("\t\t*****************************");
			System.out.println("\t\t EMPLOYEE MANAGEMENT SYSTEM");
			System.out.println("\t\t*****************************");
			System.out.println("\t1. Add    the Record");
			System.out.println("\t2. Find the Record");
			System.out.println("\t3. Delete the Record");
			System.out.println("\t4. Update   the Record");
			System.out.println("\t5. Exit   from Record");
			System.out.println();
			System.out.println("Enter the Option:");
			Integer option = scanner.nextInt();
			switch(option)
			{
			case 1:
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
				break;
				
			case 2:
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
				break;
				
			case 3:
				System.out.println("Enter the no:");
				empNo = scanner.nextInt();
				String s = employeeDao1.deleteRecord(empNo);
				System.out.println(s);
				break;
				
			case 4:
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