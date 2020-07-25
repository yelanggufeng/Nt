$(function(){
    $('.fkyy1').hide()
    $('.bg_27').css('backgroundSize', '100% 100%')
    $('.L127_content_left_text1').click(function(){
        $(this).find('.fkyy1').show()
        $(this).css('background-image','url(/xwyjs/images/27/left_bg27.png)')
        $(this).css('background-repeat','no-repeat')
        $(this).css('background-position','0.25px -2.5px')
        $(this).css('backgroundSize', '102% 110%')
        $(this).find('img').css('width','102%')
        $(this).find('img').css('height','108%')
        $(this).siblings().css('background-image','')
        $(this).siblings().find('.fkyy1').hide()
    })
    $('.L127_content_left1').hide()
    $('.L127_content').addClass('L127_content_1')
    $('.L127_content_left_icon').click(function(){
        if($(this).parent()[0].offsetWidth>110){
            $('.L127_content').removeClass('L127_content_1')
            $('.L127_content').addClass('L127_content_2')
            $('.L127_content_left').hide()
            $('.L127_content_left1').show()
        } else {
            $('.L127_content').removeClass('L127_content_2')
            $('.L127_content').addClass('L127_content_1')
            $('.L127_content_left1').hide()
            $('.L127_content_left').show()
        }
    })
    $('.I127_paging1').click(function(){
        $(this).addClass('I127_paging_blue')
        $(this).siblings().removeClass('I127_paging_blue')
        var that = this;
        setTimeout(function() {
            $(that).removeClass('I127_paging_blue')
        }, 1000);
    })
    $('.I127_paging3').click(function(){
        $(this).addClass('I127_paging_blue')
        $(this).siblings().removeClass('I127_paging_blue')
        var that = this;
        setTimeout(function() {
            $(that).removeClass('I127_paging_blue')
        }, 2000);
    })
    $('.W127_wxbx').click(function(){
        $('.W127_down_up>div')[0].innerText = '首页>园区服务>物业服务>' + $(this)[0].innerText
    })
    $('.W127_tsjy').click(function(){
        $('.W127_down_up>div')[0].innerText = '首页>园区服务>物业服务>' + $(this)[0].innerText
    })
    $('.W127_hyyy').click(function(){
        $('.W127_down_up>div')[0].innerText = '首页>园区服务>物业服务>' + $(this)[0].innerText
    })

    // 永康市数字小微园政府监管应用 左侧栏
    $('.L227_C_L_button').click(function(){
        $(this).addClass('L227_C_L_button1')
        $(this).siblings().removeClass('L227_C_L_button1')
    })
    // 默认园区总览点击
    $('.L227_header2_center').addClass('L227_header2_blue')
    $('.L227_header2_center').find('img').attr('src','/xwyjs/images/27/L227_head_icon1_blue.png')
    $('.L227_header2_left').click(function(){
        $(this).addClass('L227_header2_blue')
        $(this).siblings().removeClass('L227_header2_blue')
        $(this).find('img').attr('src','/xwyjs/images/27/L227_head_icon1_blue.png')
        $('.L227_header2_center').find('img').attr('src','/xwyjs/images/27/L227_head_icon2.png')
        $('.L227_header2_right').find('img').attr('src','/xwyjs/images/27/L227_head_icon3.png')
    })
    $('.L227_header2_center').click(function(){
        $(this).addClass('L227_header2_blue')
        $(this).siblings().removeClass('L227_header2_blue')
        $(this).find('img').attr('src','/xwyjs/images/27/L227_head_icon2_blue.png')
        $('.L227_header2_left').find('img').attr('src','/xwyjs/images/27/L227_head_icon1.png')
        $('.L227_header2_right').find('img').attr('src','/xwyjs/images/27/L227_head_icon3.png')
    })
    $('.L227_header2_right').click(function(){
        $(this).addClass('L227_header2_blue')
        $(this).siblings().removeClass('L227_header2_blue')
        $(this).find('img').attr('src','/xwyjs/images/27/L227_head_icon3_blue.png')
        $('.L227_header2_center').find('img').attr('src','/xwyjs/images/27/L227_head_icon2.png')
        $('.L227_header2_left').find('img').attr('src','/xwyjs/images/27/L227_head_icon1.png')
    })

    // left227页面js
    // left
    $('.L227_Ul_second').slideUp()
    $('.L227_Ul_third').slideUp()
    $('.L227_sec_span1').hide()
    // 一级菜单点击
    $('.L127_Div_first').click(function(){
        // 当前项二级菜单展开
        var isShow = $(this).parent().find('.L227_Ul_second').is(':visible')
        // var isHide = $(this).parent().find('.L227_Ul_second').is(':hidden')
        if(isShow){
            $(this).parent().find('.L227_Ul_second').slideUp()
            $(this).removeClass('L127_Div_first_click')
            $(this).find('.L227_fir_span3 img').attr('src','/xwyjs/images/27/L327_left_icon_right.png')
        } else {
            $(this).parent().find('.L227_Ul_second').slideDown()
            $(this).parent().siblings().find('.L227_Ul_second').slideUp()
            $(this).addClass('L127_Div_first_click')
            $(this).parent().siblings().find('.L127_Div_first').removeClass('L127_Div_first_click')
            $(this).find('.L227_fir_span3 img').attr('src','/xwyjs/images/27/L327_left_icon_down.png')
            $(this).parent().siblings().find('.L227_fir_span3 img').attr('src','/xwyjs/images/27/L327_left_icon_right.png')
        }
        // 清除二级菜单样式
        $('.L127_Div_second').removeClass('L127_Div_second_click')
        $('.L227_sec_span1').hide()
        // 三级菜单隐藏
        $('.L227_Ul_third').slideUp()
        // 清除三级菜单样式
        $('.L227_Li_third').removeClass('L227_Li_third_click')
    })
    // 二级菜单点击
    $('.L127_Div_second').click(function(){
        // 当前项三级级菜单展开
        var isShow = $(this).parent().find('.L227_Ul_third').is(':visible')
        if(isShow){
            $(this).parent().find('.L227_Ul_third').slideUp()
            $(this).find('.L227_sec_span1').hide()
            $(this).removeClass('L127_Div_second_click')
        } else {
            $(this).parent().find('.L227_Ul_third').slideDown()
            $(this).parent().siblings().find('.L227_Ul_third').slideUp()
            $(this).find('.L227_sec_span1').show()
            $(this).parent().siblings().find('.L227_sec_span1').hide()
            $(this).addClass('L127_Div_second_click')
            $(this).parent().siblings().find('.L127_Div_second').removeClass('L127_Div_second_click')
        }
        // 清除三级菜单样式
        $('.L227_Li_third').removeClass('L227_Li_third_click')
    })
    // 三级点击
    $('.L227_Li_third').click(function(){
        $(this).addClass('L227_Li_third_click')
        $(this).siblings().removeClass('L227_Li_third_click')
    })
    // left1
    $('.L227_Ul1_second').slideUp()
    $('.L227_Ul1_third').slideUp()
    $('.L227_sec1_span1').hide()
    // 一级菜单点击
    $('.L127_Div1_first').click(function(){
        // 当前项二级菜单展开
        var isShow = $(this).parent().find('.L227_Ul1_second').is(':visible')
        if(isShow){
            $(this).parent().find('.L227_Ul1_second').slideUp()
            $(this).removeClass('L127_Div1_first_click')
            $(this).find('.L227_fir1_span3 img').attr('src','/xwyjs/images/27/L327_left_icon_right.png')
        } else {
            $(this).parent().find('.L227_Ul1_second').slideDown()
            $(this).parent().siblings().find('.L227_Ul1_second').slideUp()
            $(this).addClass('L127_Div1_first_click')
            $(this).parent().siblings().find('.L127_Div1_first').removeClass('L127_Div1_first_click')
            $(this).find('.L227_fir1_span3 img').attr('src','/xwyjs/images/27/L327_left_icon_down.png')
            $(this).parent().siblings().find('.L227_fir1_span3 img').attr('src','/xwyjs/images/27/L327_left_icon_right.png')
        }
        // 清除二级菜单样式
        $('.L127_Div1_second').removeClass('L127_Div1_second_click')
        $('.L227_sec1_span1').hide()
        // 三级菜单隐藏
        $('.L227_Ul1_third').slideUp()
        // 清除三级菜单样式
        $('.L227_Li1_third').removeClass('L227_Li1_third_click')
    })
    // 二级菜单点击
    $('.L127_Div1_second').click(function(){
        // 当前项三级级菜单展开
        var isShow = $(this).parent().find('.L227_Ul1_third').is(':visible')
        if(isShow){
            $(this).parent().find('.L227_Ul1_third').slideUp()
            $(this).find('.L227_sec1_span1').hide()
            $(this).removeClass('L127_Div1_second_click')
        } else {
            $(this).parent().find('.L227_Ul1_third').slideDown()
            $(this).parent().siblings().find('.L227_Ul1_third').slideUp()
            $(this).find('.L227_sec1_span1').show()
            $(this).parent().siblings().find('.L227_sec1_span1').hide()
            $(this).addClass('L127_Div1_second_click')
            $(this).parent().siblings().find('.L127_Div1_second').removeClass('L127_Div1_second_click')
        } 
        // 清除三级菜单样式
        $('.L227_Li1_third').removeClass('L227_Li1_third_click')
    })
    // 三级点击
    $('.L227_Li1_third').click(function(){
        $(this).addClass('L227_Li1_third_click')
        $(this).siblings().removeClass('L227_Li1_third_click')
    })

    // left1默认隐藏
    $('.L227_content_left1').hide()

    // 点击收缩按钮
    $('.L227_content_left_icon img').click(function(){
        $('.L227_content_left').hide()
        $('.L227_content_left1').show()
        $('.L227_main').addClass('L227_content1')
        $('.L227_main').removeClass('L227_content')
    })
    $('.L227_content_left1_icon img').click(function(){
        $('.L227_content_left1').hide()
        $('.L227_content_left').show()
        $('.L227_main').addClass('L227_content')
        $('.L227_main').removeClass('L227_content1')
    })
})
