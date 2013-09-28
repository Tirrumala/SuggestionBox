function addOrUpdateRole(operation) {
	alert(operation);
	var userNameText = document.getElementById('userNameId');
	var selObj = document.getElementById('selectRoleId');
	var categoryObj = document.getElementById('selectCategoryId');

	var selectedArray = new Array();

	var i;
	var count = 0;
	for (i = 0; i < selObj.options.length; i++) {
		if (selObj.options[i].selected) {
			selectedArray[count] = selObj.options[i].value;
			count++;
		}
	}

	var categoryArray = new Array();

	var i;
	var count = 0;
	for (i = 0; i < selObj.options.length; i++) {
		if (selObj.options[i].selected) {
			categoryArray[count] = selObj.options[i].value;
			count++;
		}
	}

	var r = confirm("User : " + userNameText.value + "\n Operation : " + operation +"\n Category : " + categoryArray+"\n Roles  : "
			+ selectedArray + " \n Please Confirm changes are fine.");
	
	if (r == true) {
		selectedArray[count] = userNameText.value;
		if(operation == 'Add')
		{
			alert("Successfully Added User roles and category.");

		}
		else if(operation == 'Update')
		{
			alert("Successfully Updated User roles and category.");
		}
		else if(operation == 'Delete')
		{
			alert("Successfully Deleted User roles and category.");
		}
	} else {
		//nothing to do
	}
}
