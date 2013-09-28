<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="userProfileDetailsBean"
	class="com.metricstream.suggestionbox.beans.modelview.UserProfileDetailsBean"
	scope="session" />
<jsp:setProperty name="userProfileDetailsBean" property="*" />

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Suggestions</title>
<link href="static/css/tabs.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="static/js/autocomplete.js"></script>
<script type="text/javascript" src="static/js/thirdparty/json2.js"></script>
<script type="text/javascript" src="static/js/utilities/AJAXHandler.js"></script>
<script type="text/javascript" src="static/js/MySpaceMain.js"></script>
</head>

<body>
	<jsp:include page="SuggestionBoxHeader.jsp" />
	<br>
	<hr style="border: #48f solid 3px">

	<jsp:include page="PrivilegesMenu.jsp">
		<jsp:param name="menu" value="MySuggestion" />
	</jsp:include>

	<hr style="border: #48f solid 3px">
	
	<jsp:include page="MySuggestionHeader.jsp" />

<div align="center">
<h1 style="color : blue">${message}</h1>
</div>
	<div id="myspacveCreateSuggestionId" align="center">

		<form:form action="MySuggestionAdd" method="post"
			modelAttribute="fileUpload" enctype="multipart/form-data">

			<h2 align="left" style="color: green; font-style: italic;">Post
				New Suggestions</h2>
			<table>
				<tr align="center" height="50px">
					<td align="left" style="width: 100px;"><label
						style="color: brown;">Subject</label></td>
					<td><input type="text" id="myspaceSuggestionTitleId"
						name="myspaceSuggestionTitle" style="width: 500px; height: 30px" /></td>
				</tr>

				<tr>
					<td valign="top" height="50px">Category</td>
					<td valign="top" height="50px"><select name="categoryDropdown"
						id="categoryDropdownId">
							<option value="Software" selected>Software</option>
							<option value="Hardware">Hardware</option>
							<option value="Administration">Administration</option>
							<option value="Facilities">Facilities</option>
					</select></td>
				</tr>

				<tr>
					<td align="left" style="width: 100px;"><label
						style="color: brown;">Suggestion</label></td>
					<td><textarea name="suggestion" rows="10" cols="70"
							style="resize: none"></textarea></td>
				</tr>

				<tr align="center" height="50px">
					<td align="left" style="width: 100px;"><label
						style="color: brown">Attachment</label></td>
					<td align="left"><form:input type="file" path="fileUpload"
							id="myspaceSuggestionAttachId" name="myspaceSuggestionAttach" /></td>
				</tr>

				<tr align="center" height="50px">
					<td></td>
					<td align="center"><input type="submit" style="color: purple;"
						id="myspaceSuggestionSubmitId" value="Submit My Suggestion"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>