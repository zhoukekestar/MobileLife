
$(function () {

    function getObjectURL(file) {
        var url = null;
        if (window.createObjectURL != undefined) { // basic
            url = window.createObjectURL(file);
        } else if (window.URL != undefined) { // mozilla(firefox)
            url = window.URL.createObjectURL(file);
        } else if (window.webkitURL != undefined) { // webkit or chrome
            url = window.webkitURL.createObjectURL(file);
        }
        return url;
    }

    $.fn.toomaoUpload = function (done_callback) {


        (function (selector) {
            var id = selector.substr(1);
            $(selector)
                .wrap('<div class="upload-btn fileupload-warp"></div>');

            $(selector).parent()
                .wrap('<div class="file-upload-div-all" id="' + id + '-div-all"></div>')
                .before("<span class='del' style='display:none'></span>")
                .before('<img class="preView" style="display:none" />')
                .after('<div class="progress"></div><a class="msg" target="_blank"></a>')
        })($(this).selector);

        var name = $(this).selector + "-div-all";
        var $this = $(name);

        $(this).change(function () {
            
            var objUrl = getObjectURL(this.files[0]);
            //console.log("objUrl = " + objUrl);
            if (objUrl) {

                $this.children(".preView").attr("src", objUrl).show();
                $this.children(".del").show();
                $this.children(".msg").show();
                $this.children(".fileupload-warp").hide();
            }
        });
        
        $this.children(".del").click(function(){
        	$this.children(".preView").hide();
        	$this.children(".fileupload-warp").show();
        	$this.children(".msg").hide();
        	$this.children(".del").hide();
        });

        $(this).fileupload({
            //url: "http://localhost/jupload/index.php",
            url: "http://192.168.0.222:8080/PhoneWeb/jqueryFileUpload",
            dataType: 'json',
            add: function (e, data) {

                $this.children(".msg").html("上传").click(function () {
                	$this.children(".del").hide();
                    $(this).html("上传中");
                    data.submit();
                })
            },
            done: function (e, data) {
            	console.log("done");
                $.each(data.result.files, function (index, file) {
                    $this.children(".msg").html("上传成功").attr("href", file.filePath);
                    
                    if (done_callback != undefined)
                    	done_callback(file.filePath);
                    else{
                    	$this.after('<input type="hidden" name = "pic" value="'+file.filePath+'">');
                    }
                    //$('<p/>').text(file.fileName).appendTo(document.body);
                    //$('<a href="' + file.filePath + '"/>').text(file.fileName).appendTo(document.body);
                });
            },
            progressall: function (e, data) {

                var progress = parseInt(data.loaded / data.total * 100, 10);
                $this.children('.progress').css(
                    'width',
                    progress + '%'
                );
            }

        });
    }

    $.fn.toomaoUpload_url = function () {
        var name = $(this).selector + "-div-all";
        return $(name).children(".msg").attr("href");
    }
});