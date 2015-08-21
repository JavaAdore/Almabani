function getCookie(name) {
			  var value = "; " + document.cookie;
			  var parts = value.split("; " + name + "=");
			  if (parts.length == 2) return parts.pop().split(";").shift();
			} 
		

  function getApplicationDescription(appName)
  {
 	apps = JSON.parse($.cookie('allowedApps'));

 	for (i = 0; i < apps.length; i++) { 
 	    if(apps[i].applicationCode ==appName)
 	    {
 	    	return apps[i].applicationDescription;
 	    }
 	} 
	return "";  
  }
  
  
  function cookieAsJson(str)
  {
	  
	  str = str.replace("\\","");
	  str=  str.split(', ');   
	  var result = {};
	  for (var i = 0; i < str.length; i++) {
	      var cur = str[i].split('=');
	      result[cur[0]] = cur[1];
	  }
	  return result;
	  
  }