package com.shishodia.basic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "employee")
public class Employee 
{
	@Id
	@Column(name="eno")
	private Integer empNo;
	@Column(name="ename")
	private String empName;
	@Column(name="esal")
	private Double empSal;
	
	public Integer getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Double getEmpSal() {
		return empSal;
	}
	public void setEmpSal(Double empSal) {
		this.empSal = empSal;
	}
}
