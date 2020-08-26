<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

	<div class="container">
	<h2>IFSC Code:  ${ifsc_code}! </a> 	
		<table class="table table-striped">
			<caption>Bank details based on IFSC code given...</caption>
			<thead>
				<tr class="bg-primary">
					<th>BANK</th>
					<th>IFSC</th>
					<th>BRANCH</th>
					<th>ADDRESS</th>
					<th>CONTACT</th>
					<th>CITY</th>
					<th>RTGS Supports?</th>
					<th>DISTRICT</th>
					<th>State</th>					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ifsc_list}" var="ifsc">
					<tr>
						<td>${ifsc.BANK}</td>
						<td>${ifsc.IFSC}</td>
						<td>${ifsc.BRANCH}</td>
						<td>${ifsc.ADDRESS}</td>
						<td>${ifsc.CONTACT}</td>						
						<td>${ifsc.CITY}</td>
						<td>${ifsc.RTGS}</td>
						<td>${ifsc.DISTRICT}</td>
						<td>${ifsc.STATE}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
<%@ include file="common/footer.jspf"%>
