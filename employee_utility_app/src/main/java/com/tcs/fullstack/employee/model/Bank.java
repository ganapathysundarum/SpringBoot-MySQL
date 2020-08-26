package com.tcs.fullstack.employee.model;

public class Bank {

	public String bankName;
	public String branch;
	public String address;
	public String city;
	public String ifscCode;
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	@Override
	public String toString() {
		return "Bank [bankName=" + bankName + ", branch=" + branch + ", address=" + address + ", city=" + city
				+ ", ifscCode=" + ifscCode + "]";
	}
	
	
}
