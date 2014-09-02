
/*---------------------------------------------------------------------------------------------
* Filename:						base.tools.js
* Description:					Global Base Tools Javascript
* Version:						1.0.0(2014-07-23)
* Website:						http://www.toomao.com
* Author:						zhoukeke
* 
==STRUCTURE:===================================================================================
* display:						Jquery extend
* getData:						Get data by "get" method.
* postData:						Get data by "post" method.
* 
==LOG:=========================================================================================
* Modified:						by zhoukeke on(2014-07-23)
								Change some lines to one line.
								
---------------------------------------------------------------------------------------------*/
$.tools = {
    getData: function (D_url, D_callback) {
        $.ajax({
            type: 'get',
            url: D_url,
            dataType: "jsonp",
            jsonp: "callback",
            async: true,
            success: function (data) {
                D_callback(data);
            },
            error: function () {
                console.log("Error: $.toos.getData > getData: url:" + D_url + " callback:" + D_callback);
            }
        });
    },
    postData: function (D_url, D_data, D_callback) {
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
            error: function () {
                console.log("Error: $.tools.postData > postData: url:" + D_url + " data:" + D_data + " callback:" + D_callback);
            }
        });
    },
    json2str: function (o) {
        var arr = [];
        var fmt = function (s) {
            if (typeof s == 'object' && s != null)
                return json2str(s);
            return /^(string|number)$/.test(typeof s) ? "'" + s + "'" : s;
        }
        for (var i in o)
            arr.push("'" + i + "':" + fmt(o[i]));
        return '{' + arr.join(',') + '}';
    }
};

$(function () {
    $("div[data-role='popup'][data-position='window-bottom']").each(function () {
        var selector = $(this).attr("id");
        $("#" + selector + "-popup").addClass("popup-bottom");
        $("#" + selector).parent().bind("DOMNodeInserted", function () {
            try {
                $("#" + selector + "-popup").addClass("popup-bottom");
            } catch (e) {
                setTimeout(function () {
                    $("#" + selector + "-popup").addClass("popup-bottom");
                }, 3000);
            }
        });
    })
})