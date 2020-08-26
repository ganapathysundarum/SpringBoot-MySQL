<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

	<div class="container">
	<h2>Welcome  ${emp_name}! </a> 	
		<table class="table table-striped">
			<caption>Logged In Employee details are</caption>
			<thead>
				<tr class="bg-primary">
					<th>Employee ID</th>
					<th>Name</th>
					<th>Address</th>
					<th>Role</th>
					<th>DOJ</th>
					<th>Bank</th>
					<th>Account No</th>
					<th>Year Month</th>
					<th>Gross Salary</th>
					<th>Net Salary</th>
					<th>Tax Component</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${employeesList}" var="emp">
					<tr>
						<td>${emp.emp_id}</td>
						<td>${emp.emp_name}</td>
						<td>${emp.emp_address}</td>
						<td>${emp.emp_role}</td>
						<td>${emp.doj}</td>						
						<td>${emp.bank_name}</td>
						<td>${emp.account_no}</td>
						<td>${emp.year_month}</td>
						<td>${emp.gross_salary}</td>
						<td>${emp.net_salary}</td>
						<td>${emp.tax_component}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
<%@ include file="common/footer.jspf"%>
