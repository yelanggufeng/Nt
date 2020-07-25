 // 图片轮播
 $(document).ready(function(){
   //  var i = 0;
   //  var j = 0;
   //  var timer,timer1;
   //  //用jquery方法设置第一张图片显示，其余隐藏
   //  $('.W128_x_left .item').eq(0).show().siblings('.W128_x_left .item').hide();
   //  $('.W128_x_left .W128_text').eq(0).show().siblings('.W128_x_left .W128_text').hide();
   //  $('.W128_right .item').eq(0).show();
   //  //调用showTime()函数（轮播函数）
   //  showTime();
   //  showTime1();
   //
   // //当鼠标经过下面的数字时，触发两个事件（鼠标悬停和鼠标离开）
   //  $('.W128_x_left .tab').hover(function(){
   //      //获取当前i的值，并显示，同时还要清除定时器
   //      i = $(this).index();
   //      Show();
   //      clearInterval(timer);
   //  },function(){
   //      showTime();
   //  });
   //
   //  $('.W128_right .tab').hover(function(){
   //      //获取当前i的值，并显示，同时还要清除定时器
   //      j = $(this).index();
   //      Show1();
   //      clearInterval(timer1);
   //  },function(){
   //      showTime1();
   //  });
   //  //创建一个showTime函数
   //  function showTime(){
   //      //定时器
   //      timer = setInterval(function(){
   //          //调用一个Show()函数
   //          Show();
   //
   //          i++;
   //          //当图片是最后一张的后面时，设置图片为第一张
   //          if(i==5){
   //              i=0;
   //          }
   //      },2000);
   //  }
   //  function showTime1(){
   //      //定时器
   //      timer1 = setInterval(function(){
   //          //调用一个Show()函数
   //          Show1();
   //          j++;
   //          //当图片是最后一张的后面时，设置图片为第一张
   //          if(j==3){
   //              j=0;
   //          }
   //      },2000);
   //  }
   //  //创建一个Show函数
   //  function Show(){
   //      //在这里可以用其他jquery的动画
   //      $('.W128_x_left .item').eq(i).fadeIn(300).siblings('.item').fadeOut(300);
   //      $('.W128_x_left .W128_text').eq(i).fadeIn(300).siblings('.W128_x_left .W128_text').fadeOut(300);
   //      //给.tab创建一个新的Class为其添加一个新的样式，并且要在css代码中设置该样式
   //      $('.W128_x_left .tab').eq(i).addClass('.W128_x_left active').siblings('.W128_x_left .tab').removeClass('active');
   //      $('.W128_x_left .tab').eq(i).find('img').attr('src','../../images/28/W128_circle1.png')
   //      $('.W128_x_left .tab').eq(i).siblings().find('img').attr('src','../../images/28/W128_circle.png')
   //  }
   //  function Show1(){
   //      //在这里可以用其他jquery的动画
   //      $('.W128_right .item').eq(j).fadeIn(300).siblings('.item').fadeOut(300);
   //      //给.tab创建一个新的Class为其添加一个新的样式，并且要在css代码中设置该样式
   //      $('.W128_right .tab').eq(j).addClass('.W128_right active1').siblings('.W128_right .tab').removeClass('active1');
   //      $('.W128_right .tab').eq(j).find('img').attr('src','../../images/28/W128_jx2.png')
   //      $('.W128_right .tab').eq(j).siblings().find('img').attr('src','../../images/28/W128_jx1.png')
   //  }
   //  $(".W128_daohang li").click(function(){
   //      $(this).addClass("W128_current").siblings().removeClass("W128_current")
   //  })
   //
   //  $(window).ready(function(){
   //      $(".W128_title .W128_t2").css("backgroundSize", "100% 100%");
   //      $(".W128_imgBg").css("backgroundSize", "100% 100%");
   //      $(".w128_inner .W128_rmzc").css("backgroundSize", "100% 100%");
   //      $(".W128_rmzc .W128_left").css("backgroundSize", "100% 100%");
   //      $(".W128_fw1_1, .W128_fw1_2, .W128_fw2_1,.W128_fw2_2").css("backgroundSize", "100% 100%");
   //      $(" .W128_i_btn").css("backgroundSize", "100% 100%");
   //      $(".W1").css("backgroundSize", "100% 100%");
   //      $(".X328_modal,.W128_modal").css("backgroundSize", "100% 100%");
   //      $("input").css("backgroundSize", "100% 100%");
   //      $("button").css("backgroundSize", "100% 100%");
   //  })
   //  $(".yema").click(function(){
   //
   //          if($(this).context.id=='first'){
   //              $('#first').css("background-color","#006ffd")
   //              $(this).addClass('factive').siblings().removeClass('factive')
   //          }else{
   //              $(this).addClass('factive').siblings().removeClass('factive')
   //              $('#first').css("background-color","#fff")
   //          }
   //      })
   //  if($("#first").css("background-color","#006ffd")){
   //  $('.prev').css('color','#999')
   //  }else{
   //      $('.prev').css('color','#333')
   //  }
    $("#login").click(function(){
        $("#W128_loginModal").show()
    })
    $("#W128_no,#W128_close").click(function(){
        $("#W128_loginModal").hide()
        $(".X328_m_input").val("")
    })

})
