/**
 * index js
 */

function onSubmit(){
	var appid = $("appid").value;
	var appsecret = $("appsecret").value;
	
	if(appid == null || appid == ""){
		alert("appid cannot be empty!");
		return false;
	}
	if(appsecret == null || appsecret ==""){
		alert("appseret cannot be empty!");
		return false;
	}
	return true;
}