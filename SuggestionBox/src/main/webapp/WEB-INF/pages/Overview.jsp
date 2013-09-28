
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
		<jsp:param name="menu" value="Overview" />
	</jsp:include>

	<hr style="border: #48f solid 3px">
	<div align="left">
		<p>This portal provides you for submitting</p>

		<ul>
			<li>MetricStream Patents</li>
			<li>MetricStream Technical Papers as part of EDGE</li>
			<li>Suggestions or Creative ideas which benefits the
				Organization and also Employees</li>
		</ul>

		<p>Note:- This is only Suggestion box. Please donot use for
			complains or issues.</p>
	</div>
</body>
</html>

