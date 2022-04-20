$(document).ready(function () {
    $('.menu-tab-content:not(:first)').hide();
    $('.menu-tab-nav li a').click(function () {
        $('.menu-tab-nav li a.active').removeClass('active');
        var tabDivId = $(this).attr('href');
        $(this).addClass('active').siblings().removeClass('active');
        $('.menu-tab-content').hide();
        $(tabDivId).show();
    });
});




