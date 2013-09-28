
//Node tags
var TABLE_TAG = 'table';
var TABLE_ROW_TAG = 'tr';
var TABLE_COLUMN_TAG = 'td';
var TABLE_BODY_TAG = 'tbody';
var DIV_TAG = 'div';


function MySpaceNew()
{
	alert("MySpaceNew");
	sendAJAXRequest("/sbs-0.0.1-SNAPSHOT/MySuggestionAdd", "GET", "", "", false);
}

function MySpaceViewList()
{
	alert("MySpaceViewList");
	sendAJAXRequest("/sbs-0.0.1-SNAPSHOT/MySuggestionViewList", "GET", "", "", false);
}

function myspaceViewList()
{
	myspaceHideDivs();

	var divViewListNode = document.getElementById("myspaceSuggestionListId");
	divViewListNode.style.visibility='visible';

	moveDivNode(divViewListNode);

	myspaceShowViewList(divViewListNode);
}

function modalTest(operationType)
{
	if(operationType == 'Add')
	{
		document.getElementById("mySugTextArea").value ="";
	}
	myspaceHideDivs();
	var a = document.getElementById("myspaceModal");
	a.style.visibility='visible';

	var divCreateNode = document.getElementById("myspaceSuggestionId");
	divCreateNode.style.visibility='visible';

	moveDivNode(divCreateNode);
	moveDivNode(a);
}

function mySugDelete()
{
	myspaceViewList();
}

function modaldoTest(type)
{
	if(type == 'Likes' || type == 'Dislikes')
	{
		var dataArray = new Array(1);
		dataArray[0] = new Array(5);

		dataArray[0][0] = "User";
		dataArray[0][1] = "Updated On :";
		dataArray[0][2] = "Date";
		dataArray[0][3] = type;
		dataArray[0][4] = "This is for testing likes the content. ";

		var divViewListNode =document.getElementById("myspaceSuggestionAppendId");

		mySugCreateCommentDiv(divViewListNode,dataArray[0], 0);

	}
	else if(type == 'cancel')
	{
		//do nothing time being
	}

	myspaceSuggestionDisplay();
}

function myspaceSuggestionShow()
{
	var dataArray = new Array(10);
	for (var i = 0; i < 10; i++) {
		dataArray[i] = new Array(5);

		dataArray[i][0] = "User"+i;
		dataArray[i][1] = "Updated On :";
		dataArray[i][2] = "Date"+(i+2);
		dataArray[i][3] = "Likes"+(i+3);
		dataArray[i][4] = "This is for testing the content. And it is checking the size.This is for testing the content. And it is checking the size.This is for testing the content. And it is checking the size.This is for testing the content. And it is checking the size."+(i+4);
	}

	var divViewListNode =document.getElementById("myspaceSuggestionAppendId");


	for (var i = 0; i < 10; i++) 
	{
		mySugCreateCommentDiv(divViewListNode,dataArray[i], i);
	}
}

function mySugCreateCommentDiv(divViewListNode,dataArray, index)
{
	var divNode = document.createElement(DIV_TAG);
	divNode.id = "myspaceTableRowId"+index;
	divNode.style.backgroundColor="lightblue";

	var tableNode = document.createElement(TABLE_TAG);
//	tableNode.style.border ="1px solid lightblue";

	var tableBody = document.createElement(TABLE_BODY_TAG);

	var row = document.createElement(TABLE_ROW_TAG);
	row.id = "myspaceTableRowId"+index;
//	row.style.backgroundColor="lightblue";
	row.style.height = "25px";
	row.align = "center";

	var editImage = document.createElement('input');
	editImage.type = "image";
	editImage.id = "myspaceTableRowCheckBoxId";
	editImage.style.height = "30px";
	editImage.style.width = "30px";
	editImage.src = "./icons/Edit_Small.png" ;
	editImage.title="Edit the Comment";
	row.appendChild(editImage);

	var cell = document.createElement(TABLE_COLUMN_TAG);
	var cellText = document.createTextNode(dataArray[0]);
	cell.appendChild(cellText);
	cell.style.width = "250px";
	row.appendChild(cell);

	cell = document.createElement(TABLE_COLUMN_TAG);
	cellText = document.createTextNode(dataArray[1]);
	cell.appendChild(cellText);
	cell.style.width = "150px";
	row.appendChild(cell);

	cell = document.createElement(TABLE_COLUMN_TAG);
	cellText = document.createTextNode(dataArray[2]);
	cell.appendChild(cellText);
	cell.style.width = "200px";
	row.appendChild(cell);

	cell = document.createElement(TABLE_COLUMN_TAG);
	var img = new Image();
	img.src = "./icons/Like.png";
	img.style.height = "25px";
	img.style.width = "25px";
	cell.appendChild(img);

	cellText = document.createTextNode(dataArray[3]);
	cell.appendChild(cellText);
	cell.style.width = "150px";
	row.appendChild(cell);

	tableBody.appendChild(row);
	tableNode.appendChild(tableBody);
	divNode.appendChild(tableNode);
	divViewListNode.appendChild(divNode);

	var divNode1 = document.createElement(DIV_TAG);
	divNode1.id = "myspaceTableRowId"+index;
//	divNode1.style.width = "800px";
	divNode1.style.backgroundColor="lightyellow";
	divNode1.innerHTML=dataArray[4];
	divViewListNode.appendChild(divNode1);

	addRowEditEventHandlers(editImage,divNode1);

}

function addRowEditEventHandlers(editImage,divNode1) {

	var editEventHandler =
		function(editImage)
		{
		return function() {
			document.getElementById("mySugTextArea").value = divNode1.innerHTML;
			modalTest('Edit');

		};
		};

		editImage.onclick = editEventHandler();


		var editEventKeyHandler =
			function()
			{
			return function() {
				document.getElementById("mySugTextArea").value = divNode1.innerHTML;
				modalTest('Edit');
			};
			};

			editImage.onkeydown = editEventKeyHandler();
}

function myspaceSuggestionDisplay()
{
	myspaceHideDivs();

	var divCreateNode = document.getElementById("myspaceSuggestionId");
	divCreateNode.style.visibility='visible';

	var a = document.getElementById("myspaceModal");
	a.style.visibility='hidden';

	moveDivNode(divCreateNode);

	myspaceSuggestionShow();
}

function myspaceShowViewList(divViewListNode)
{
	var jsonText = sendAJAXRequest("/sbs-0.0.1-SNAPSHOT/MySuggestionViewList/GetData", "GET", "", "JSON", false);

	if (!jsonText || jsonText.suggestionList.length == 0) {
		alert("No data found");

		return;
	}

	var tableNode =  document.getElementById("myspaceSuggestionListTableId");
	while(tableNode.hasChildNodes())
	{
		tableNode.removeChild(tableNode.firstChild);
	}
	
	var tableBody = document.createElement(TABLE_BODY_TAG);

	var flipFlag = true;

	for (var i = 0; i < jsonText.suggestionList.length; i++) 
	{
		var row = document.createElement(TABLE_ROW_TAG);
		row.id = "myspaceTableRowId"+i;
		row.style.height = "50px";
		if(flipFlag)
		{
			row.style.backgroundColor="lightblue";
			flipFlag=false;
		}
		else
		{
			row.style.backgroundColor="lightyellow";
			flipFlag=true;
		}

		var cell = document.createElement(TABLE_COLUMN_TAG);
		var checkbox = document.createElement('input');
		checkbox.type = "checkbox";
		checkbox.value = "value";
		checkbox.name = "myspaceTableRowCheckBoxName";
		checkbox.id = "myspaceTableRowCheckBoxId";
//		checkbox.style.width = "50px";
//		checkbox.style.height = "50px";
		cell.style="width: 40px; height: 40px; align:center";
		cell.appendChild(checkbox);
		row.appendChild(cell);

		cell = document.createElement(TABLE_COLUMN_TAG);
		var linkText = "<a href=\"MySuggestionViewList\">"+jsonText.suggestionList[i].suggestionId+"<\a>"
//		var cellText = document.createTextNode(linkText);
//		cell.appendChild(cellText);
		cell.innerHTML = linkText;
		cell.style.width = "150px";
		row.appendChild(cell);

		cell = document.createElement(TABLE_COLUMN_TAG);
		cellText = document.createTextNode(jsonText.suggestionList[i].category);
		cell.appendChild(cellText);
		cell.style.width = "150px";
		row.appendChild(cell);

		cell = document.createElement(TABLE_COLUMN_TAG);
		cellText = document.createTextNode(jsonText.suggestionList[i].createdOn);
		cell.appendChild(cellText);
		cell.style.width = "150px";
		row.appendChild(cell);

		cell = document.createElement(TABLE_COLUMN_TAG);
		cellText = document.createTextNode(jsonText.suggestionList[i].approvalLevel);
		cell.appendChild(cellText);
		cell.style.width = "150px";
		row.appendChild(cell);

		cell = document.createElement(TABLE_COLUMN_TAG);
		cellText = document.createTextNode(jsonText.suggestionList[i].approvalStatus);
		cell.appendChild(cellText);
		cell.style.width = "150px";
		row.appendChild(cell);
		
		cell = document.createElement(TABLE_COLUMN_TAG);
		cellText = document.createTextNode(jsonText.suggestionList[i].title);
		cell.appendChild(cellText);
//		cell.style.width = "400px";
		row.appendChild(cell);

		tableBody.appendChild(row);
	}
	tableNode.appendChild(tableBody);

	divViewListNode.appendChild(tableNode);

//	addRowEventHandlers(tableNode);
}

function addRowEventHandlers(table) {
	var rows = table.getElementsByTagName(TABLE_ROW_TAG);
	for (var i = 0; i < rows.length; i++) {
		var currentRow = rows[i];
		var createClickHandler =
			function(row)
			{
			return function() {
				//TODO
				//myspaceSuggestionDisplay();
				alert(row.cells[1].innerHTML);

			};
			};

			currentRow.onclick = createClickHandler(currentRow);

			var createMouseHoverHandler =
				function(row,i)
				{
				return function() {
//					row.style.borderColor = '#00FF00';
				};
				};

				currentRow.onmouseover = createMouseHoverHandler(currentRow,i);

				var createMouseOutHandler =
					function(row)
					{
					return function() {
//						row.style.borderColor =  row.style.background;
					};
					};

					currentRow.onmouseout = createMouseOutHandler(currentRow);

					currentRow.onkeydown =
						function(e)
						{
						return function() {
							alert(e.keyCode);
						};
						};
	}
}

function mySugDeleteListItems()
{
	var text = "";
	var tableNode =  document.getElementById("myspaceSuggestionListTableId");
	var rows = tableNode.getElementsByTagName(TABLE_ROW_TAG);
	for (var i = 0; i < rows.length; i++) {
		var currentRow = rows[i];
		var checkItem = currentRow.cells[0].firstChild.checked;
//		alert(currentRow.cells[1].firstChild.nodeValue + " -- " + checkItem);
		if(checkItem === true)
		{
			text = currentRow.cells[1].firstChild.nodeValue + " , " + text;
		}
	}

	alert("Following Suggestion ID's are selected to delete : " + text);
}
function mySugSetCheckboxItems(checkedFlag)
{

	var nodeList = document.getElementsByName("myspaceTableRowCheckBoxName");
	for(var i =0 ; i < nodeList.length; i++)
	{
		nodeList[i].checked = checkedFlag;
	}
}

function moveDivNode(newNode)
{
	var divdummyNode = document.getElementById("myspaceDummyId");
	divdummyNode.parentNode.insertBefore(newNode, divdummyNode.nextSibling);
}

function removeAllChildNodes()
{
	while (divdummyNode.firstChild) {
		divdummyNode.removeChild(divdummyNode.firstChild);
	}
}

function myspaceHideDivs()
{
//	var divSearchNode = document.getElementById("myspaceSearchId");
//	divSearchNode.style.visibility='hidden';

	var divCreateNode = document.getElementById("myspacveCreateSuggestionId");
	divCreateNode.style.visibility='hidden';

	var divListNode = document.getElementById("myspaceSuggestionListId");
	divListNode.style.visibility='hidden';

	var divSuggestionNode = document.getElementById("myspaceSuggestionId");
	divSuggestionNode.style.visibility='hidden';

	var a = document.getElementById("myspaceModal");
	a.style.visibility='hidden';

}