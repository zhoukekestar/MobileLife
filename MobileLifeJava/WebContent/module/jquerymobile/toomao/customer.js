$(document).bind("mobileinit", function () {
    $.extend($.mobile, {
        defaultPageTransition: 'flow',
        pageLoadErrorMessage: '您访问的页面不存在',
    });
});



// This file should be placed after jquery but before jquery.mobile.
// AS FOLLOWS:

//<script src="js/jquery.min.js"></script>
//<script>
//    $(document).bind("mobileinit", function () {
//        $.mobile.
//         $.extend($.mobile, {
//             defaultPageTransition: 'flow',
//             pageLoadErrorMessage: '您访问的页面不存在',

//         });
//    });
//</script>
//<script src="module/jquerymobile/jquery.mobile-1.4.3.min.js"></script>