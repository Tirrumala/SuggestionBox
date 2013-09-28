
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:useBean id="userProfileDetailsBean"
	class="com.metricstream.suggestionbox.beans.modelview.UserProfileDetailsBean"
	scope="session" />
<jsp:setProperty name="userProfileDetailsBean" property="*" />

<!DOCTYPE>
<html>
<head>
<title>Suggestion Box</title>
<link href="static/css/tabs.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="static/js/AdminMain.js"></script>

</head>
<body>
	<jsp:include page="SuggestionBoxHeader.jsp" />
	<br />
	<hr style="border: #48f solid 3px">

	<jsp:include page="PrivilegesMenu.jsp">
		<jsp:param name="menu" value="Admin" />
	</jsp:include>

	<hr style="border: #48f solid 3px">

	<div align="center" style="height: 50px; background-color: #cecece">
		<table>
			<tr>
				<td style="width: 40px;"><input type="image"
					id="adminAddRolesId" style="height: 30px; width: 30px;"
					src="static/icons/Add.png" onclick="myspaceCreateNew();" /></td>
				<td style="width: 200px;"><label for="adminAddRolesId">Add
						User Roles</label></td>
				<td style="width: 40px;"><input type="image"
					id="searchUserRolesId" style="height: 30px; width: 30px;"
					src="static/icons/List_View.png" onclick="myspaceViewList();" /></td>
				<td style="width: 200px;"><label for="searchUserRolesId">Search</label></td>
			</tr>
		</table>
	</div>

	<div id="crudRolesId" align="left">
		<h3>User Category and Role</h3>
		<p>Can add or delete or update the User Roles and Categories</p>

		<table>
			<tr>
				<td valign="top">UserName</td>
				<td valign="top"><input type="text" name="userName"
					id="userNameId" style="width: 300px" /></td>
			</tr>
			<tr>
				<td valign="top">Categories</td>
				<td valign="top"><select name="selectCategory"
					id="selectCategoryId" size="5" style="width: 300px"
					multiple="multiple">
						<option value="Software" selected>Software</option>
						<option value="Hardware">Hardware</option>
						<option value="Administration">Administration</option>
						<option value="Facilities">Facilities</option>
				</select></td>
			</tr>
			<tr>
				<td valign="top">Roles</td>
				<td valign="top"><select name="selectRole" id="selectRoleId"
					size="5" style="width: 300px" multiple="multiple">
						<option value="Approver" selected>Approver</option>
						<option value="Admin">Admin</option>
				</select></td>
			</tr>
			<tr>
				<td valign="top"></td>
				<td valign="top"><input type="button" value="Add"
					onclick="javascript:addOrUpdateRole('Add');" /> <input
					type="button" value="Update"
					onclick="javascript:addOrUpdateRole('Update');" /> <input
					type="button" value="Delete"
					onclick="javascript:addOrUpdateRole('Delete');" /></td>

			</tr>
		</table>
	</div>
	<div id="searchRolesId">
		<h3>Search User privileges</h3>
		<p>Search by User or Roles or Categories.</p>
		<br>
		<div id="publicSuggSearchId" align="center" style="height: 100px">
			<br>
			<table>
				<tr>
					<td><label style="color: blue">Search</label></td>
					<td><input type="text" id="publicSuggSearchTextId"
						style="height: 30px; width: 500px;"
						onkeydown="createDiv1('publicSuggSearchTextId','ac1');"><br>
						<div id="ac1"></div></td>
					<td><input type="image" id="publicSuggImageSearchId"
						style="height: 30px; width: 30px;"
						src="static/icons/Search_Near.png" onclick="publicSuggSearch();" /></td>
				</tr>
			</table>
		</div>

		<h2 style="color: orange;">Search Results</h2>
		<hr>
		<div style="height: 30px; background-color: #dedede">
			<table id="publicSuggSuggestionListTableHeaderId">
				<tr>
					<td align="center" style="width: 150px;"><label>User
							Name </label></td>
					<td align="center" style="width: 150px;"><label>Category</label></td>
					<td align="center" style="width: 150px;"><label>Roles</label></td>
				</tr>
			</table>
		</div>

		<table id="publicSuggSuggestionListTableId">

		</table>
	</div>
</body>
</html>

