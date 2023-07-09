package com.shishodia.basic.presentation;
import java.util.Scanner;
import com.shishodia.basic.Dao.EmployeeDao1;
import com.shishodia.basic.Dao.EmployeeDaoImpl1;
import com.shishodia.basic.entity.Employee;

public class EmployeeManagementDao 
{
	public static void main(String[] args) 
	{
		EmployeeLayer employeeLayer = new EmployeeLayerImpl();
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
				employeeLayer.addRecord();
				break;
				
			case 2:
				employeeLayer.findRecord();
				break;
				
			case 3:
				employeeLayer.deleteRecord();
				break;
				
			case 4:
				employeeLayer.updateRecord();
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