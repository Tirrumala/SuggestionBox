/**
 * Original Author : Thirumaleshwar Kunamalla
 * 
 * Customization Author : <Your Name>
 */

//Styles
var ROW_BACK_GROUND_COLOR_NON_HIGHLIGHT = 'white';
var ROW_BACK_GROUND_COLOR_HIGHLIGHT = 'lightblue';

//Event Handlers constant
var EVENT_KEY_PRESS = 'keypress';
var EVENT_KEY_DOWN = 'keydown';
var EVENT_KEY_UP ='keyup';

//Constants declaration
var AUTO_ROW_INDEX = 'AUTO_ROW_INDEX_';

//Node tags
var TABLE_TAG = 'table';
var TABLE_ROW_TAG = 'tr';
var TABLE_COLUMN_TAG = 'td';
var TABLE_BODY_TAG = 'tbody';
var DIV_TAG = 'div';

//Variables declaration
var MIN = 0;
var MAX = 5;
var rowCount = 0;
var inputTextWidth = 0;
var rowSelId = '';

var keyTransitionMode = false;

//Nodes
var autoInputTextNode = null;
var autoParentDivNode = null;

//Data sets
var dataArray = null;

//Node id's
var childDivTagId = "autoCompleteDiv";
var tableId = "autoCompleteTable";

function initialize(inputTextId, parentDivTagId)
{
	autoParentDivNode = document.getElementById(parentDivTagId);
	autoInputTextNode = document.getElementById(inputTextId); 
	inputTextWidth = autoInputTextNode.offsetWidth;

//	dataArray = data;
//	MAX = data.length;

}
//function createAutoCompleteSearchList(inputTextId, parentDivTagId, data){

//autoParentDivNode = document.getElementById(parentDivTagId);

//addInputTextEventListener(inputTextId);

//inputTextWidth = autoInputTextNode.offsetWidth;

//dataArray = data;
//MAX = data.length;
//}

//function addInputTextEventListener(inputTextId)
//{
//autoInputTextNode = document.getElementById(inputTextId);
//autoInputTextNode.addEventListener(EVENT_KEY_DOWN, keyDownHandler, true);
//autoInputTextNode.addEventListener(EVENT_KEY_UP, keyUpHandler, true);
//}

function keyDownHandler(e)
{
	var keyValue = getKeyValues(e);

	if(keyValue == 'KEY_UP_ARROW')
	{
		if(rowCount > MIN)
		{
			upTraversal();

			keyTransitionMode = true;
		}
	}
	else if(keyValue == 'KEY_DOWN_ARROW')
	{
		if(rowCount < MAX-1)
		{
			downTraversal();

			keyTransitionMode = true;
		}
	}
	else if(keyValue == 'KEY_ESCAPE')
	{
		removeNode(childDivTagId);

		keyTransitionMode = false;
	}
	else if(keyValue == 'KEY_TAB')
	{
		var cellValue = document.getElementById(AUTO_ROW_INDEX +"0").cells[0].firstChild.nodeValue;
		autoInputTextNode.value = cellValue;

		removeNode(childDivTagId);

		keyTransitionMode = false;
		
		//finally call
		getDescription(cellValue);
	}
	else if( keyValue == 'KEY_ENTER')
	{
		var currentRow = document.getElementById(AUTO_ROW_INDEX+rowCount);
		var cellValue = currentRow.cells[0].firstChild.nodeValue;
		autoInputTextNode.value = cellValue;

		removeNode(childDivTagId);

		keyTransitionMode = false;
		
		//finally call
		getDescription(cellValue);
	}
	else
	{
		keyTransitionMode = false;
	}
}

function removeNode(tagId)
{
	var node = document.getElementById(tagId);
	if(node != null)
	{
		node.parentNode.removeChild(node);
	}
}

function keyUpHandler(e)
{
	var keyValue = getKeyValues(e);
	if(keyValue != 'KEY_ESCAPE' && keyValue != 'KEY_TAB' && keyValue != 'KEY_ENTER' && keyTransitionMode == false)
	{
		populateDivMenu();
	}
}

function removePreviousSelection()
{
	if(keyTransitionMode == true)
	{
		unsetHighlight();
	}
}

function upTraversal()
{
	unsetHighlight();

	rowCount--;

	setHighlight();
}

function downTraversal()
{
	unsetHighlight();

	if(rowCount < MAX-1)
	{
		rowCount++;
	}

	setHighlight();
}

function setHighlight()
{
	currentRow = document.getElementById(AUTO_ROW_INDEX+rowCount);
	if(currentRow == null)
	{
		currentRow = document.getElementById(rowSelId);
	}
	currentRow.style.background =ROW_BACK_GROUND_COLOR_HIGHLIGHT;
}

function unsetHighlight()
{
	var currentRow = document.getElementById(AUTO_ROW_INDEX+rowCount);
	if(currentRow == null)
	{
		currentRow = document.getElementById(rowSelId);
	}
	currentRow.style.background =ROW_BACK_GROUND_COLOR_NON_HIGHLIGHT;
}

function populateDivMenu()
{ 
	dataArray = fetchSearchData(autoInputTextNode.value);

	if(dataArray == null)
	{
		removeNode(childDivTagId);
	}
	else
	{
		MAX = dataArray.length;

		rowCount = 0;
		keyTransitionMode = false;
		var divTag = document.getElementById(childDivTagId);
		if(divTag)
		{
			removeNode(childDivTagId);
		}
		divTag = document.createElement(DIV_TAG);
		divTag.id = childDivTagId;
		divTag.setAttribute("style", "position:absolute; z-index: 100; width:"+inputTextWidth+"px; height:200px; overflow: scroll; background-color:white");
		divTag.style.border = "1px solid #ccc";

		autoParentDivNode.appendChild(divTag);

		createDynamicTable(divTag);
	}
}

function createDynamicTable(divElement){
	var table = document.getElementById(tableId);
	if(table)
	{
		var divTag =  document.getElementById(childDivTagId);
		divTag.removeChild(table);
	}
	else
	{
		table = document.createElement(TABLE_TAG);
		table.id = tableId;
		divElement.appendChild(table);
	}
//	table.style.background = ROW_BACK_GROUND_COLOR_NON_HIGHLIGHT;

	createDynamicRows(table);
}

function createDynamicRows(table)
{
	var tableBody = document.createElement(TABLE_BODY_TAG);

	var firstCol = Math.round(inputTextWidth *1/4);
	var secondCol = inputTextWidth - firstCol;

	for (var i = 0; i < MAX; i++) {
		var row = document.createElement(TABLE_ROW_TAG);
		row.id = AUTO_ROW_INDEX+i;
		row.style.width = inputTextWidth +"px";
		row.style.height = "20px";

		var cell = document.createElement(TABLE_COLUMN_TAG);
		var cellText = document.createTextNode(dataArray[i][0]);
		cell.appendChild(cellText);
		cell.style.width =  firstCol +"px";
		row.appendChild(cell);

		cell = document.createElement(TABLE_COLUMN_TAG);
		cellText = document.createTextNode(dataArray[i][1]);
		cell.appendChild(cellText);
		cell.setAttribute("style", "width:"+secondCol+"px;text-align: left;");
		row.appendChild(cell);

		tableBody.appendChild(row);
	}

	table.appendChild(tableBody);

	addRowEventHandlers(table);
}

function addRowEventHandlers(table) {
	var rows = table.getElementsByTagName(TABLE_ROW_TAG);

	for (var i = 0; i < rows.length; i++) {

		var currentRow = rows[i];

		currentRow.addEventListener('click', 	 
				function() {
			var cell = this.getElementsByTagName(TABLE_COLUMN_TAG)[0];
			var cellValue = cell.innerHTML;
			autoInputTextNode.value = cellValue;

			removeNode(childDivTagId);
			keyTransitionMode = false;
			
			//finally call
			getDescription(cellValue);
		}, 
		true);

		currentRow.addEventListener('mouseover', 
				function() {
			keyTransitionMode = true;
			this.style.background = ROW_BACK_GROUND_COLOR_HIGHLIGHT;
			this.style.borderColor = ROW_BACK_GROUND_COLOR_HIGHLIGHT;
		}, 
		true);

		currentRow.addEventListener('mouseout',
				function() {
			this.style.background = ROW_BACK_GROUND_COLOR_NON_HIGHLIGHT;
			this.style.borderColor =   ROW_BACK_GROUND_COLOR_NON_HIGHLIGHT;
		}, 
		true);

		currentRow.addEventListener('keydown',
				function() {
			rowSelId = this.id;
			unsetHighlight();
			keyDownHandler(e);
		}, 
		true);
	}
}

function getKeyValues(e){
	var arrs= [];
//	var key= window.event? event.keyCode: e.keyCode;
	arrs[8]  = 'KEY_BACKSPACE';
	arrs[9]  = 'KEY_TAB';
	arrs[13] = 'KEY_ENTER';
	arrs[27] = 'KEY_ESCAPE';
	arrs[37] = 'KEY_LEFT_ARROW';
	arrs[38] = 'KEY_UP_ARROW';
	arrs[39] = 'KEY_RIGHT_ARROW';
	arrs[40] = 'KEY_DOWN_ARROW';

	keyValue = arrs[e.keyCode];

	return keyValue;
}
