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
<script type="text/javascript" src="static/js/SearchSuggestion.js"></script>
<script type="text/javascript" src="static/js/utilities/AJAXHandler.js"></script>

<script type="text/javascript">
	function createDiv1(item, divName) {
		/* var x = new Array(20);
		for ( var i = 0; i < 20; i++) {
			x[i] =  "Testing the sample search options for intuitive searchings....iowrequirqewiorqweowqerioqwerioqwerooweeer reeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee" + "Goto -> Page" + (i + 1); //This is like Feeling Lucky
		}

		createAutoCompleteSearchList(item, divName, x);
		
 */	
		showSearches(item, divName, null) ;
	}
</script>
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
	
	<div id="myspaceSuggestionListId">

		<div id="myspaceSearchId" align="center" style="height: 100px">
			<br> <br>

			<table>
				<tr>
					<td><label style="color: blue">Filter my suggestions</label></td>
					<td><input type="text" id="myspaceSearchTextId"
						style="height: 30px; width: 800px;" onfocus="initialize('myspaceSearchTextId','ac1');" onkeydown="keyDownHandler(event)" onkeyup ="keyUpHandler(event);"><br>
						<div id="ac1"></div></td>
					<td><input type="image" id="myspaceImageSearchId"
						style="height: 30px; width: 30px;"
						src="static/icons/Search_Near.png"  /></td>
				</tr>
				<tr>
					<td></td>
					<td><label>(Note:- Search by User Name, Category, title, Id )</label></td>
					<td></td>
				</tr>
			</table>
		</div>

		<h2 style="color: orange;">My Suggestions</h2>
		<hr>
		<div align="left" style="height: 30px;">
			<table>
				<tr>
					<td style="width: 20px;"><input type="image"
						id="myspaceImageDeleteId" style="height: 20px; width: 20px;"
						src="static/icons/Delete.png" onclick="mySugDeleteListItems();" /></td>
					<td style="width: 150px;"><label for="myspaceImageDeleteId">Delete</label></td>
					<td style="width: 150px;"></td>
					<td style="width: 150px;"></td>
					<td style="width: 150px;"></td>
					<td style="width: 150px;"></td>
					<td style="width: 30px;"><input type="button"
						id="myspacePrevButtonId" value="<"></td>
					<td align="center" style="width: 150px;"><label>1-25
							of 1000</label></td>
					<td style="width: 30px;"><input type="button"
						id="myspacePrevButtonId" value=">"></td>
				</tr>
			</table>
		</div>
		<hr>
		<div style="height: 30px; background-color: #dedede">
			<table id="myspaceSuggestionListTableHeaderId">
				<tr>
					<td align="center" style="width: 20px;"><input type="checkbox"
						id="suggestionItemIdHead"
						onchange="mySugSetCheckboxItems(document.getElementById('suggestionItemIdHead').checked);"></td>
					<td align="center" style="width: 150px;"><label>Suggestion
							Id</label></td>
					<td align="center" style="width: 150px;"><label>Category</label></td>
					<td align="center" style="width: 150px;"><label>Created
							On</label></td>
					<td align="center" style="width: 150px;"><label>Approval
							Level</label></td>
					<td align="center" style="width: 150px;"><label>Approval
							Status</label></td>
					<td align="center" style="width: 400px;"><label>Suggestion</label></td>
				</tr>
			</table>
		</div>

		<table id="myspaceSuggestionListTableId">
			<c:forEach items="${suggestionListWrapperBean.getSuggestionList()}"
				var="suggestionListVar">
				<tr>
					<td align="center" style="width: 20px;"><input type="checkbox"
						id="suggestionItemIdHead"
						onchange="mySugSetCheckboxItems(document.getElementById('suggestionItemIdHead').checked);"></td>
					<td align="center" style="width: 150px;"><a href="MySuggestionDescription?sugId=${suggestionListVar.getSuggestionId()}">${suggestionListVar.getSuggestionId()}</a></td>
					<td align="center" style="width: 150px;"><label>${suggestionListVar.getCategory()}</label></td>
					<td align="center" style="width: 150px;"><label>${suggestionListVar.getCreatedOn()}</label></td>
					<td align="center" style="width: 150px;"><label>${suggestionListVar.getApprovalLevel()}</label></td>
					<td align="center" style="width: 150px;"><label>${suggestionListVar.getApprovalStatus()}</label></td>
					<td align="center" style="width: 400px;"><label>${suggestionListVar.getTitle()}</label></td>
				</tr>
			</c:forEach>
		</table>

	</div>

</body>
</html>