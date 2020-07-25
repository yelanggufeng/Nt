$(function () {
    function resize() {
        var windowW = $(window).width();
        var initWH = 1340 / 820;
        //1440尺寸下都用1280
        if (windowW <= 1440) {
            windowW = 1280;
        } else {
        }
        $("body,html").css({
            fontSize: windowW * 12 / 1280 + 'px'
        });
    }
    resize();
    $(window).bind("resize", resize)
});
$(document).ready(function () {
    // 轮播图自适应
    //$('.swiper-container').slide({mainCell:".bd ul",effect:"left",autoPlay:true});
    // $('.swiper-container').PageSwitch({
    //     direction:'horizontal',
    //     easing:'ease-in',
    //     duration:1000,
    //     autoPlay:true,
    //     loop:'false'
    // });


    //截取一定长度的字符串
    function len(str,num){
        if (str.length <= num){
            return str;
        }else{
            return str.substring(0,num) + "...";
        }
    }
    for (var i=0; i<$(".newsSubTitle>span").length; i++) {
        var content = $(".newsSubTitle>span").eq(i).html();
        $(".newsSubTitle>span").eq(i).html(len(content, 76));
    }

    // 循环粒子100个dom
    var htmlDom = '<div class="circle-container"><div class="circle"></div></div>';
    for (var i = 0; i < 100; i++) {
        $('.R121_cr_particle .container').append(htmlDom);
    }

});
