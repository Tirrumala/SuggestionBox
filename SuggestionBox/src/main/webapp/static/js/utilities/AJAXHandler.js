function sendAJAXRequest(url,method,params,contentType,sync) {

	method = method ? method : "GET";

	var xmlhttp;
	var json;

	if (window.XMLHttpRequest) 
	{
		// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} 
	else 
	{
		// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}


	xmlhttp.onreadystatechange = function() {
//		alert("readyState = " + xmlhttp.readyState + "  status = " + xmlhttp.status + " response = " + xmlhttp.responseText);

		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {

			json = JSON.parse(xmlhttp.responseText);
		}
	};

	//Open a connection
	if(method == "POST" || method == "PUT")
	{
		xmlhttp.open(method, url, sync);
	}
	else
	{
		xmlhttp.open(method, url+params, sync);
	}

	//set headers
	if(contentType == "JSON")
	{
		xmlhttp.setRequestHeader("Content-type","application/json");
	}
	else
	{
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	}
	
	xmlhttp.setRequestHeader("Content-length", params.length);
	//	xmlhttp.setRequestHeader("connection", "close");

	//set request
	if(method == "POST" || method == "PUT")
	{
		xmlhttp.send(params);
	}
	else
	{
		xmlhttp.send();
	}

	return json;
}


/*function JSONHandler_sendRequestWithBody(url,method,params) {

	method = method ? method : "GET";

	var xmlhttp;
	var json;

	alert("Infomation passed :  URL = " + url+ " Params = " + params + " Method =" + method);


	if (window.XMLHttpRequest) 
	{
		// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} 
	else 
	{
		// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}


	xmlhttp.onreadystatechange = function() {
		alert("readyState = " + xmlhttp.readyState + "  status = " + xmlhttp.status + " response = " + xmlhttp.responseText);

		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {

			json = JSON.parse(xmlhttp.responseText);
		}
	};

	xmlhttp.open(method, url+params, false);
	xmlhttp.send();

	return json;
}*/