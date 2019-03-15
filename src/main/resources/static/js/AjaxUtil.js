var AjaxUtil = AjaxUtil || {};
AjaxUtil.utils = {};
(function(module,$, undefined){
	
	module().init = function(){
		AjaxUtil.utils.sendGetRequest();
		AjaxUtil.utils.sendPostRequest();
		AjaxUtil.utils.sendDeleteRequest();
		AjaxUtil.utils.sendPutRequest();
		AjaxUtil.utils.sendAjaxRequest();
	};
	
	module().sendGetRequest = function(url, successCallback, failureCallback){	
		var ajaxObj={};
		ajaxObj["type"]='GET';
		ajaxObj["url"]=url;
		ajaxObj["success"]=successCallback;
		ajaxObj["error"]=failureCallback;
		module().sendAjaxRequest(ajaxObj);
	};
	
	module().sendPostRequest = function(url, successCallback, failureCallback, requestBody){
		var ajaxObj={};
		ajaxObj["type"]='POST';
		ajaxObj["url"]=url;
		ajaxObj["data"]=JSON.stringify(requestBody);
		ajaxObj["success"]=successCallback;
		ajaxObj["error"]=failureCallback;
		module().sendAjaxRequest(ajaxObj);
	};
	
	module().sendDeleteRequest = function(url, successCallback, failureCallback){
		var ajaxObj={};
		ajaxObj["type"]='DELETE';
		ajaxObj["url"]=url;
		ajaxObj["success"]=successCallback;
		ajaxObj["error"]=failureCallback;
		module().sendAjaxRequest(ajaxObj);
	};
	
	module().sendPutRequest = function(url, successCallback, failureCallback, requestBody){
		var ajaxObj={};
		ajaxObj["type"]='PUT';
		ajaxObj["url"]=url;
		ajaxObj["data"]=JSON.stringify(requestBody);
		ajaxObj["success"]=successCallback;
		ajaxObj["error"]=failureCallback;
		module().sendAjaxRequest(ajaxObj);
	};
	
	module().sendAjaxRequest = function(ajaxObj){
/*		 if ((typeof ajaxObj == undefined) ||(typeof ajaxObj["url"] == undefined) || (ajaxObj["url"] == null)) {
			 return;
		 }*/
		ajaxObj["contentType"]="application/json; charset=utf-8";
		ajaxObj["accept"]="application/json; charset=utf-8";
		ajaxObj["dataType"]="json";
		$.ajax(ajaxObj);
	};

})(function() {return AjaxUtil.utils;}, jQuery);


$( document ).ready(function() {
	AjaxUtil.utils.init();
});