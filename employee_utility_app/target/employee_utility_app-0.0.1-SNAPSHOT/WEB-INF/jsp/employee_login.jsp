<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="class="jumbotron d-flexalign-items-center">
	<div class="container" class="card card-block w-25">
		<form method="post" action="/login">
			<table align="center">
				<tr>
					<td>Name :</td>
					<td><input type="text" name="loginname" class="form-control" /></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><input type="password" name="password"
						class="form-control" /></td>
				</tr>
				<tr>
					<td colspan=2 align="center"><input type="submit"
						class="btn btn-success" /></td>
				</tr>
				<tr>
					<td colspan=2><font color="red" align="center">${errorMessage}</font></td>
				</tr>
			</table>
		</form>
	</div>
</div>
<%@ include file="common/footer.jspf"%>
