function Utility_getValue(key, object) {
	var retValue = "";

	for ( var i = 0; i < object.length; i++) {
//		alert(object[i].key + " = " + object[i].value);
		if (object[i].key == key) {
			retValue = object[i].value;
			break;
		}
	}

	return retValue;
}

function  Utility_clearForm(oForm) {

	var elements = oForm.elements;

	oForm.reset();

	for (i = 0; i < elements.length; i++) {

		field_type = elements[i].type.toLowerCase();

		switch (field_type) {

		case "text":
		case "password":
		case "textarea":
		case "hidden":

			elements[i].value = "";
			break;

		case "radio":
		case "checkbox":
			if (elements[i].checked) {
				elements[i].checked = false;
			}
			break;

		case "select-one":
		case "select-multi":
			elements[i].selectedIndex = -1;
			break;

		default:
			break;
		}
	}
}

function  Utility_clearDocForm(divId) {
	document.getElementById(divId).reset();
}

function Utility_createInputObject(divId) {
	var inputObjectArray = new Array();
	var k = 0;
	
	var x = document.getElementById(divId).getElementsByTagName("input");

	for ( var i = 0, k = 0; i < x.length; i++) {

		if (x[i].type == "text" || x[i].type == "password"
				|| x[i].type == "hidden") {
			var inputSubObj = new Object();
			inputSubObj.key = x[i].name;
			inputSubObj.value = x[i].value;
			inputObjectArray[k++] = inputSubObj;
		}

	}

	x = document.getElementById(divId).getElementsByTagName("textarea");

	for ( var i = 0; i < x.length; i++) {

		var inputSubObj = new Object();
		inputSubObj.key = x[i].name;
		inputSubObj.value = x[i].value;
		inputObjectArray[k++] = inputSubObj;

	}

	var jsonObjString = JSON.stringify(inputObjectArray);
	
	return inputObjectArray;
}
