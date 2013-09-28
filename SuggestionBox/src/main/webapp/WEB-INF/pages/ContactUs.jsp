
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
<script type="text/javascript" src="static/js/ContactUsMain.js"></script>

</head>
<body>
	<jsp:include page="SuggestionBoxHeader.jsp" />
	<br />
	<hr style="border: #48f solid 3px">

	<jsp:include page="PrivilegesMenu.jsp">
		<jsp:param name="menu" value="ContactUs" />
	</jsp:include>

	<hr style="border: #48f solid 3px">
	<div align="left">
		<h3>Contact Numbers</h3>
		<p>Please reach us through contact numbers : 1 800 2856 2890, 1
			800 2856 2891, 1 800 2856 2892</p>
	</div>
	<hr>
	<div align="left">
		<h3>Suggestion / Feedback</h3>
		<p>Please send your comments / suggestions / Feedback to Us.</p>
		<table>
			<tr>
				<td valign="top" height="50px">Subject</td>
				<td valign="top" height="50px"><input type="text"
					name="subject" id="subjectId" style="width: 350px" /></td>
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
				<td valign="top">Content</td>
				<td valign="top"><textarea id="contentId" rows="10" cols="50"
						style="resize: none"></textarea></td>
			</tr>
			<tr>
				<td valign="middle" align="center" height="50px"></td>
				<td valign="middle" align="center" height="50px"><input
					type="button" value="Send" onclick="javascript:sendFeedback();" /></td>

			</tr>
		</table>

	</div>
</body>
</html>

