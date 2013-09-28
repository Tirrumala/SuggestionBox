<jsp:useBean id="userProfileDetailsBean"
	class="com.metricstream.suggestionbox.beans.modelview.UserProfileDetailsBean"
	scope="session" />
<jsp:setProperty name="userProfileDetailsBean" property="*" />

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Suggestions View</title>
<link type="text/css" href="static/css/tabs.css" rel="stylesheet" />
<script type="text/javascript" src="static/js/autocomplete.js"></script>
<script type="text/javascript" src="static/js/PublicSuggMain.js"></script>
<script type="text/javascript">
	function createDiv1(item, divName) {
		var x = new Array(10);
		for ( var i = 0; i < 10; i++) {
			x[i] = new Array(2);

			x[i][0] = "Testing sample " + i;
			x[i][1] = "Goto -> Page" + (i + 1); //This is like Feeling Lucky
		}

		createAutoCompleteSearchList(item, divName, x);
	}
</script>
</head>
<body onload="publicSuggViewList();">
	<jsp:include page="SuggestionBoxHeader.jsp" />

	<br>
	<hr style="border: #48f solid 3px">
	<jsp:include page="PrivilegesMenu.jsp">
		<jsp:param name="menu" value="PublicSuggestion" />
	</jsp:include>

	<hr style="border: #48f solid 3px">
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
						id="publicSuggImageDeleteId" style="height: 20px; width: 20px;"
						src="static/icons/Delete.png" onclick="mySugDeleteListItems();" /></td>
					<td style="width: 150px;"><label for="publicSuggImageDeleteId">Delete</label></td>
					<td style="width: 150px;"></td>
					<td style="width: 150px;"></td>
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

	<div id="publicSuggSuggestionId">
		<br>
		<div align="justify">
			<table>
				<tr>
					<td>
						<h3>Suggestion Id:</h3>
					</td>
					<td>
						<h3 style="color: red;">ID123123</h3>
					</td>
				</tr>
			</table>
		</div>
		<hr>
		<div>
			<table id="publicSuggSuggestionListTableHeaderId"
				style="height: 30px;">
				<tr>
					<td style="width: 40px;"><input type="image"
						id="publicSuggImageTableHeaderDeleteId"
						style="height: 25px; width: 25px;" src="static/icons/Delete.png"
						onclick="mySugDelete();" /></td>
					<td style="width: 200px;"><label
						for="publicSuggImageTableHeaderDeleteId">Delete suggestion</label>
					</td>
					<td style="width: 40px;"><input type="image"
						id="publicSuggImageTableHeaderAddId"
						style="height: 25px; width: 25px;"
						src="static/icons/Add_Orange.png" onclick="modalTest('Add');" /></td>
					<td style="width: 200px;"><label
						for="publicSuggImageTableHeaderAddId">Add comment</label></td>
				</tr>

			</table>

		</div>
		<hr>
		<div id="publicSuggSuggestionAppendId"></div>
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
	<!-- </div> -->

</body>
</html>