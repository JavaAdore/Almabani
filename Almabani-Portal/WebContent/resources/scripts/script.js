function getCookie(name) {
	var value = "; " + document.cookie;
	var parts = value.split("; " + name + "=");
	if (parts.length == 2)
		return parts.pop().split(";").shift();
}

function getApplicationDescription(appName) {
	apps = JSON.parse($.cookie('allowedApps'));

	for (i = 0; i < apps.length; i++) {
		if (apps[i].applicationCode == appName) {
			return apps[i].applicationDescription;
		}
	}
	return "";
}

function cookieAsJson(str) {

	str = str.replace("\\", "");
	str = str.split(', ');
	var result = {};
	for (var i = 0; i < str.length; i++) {
		var cur = str[i].split('=');
		result[cur[0]] = cur[1];
	}
	return result;

}

$(document).ready(function() {

});

function centerEveryThingInTD() {
	$("td[role='gridcell']").each(function(index, obj) {

		$(obj).addClass('center');

	});
}


function getNoStyleValue( component , val)
{
	try{
		if (window.DOMParser)
		{
		  parser=new DOMParser();
		  xmlDoc=parser.parseFromString(val,"text/xml");
		}
		else // Internet Explorer
		{
		  xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
		  xmlDoc.async=false;
				  xmlDoc.loadXML(val);

		}
		var val =  xmlDoc.getElementsByTagName("span")[0].childNodes[0].nodeValue;
		 if (val !=null)
		{
			 
			 $(component).html( val);
		}
		 return  $(component).html( "");

	}catch(e)
	{
		return  $(component).html( "");
	}
	
	
	
}

function handleDialogSubmit(xhr, status, args) 
{
	
	alert('xxxxx');
}