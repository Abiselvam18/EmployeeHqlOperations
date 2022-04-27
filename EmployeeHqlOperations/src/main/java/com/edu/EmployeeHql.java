package com.edu;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hqlemp")
public class EmployeeHql {
@Id
private int eid;
private String name;
private float salary;
private String address;
private int deptno;

public int getEid() {
	return eid;
}
public void setEid(int eid) {
	this.eid = eid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public float getSalary() {
	return salary;
}
public void setSalary(float salary) {
	this.salary = salary;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public int getDeptno() {
	return deptno;
}
public void setDeptno(int deptno) {
	this.deptno = deptno;
}

public EmployeeHql(int eid, String name, float salary, String address, int deptno) {
	super();
	this.eid = eid;
	this.name = name;
	this.salary = salary;
	this.address = address;
	this.deptno = deptno;
}

public EmployeeHql() {
	super();
}

@Override
public String toString() {
	return "EmployeeHql [eid=" + eid + ", name=" + name + ", salary=" + salary + ", address=" + address + ", deptno="
			+ deptno + "]";
}

}