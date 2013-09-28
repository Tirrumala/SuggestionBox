
//Node tags
var TABLE_TAG = 'table';
var TABLE_ROW_TAG = 'tr';
var TABLE_COLUMN_TAG = 'td';
var TABLE_BODY_TAG = 'tbody';
var DIV_TAG = 'div';

function publicSuggViewList()
{
	publicSuggHideDivs();

	var divViewListNode = document.getElementById("publicSuggViewListId");
	divViewListNode.style.visibility='visible';

	moveDivNode(divViewListNode);

	publicSuggShowViewList(divViewListNode);
}

function modalTest(operationType)
{
	if(operationType == 'Add')
	{
		document.getElementById("publicSuggTextArea").value ="";
	}
	publicSuggHideDivs();
	var a = document.getElementById("publicSuggModal");
	a.style.visibility='visible';

	var divCreateNode = document.getElementById("publicSuggSuggestionId");
	divCreateNode.style.visibility='visible';

	moveDivNode(divCreateNode);
	moveDivNode(a);
}

function publicSuggDelete()
{
	publicSuggViewList();
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

		var divViewListNode =document.getElementById("publicSuggSuggestionAppendId");

		publicSuggCreateCommentDiv(divViewListNode,dataArray[0], 0);

	}
	else if(type == 'cancel')
	{
		//do nothing time being
	}

	publicSuggSuggestionDisplay();
}

function publicSuggSuggestionShow()
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

	var divViewListNode =document.getElementById("publicSuggSuggestionAppendId");


	for (var i = 0; i < 10; i++) 
	{
		publicSuggCreateCommentDiv(divViewListNode,dataArray[i], i);
	}
}

function publicSuggCreateCommentDiv(divViewListNode,dataArray, index)
{
	var divNode = document.createElement(DIV_TAG);
	divNode.id = "publicSuggTableRowId"+index;
	divNode.style.backgroundColor="lightblue";

	var tableNode = document.createElement(TABLE_TAG);
//	tableNode.style.border ="1px solid lightblue";

	var tableBody = document.createElement(TABLE_BODY_TAG);

	var row = document.createElement(TABLE_ROW_TAG);
	row.id = "publicSuggTableRowId"+index;
//	row.style.backgroundColor="lightblue";
	row.style.height = "25px";
	row.align = "center";

	var editImage = document.createElement('input');
	editImage.type = "image";
	editImage.id = "publicSuggTableRowCheckBoxId";
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
	divNode1.id = "publicSuggTableRowId"+index;
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
			document.getElementById("publicSuggTextArea").value = divNode1.innerHTML;
			modalTest('Edit');

		};
		};

		editImage.onclick = editEventHandler();


		var editEventKeyHandler =
			function()
			{
			return function() {
				document.getElementById("publicSuggTextArea").value = divNode1.innerHTML;
				modalTest('Edit');
			};
			};

			editImage.onkeydown = editEventKeyHandler();
}

function publicSuggSuggestionDisplay()
{
	publicSuggHideDivs();

	var divCreateNode = document.getElementById("publicSuggSuggestionId");
	divCreateNode.style.visibility='visible';

	var a = document.getElementById("publicSuggModal");
	a.style.visibility='hidden';

	moveDivNode(divCreateNode);

	publicSuggSuggestionShow();
}

function publicSuggShowViewList(divViewListNode)
{
//	var dataArray = [
//	[A,A,A,A,A],
//	[B,B,B,B,B],
//	[C,C,C,C,C],
//	[D,D,D,D,D],
//	];

	var dataArray = new Array(10);
	for (var i = 0; i < 10; i++) {
		dataArray[i] = new Array(2);

		dataArray[i][0] = "Testing sample "+i;
		dataArray[i][1] = "Goto -> Page"+(i+1);
		dataArray[i][2] = "Goto -> Page"+(i+2);
		dataArray[i][3] = "Goto -> Page"+(i+3);
		dataArray[i][4] = "asddskjl;adsfa;lkdsfa;ksdf;akfghdfghsdf;aksdf;aksdf;lakdsjf;akdsj;fkadsfadsflkasdfasdf"+(i+4);
	}

	var tableNode =  document.getElementById("publicSuggSuggestionListTableId");
//	tableNode.style.border ="1px solid lightblue";

	var tableBody = document.createElement(TABLE_BODY_TAG);

	var flipFlag = true;

	for (var i = 0; i < 10; i++) 
	{
		var row = document.createElement(TABLE_ROW_TAG);
		row.id = "publicSuggTableRowId"+i;
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
		checkbox.name = "publicSuggTableRowCheckBoxName";
		checkbox.id = "publicSuggTableRowCheckBoxId";
//		checkbox.style.width = "50px";
//		checkbox.style.height = "50px";
		cell.style="width: 40px; height: 40px; align:center";
		cell.appendChild(checkbox);
		row.appendChild(cell);


		cell = document.createElement(TABLE_COLUMN_TAG);
		var cellText = document.createTextNode(dataArray[i][0]);
		cell.appendChild(cellText);
		cell.style.width = "150px";
		row.appendChild(cell);

		cell = document.createElement(TABLE_COLUMN_TAG);
		cellText = document.createTextNode(dataArray[i][1]);
		cell.appendChild(cellText);
		cell.style.width = "150px";
		row.appendChild(cell);

		cell = document.createElement(TABLE_COLUMN_TAG);
		cellText = document.createTextNode(dataArray[i][2]);
		cell.appendChild(cellText);
		cell.style.width = "150px";
		row.appendChild(cell);

		cell = document.createElement(TABLE_COLUMN_TAG);
		cellText = document.createTextNode(dataArray[i][3]);
		cell.appendChild(cellText);
		cell.style.width = "150px";
		row.appendChild(cell);

		cell = document.createElement(TABLE_COLUMN_TAG);
		cellText = document.createTextNode(dataArray[i][4]);
		cell.appendChild(cellText);
//		cell.style.width = "400px";
		row.appendChild(cell);

		tableBody.appendChild(row);
	}
	tableNode.appendChild(tableBody);

	divViewListNode.appendChild(tableNode);

	addRowEventHandlers(tableNode);
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
				publicSuggSuggestionDisplay();

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

function publicSuggDeleteListItems()
{
	var text = "";
	var tableNode =  document.getElementById("publicSuggSuggestionListTableId");
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
function publicSuggSetCheckboxItems(checkedFlag)
{

	var nodeList = document.getElementsByName("publicSuggTableRowCheckBoxName");
	for(var i =0 ; i < nodeList.length; i++)
	{
		nodeList[i].checked = checkedFlag;
	}
}

function moveDivNode(newNode)
{
	var divdummyNode = document.getElementById("publicSuggDummyId");
	divdummyNode.parentNode.insertBefore(newNode, divdummyNode.nextSibling);
}

function removeAllChildNodes()
{
	while (divdummyNode.firstChild) {
		divdummyNode.removeChild(divdummyNode.firstChild);
	}
}

function publicSuggHideDivs()
{
	var divListNode = document.getElementById("publicSuggViewListId");
	divListNode.style.visibility='hidden';

	var divSuggestionNode = document.getElementById("publicSuggSuggestionId");
	divSuggestionNode.style.visibility='hidden';

	var a = document.getElementById("publicSuggModal");
	a.style.visibility='hidden';

}