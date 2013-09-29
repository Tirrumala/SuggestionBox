<jsp:useBean id="userProfileDetailsBean"
	class="com.opensource.suggestionbox.beans.modelview.UserProfileDetailsBean"
	scope="session" />
<jsp:setProperty name="userProfileDetailsBean" property="*" />

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Approve</title>
<link href="static/css/tabs.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:include page="SuggestionBoxHeader.jsp" />
	<br>
	<hr style="border: #48f solid 3px">

	<jsp:include page="PrivilegesMenu.jsp">
		<jsp:param name="menu" value="Approve" />
	</jsp:include>

	<hr style="border: #48f solid 3px">

	<!-- <div class="content" id="approveContentPanelId"> -->
	<div id="publicSuggDummyId" align="center"></div>

	<div id="publicSuggViewListId">

		<div id="publicSuggSearchId" align="center" style="height: 100px">
			<br> <br>

			<table>
				<tr>
					<td><label style="color: blue">Search Suggestions</label></td>
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

		<h2 style="color: orange;">My Suggestions</h2>
		<hr>
		<div align="left" style="height: 30px;">
			<table>
				<tr>
					<td style="width: 20px;"><input type="image"
						id="approveImageAcceptId" style="height: 15px; width: 15px;"
						title="Accept" src="static/icons/Accept.png" /></td>
					<td style="width: 150px;"><label for="approveImageAcceptId">Approve</label></td>
					<td style="width: 20px;"><input type="image"
						id="approveImageRejectId" style="height: 20px; width: 20px;"
						title="Reject" src="static/icons/Reject.png" /></td>
					<td style="width: 150px;"><label for="approveImageRejectId">Reject</label></td>
					<td style="width: 150px;"></td>
					<td style="width: 150px;"></td>
					<td style="width: 30px;"><input type="button"
						id="publicSuggPrevButtonId" value="<"></td>
					<td align="center" style="width: 150px;"><label>1-25
							of 1000</label></td>
					<td style="width: 30px;"><input type="button"
						id="publicSuggPrevButtonId" value=">"></td>
				</tr>
			</table>
		</div>
		<hr>
		<div style="height: 30px; background-color: #dedede">
			<table id="publicSuggSuggestionListTableHeaderId">
				<tr>
					<td align="center" style="width: 20px;"><input type="checkbox"
						id="suggestionItemIdHead"
						onchange="mySugSetCheckboxItems(document.getElementById('suggestionItemIdHead').checked);"></td>
					<td align="center" style="width: 150px;"><label>Suggestion
							Id</label></td>
					<td align="center" style="width: 150px;"><label>Date</label></td>
					<td align="center" style="width: 150px;"><label>Approval
							Level</label></td>
					<td align="center" style="width: 150px;"><label>Approval
							Status</label></td>
					<td align="center" style="width: 400px;"><label>Suggestion</label></td>
				</tr>
			</table>
		</div>

		<table id="publicSuggSuggestionListTableId">

		</table>

	</div>
	<div id="publicSuggModal">

		<h2>Add your Comments:</h2>
		<table>

			<tr>
				<td align="left" style="width: 100px;"><label>Suggestion</label></td>
				<td><textarea id="mySugTextArea" rows="10" cols="70"
						style="resize: none"></textarea></td>
				<td></td>
			</tr>

			<tr align="center" height="50px">

				<td></td>
				<td align="center"><input type="button"
					style="font-style: italic; font-size: larger; color: green;"
					id="publicSuggSuggestionSubmitId" value="Likes"
					onclick="modaldoTest(value);"> <input type="button"
					style="font-style: italic; font-size: larger; color: red"
					id="publicSuggSuggestionSubmitId" value="Dislikes"
					onclick="modaldoTest(value);"> <input type="button"
					style="font-style: italic; font-size: larger; color: black"
					id="publicSuggSuggestionSubmitId" value="Cancel"
					onclick="modaldoTest(value);"></td>
				<td></td>
			</tr>
		</table>
	</div>
</body>
</html>