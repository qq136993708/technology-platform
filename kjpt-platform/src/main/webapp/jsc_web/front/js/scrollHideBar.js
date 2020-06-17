$(function() {
    $('#scrollHideBar').css({ width: $(window).width() });
    $(window).resize(function() {
        $('#scrollHideBar').css({ width: $(window).width() });
    });
})