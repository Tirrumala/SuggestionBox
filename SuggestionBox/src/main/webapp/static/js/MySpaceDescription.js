function editDescription(flag,uuid,description)
{
	alert(description);
	var commentArea =document.getElementById("mySpaceTextAreaId");
	commentArea.value = '';

	if(flag === 'EDIT')
	{
		commentArea.value = description;
		document.getElementById("myspaceSuggestionDescriptionId").value = uuid;
	}

	commentArea.focus();
	commentArea.setSelectionRange(0, 0);
}

function cancelDescription()
{
	document.getElementById("mySpaceTextAreaId").value = "";
	document.getElementById("myspaceLikesId").checked = true;
}

