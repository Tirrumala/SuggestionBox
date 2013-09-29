<jsp:useBean id="userProfileDetailsBean"
	class="com.opensource.suggestionbox.beans.modelview.UserProfileDetailsBean"
	scope="session" />
<jsp:setProperty name="userProfileDetailsBean" property="*" />

<%
	String menu = request.getParameter("menu");
	int role = 0;
	int result = 0;
	%>

<ol id="toc">

	<%
		System.out.println("menu " + menu);
			if (menu.equalsIgnoreCase("Overview")) {
		%>
	<li><a class="current" href="Overview"><span>Overview</span></a></li>
	<%
			} else {
		%>
	<li><a href="Overview"><span>Overview</span></a></li>
	<%
			}
		%>

	<%
			if (menu.equalsIgnoreCase("PublicSuggestion")) {
		%>
	<li><a class="current" href="PublicSuggestionViewList"><span>Public
				Suggestions</span></a></li>
	<%
			} else {
		%>
	<li><a href="PublicSuggestionViewList"><span>Public Suggestions</span></a></li>
	<%
			}
		%>

	<%
		System.out.println("true menu " + menu.equalsIgnoreCase("MySuggestion"));
			if (menu.equalsIgnoreCase("MySuggestion")) {
				
		%>
	<li><a class="current" href="MySuggestionAdd"><span>My Suggestions</span></a></li>
	<%
			} else {
		%>
	<li><a href="MySuggestionAdd"><span>My Suggestions</span></a></li>
	<%
			}
		%>

	<%
			role = userProfileDetailsBean.getUserRole();
			/*     out.println("role ="+ role);*/
			result = role & 0X0001;
			if (menu.equalsIgnoreCase("Approve") && result == 1) {
		%>
	<li><a class="current" href="Approve"><span>Approve</span></a></li>
	<%
			} else if (result == 1) {
		%>
	<li><a href="Approve"><span>Approve</span></a></li>
	<%
			}
		%>

	<%
			role = userProfileDetailsBean.getUserRole();
			/*     out.println("role ="+ role);*/
			result = role & 0X0002;
			if (menu.equalsIgnoreCase("Admin") && result == 2) {
		%>
	<li><a class="current" href="Admin"><span>Admin</span></a></li>
	<%
			} else if (result == 2) {
		%>
	<li><a href="Admin"><span>Admin</span></a></li>
	<%
			}
		%>

	<%
			if (menu.equalsIgnoreCase("ContactUs")) {
		%>
	<li><a class="current" href="ContactUs"><span>Contact
				Us</span></a></li>
	<%
			} else {
		%>
	<li><a href="ContactUs"><span>Contact Us</span></a></li>
	<%
			}
		%>

</ol>

