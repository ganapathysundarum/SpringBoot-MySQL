<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<h2>Welcome ${emp_name}!! - employee id : <a href="/list-employee?employeeId=${emp_id}">${emp_id}!</a> 
	<br> You are now authendicated !</h2>	
</div>
<%@ include file="common/footer.jspf"%>