
/*---------------------------------------------------------------------------------------------
* Filename:						base.util.js
* Description:					Global Base Tools Javascript
* Version:						1.0.0(2014-06-26)
* Website:						http://www.toomao.com
* Author:						zhoukeke
* 
==STRUCTURE:===================================================================================
* display:						show or hidden something.
* getData:						Get data by "get" method.
* postData:						Get data by "post" method.
* 
==LOG:=========================================================================================
* Modified:						by zhoukeke on(2014-03-21)
								Change some lines to one line.
								
---------------------------------------------------------------------------------------------*/
function getData(D_url, D_callback){
    $.ajax({
        type: 'get',
        url: D_url,
        dataType: "jsonp",
        jsonp: "callback",
        async: true,
        success: function (data) {
        	D_callback(data);
        },
        error:function(){
            console.log("Error: base.util.js > getData: url:" + D_url + " callback:" + D_callback);
        }
    });
}
function postData(D_url, D_data, D_callback){
    $.ajax({
        type: 'post',
        url: D_url,
        dataType: "jsonp",
        jsonp: "callback",
        async: true,
        data: D_data,
        success: function (data) {
        	D_callback(data);
        },
        error:function(){
            console.log("Error: base.util.js > postData: url:" + D_url + " data:" + D_data + " callback:" + D_callback);
        }
    });
}
function postPic(D_url, D_data, D_callback){
    $.ajax({
        type: 'post',
        url: D_url,
        dataType: "jsonp",
        jsonp: "callback",
        async: true,
        contentType: "multipart/form-data",
        data: D_data,
        success: function (data) {
        	D_callback(data);
        },
        error:function(){
            console.log("Error: base.util.js > postData: url:" + D_url + " data:" + D_data + " callback:" + D_callback);
        }
    });
}
function json2str(o) { 
	var arr = []; 
	var fmt = function(s) 
	{ 
		if (typeof s == 'object' && s != null) 
			return json2str(s); 
		return /^(string|number)$/.test(typeof s) ? "'" + s + "'" : s; 
	} 
	for (var i in o) 
		arr.push("'" + i + "':" + fmt(o[i])); 
	return '{' + arr.join(',') + '}'; 
}