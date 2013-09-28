<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Suggestion Box</title>
</head>
<body>
	<jsp:include page="SuggestionBoxHeader.jsp" />
	<br />
	<div id="separator" style="height: 20px;">
		<hr color="blue" style="height: 3px; background-color: blue">
	</div>
	<div align="center">
		<form action="LoginPage" method="post">
			<table
				style="color: red; background-color: #dedede; height: 150px; width: 400px;">
				<tr
					style="color: red; background-color: #dedede; height: 50px; width: 400px;">
					<td align="right">User Name</td>
					<td align="left"><input type="text" name="userName"
						id="userNameId" style="height: 30px; width: 250px;"></td>
				</tr>
				<tr>
					<td align="right">Password</td>
					<td align="left"><input type="password" name="password"
						id="passwordId" style="height: 30px; width: 250px;"></td>
				</tr>
				<tr>
					<td></td>
					<td align="center"><input type="submit" name="login"
						id="loginId" value="Login"></td>
				</tr>
			</table>
		</form>

	</div>
</body>
</html>

