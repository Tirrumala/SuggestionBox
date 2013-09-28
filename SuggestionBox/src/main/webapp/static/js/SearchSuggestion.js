function fetchSearchData(searchData)
{
	var jsonText = sendAJAXRequest("/sbs-0.0.1-SNAPSHOT/Search?searchPattern="+searchData, "GET", "", "JSON", false);

	if (!jsonText || jsonText.suggestionList.length == 0) {
//		alert("No data found");
		return null;
	}

	var x = new Array(jsonText.suggestionList.length);
	for (var i = 0; i < jsonText.suggestionList.length; i++) 
	{
		x[i] = new Array(2);

		x[i][0] = jsonText.suggestionList[i].suggestionId;
		x[i][1]= jsonText.suggestionList[i].owner + " , " +
				jsonText.suggestionList[i].category + " , " +
				jsonText.suggestionList[i].title;
	}

	return x;
}

function getDescription(sugId)
{
	window.location.assign("/sbs-0.0.1-SNAPSHOT/MySuggestionDescription?sugId="+sugId);
}