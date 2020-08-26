package com.tcs.fullstack.employee.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.jdbc.CallableStatement;
import com.tcs.fullstack.employee.model.Employee;

@Component
public class EmployeeService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Integer authendicateEmployee(String loginName, String password, ModelMap model) {
		model.put("emp_name", loginName);
		// return loginName.equals("Ganapathi") & password.equals("ganapathi");
		String SQL = "select emp_id from emp_login where login_name='" + loginName + "' and password='" + password
				+ "'";
		Integer empId = 0;
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL);

		for (Map<String, Object> row : rows) {
			empId = (Integer) row.get("emp_id");
		}

		System.out.println("Retrieved employee Id : " + empId);
		if (null != empId && empId > 0) {
			model.put("emp_id", empId);
			return empId;
		}

		return null;
	}

	public List<Employee> retrieveEmployeeById(String empId, ModelMap model) {
		List<Employee> employeeList = null;
		try {

			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("FIND_EMPLOYEE_BY_ID");

			Map<String, Object> inParamMap = new HashMap<String, Object>();
			inParamMap.put("emp_id_in", empId);
			SqlParameterSource in = new MapSqlParameterSource(inParamMap);

			Map<String, Object> rows = simpleJdbcCall.execute(in);
			ArrayList<Employee> empSet = new ArrayList<Employee>();

			ArrayList arrayList = new ArrayList();
			arrayList = (ArrayList) rows.get("#result-set-1");
			Map resultMap = (Map) arrayList.get(0);
			Employee emp = new Employee();
			emp.setEmp_id(resultMap.get("emp_id").toString());
			emp.setEmp_name(resultMap.get("emp_name").toString());
			emp.setEmp_address(resultMap.get("emp_address").toString());
			emp.setEmp_role(resultMap.get("emp_role").toString());
			emp.setDoj(resultMap.get("doj").toString());
			emp.setBank_name(resultMap.get("bank_name").toString());
			emp.setAccount_no(resultMap.get("account_no").toString());
			emp.setYear_month(resultMap.get("year_month").toString());
			emp.setGross_salary(Float.parseFloat(resultMap.get("gross_salary").toString()));
			emp.setNet_salary(Float.parseFloat(resultMap.get("net_salary").toString()));
			emp.setTax_component(Float.parseFloat(resultMap.get("tax_component").toString()));
			emp.setIfscCode(resultMap.get("ifsc_code").toString());
			empSet.add(emp);

			model.put("employeesList", empSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeList;
	}
}
