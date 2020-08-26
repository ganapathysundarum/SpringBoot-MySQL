package com.tcs.fullstack.employee.model;

public class Employee {

	public String emp_id;
	public String emp_name;
	public String emp_address;
	public String emp_role;
	public String doj;
	public String bank_name;
	public String account_no;
	public String year_month;
	public float gross_salary;
	public float net_salary;
	public float tax_component;
	public String login_name;
	public String password;
	public String ifscCode;
	
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_address() {
		return emp_address;
	}
	public void setEmp_address(String emp_address) {
		this.emp_address = emp_address;
	}
	public String getEmp_role() {
		return emp_role;
	}
	public void setEmp_role(String emp_role) {
		this.emp_role = emp_role;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getAccount_no() {
		return account_no;
	}
	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}
	public String getYear_month() {
		return year_month;
	}
	public void setYear_month(String year_month) {
		this.year_month = year_month;
	}
	public float getGross_salary() {
		return gross_salary;
	}
	public void setGross_salary(float gross_salary) {
		this.gross_salary = gross_salary;
	}
	public float getNet_salary() {
		return net_salary;
	}
	public void setNet_salary(float net_salary) {
		this.net_salary = net_salary;
	}
	public float getTax_component() {
		return tax_component;
	}
	public void setTax_component(float tax_component) {
		this.tax_component = tax_component;
	}
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_address=" + emp_address + ", emp_role="
				+ emp_role + ", doj=" + doj + ", bank_name=" + bank_name + ", account_no=" + account_no
				+ ", year_month=" + year_month + ", gross_salary=" + gross_salary + ", net_salary=" + net_salary
				+ ", tax_component=" + tax_component + ", login_name=" + login_name + ", password=" + password
				+ ", ifscCode=" + ifscCode + "]";
	}
	
	
	
}
