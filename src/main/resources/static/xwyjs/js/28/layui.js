layui.use('form', function(){
    var form = layui.form;
    //监听提交
    form.on('submit(formDemo)', function(data){
      layer.msg(JSON.stringify(data.field));
      return false;
    });
});
///////////////////////////////////////会议弹窗的js//////////////////////////////////////////////////////////////
//时间控件
layui.use('laydate', function(){
    var laydate = layui.laydate;
    //执行一个laydate实例
    laydate.render({
      elem: '#test1', //指定元素
      type:'datetime',
      format:'yyyy-MM-dd HH:mm',
      value:'2018-03-18 9:00'
    });
    laydate.render({
      elem: '#test2', //指定元素
      type:'datetime',
      format:'yyyy-MM-dd HH:mm',
      value:'2018-03-18 11:00'
    });
  });
/////////////////////////////////////////通知弹框的js///////////////////////////////////////////////////

//附件上传
layui.use('upload', function(){
  var upload = layui.upload;
   
  //执行实例
  var uploadInst = upload.render({
    elem: '#T128_chuan' //绑定元素
    ,url: '/upload/' //上传接口
    ,done: function(res){
      //上传完毕回调
    }
    ,error: function(){
      //请求异常回调
    }
  });
});
//图片上传
layui.use('upload', function(){
    var $ = layui.jquery
        ,upload = layui.upload;

    //普通图片上传
    var uploadInst = upload.render({
        elem: '#T128_imgUpload'
        ,url: '/upload/'
        ,accept:'images'
        ,size:50000
        ,before: function(obj){

            obj.preview(function(index, file, result){

                $('#T128_yulan').attr('src', result);
            });
        }
        ,done: function(res){
            //如果上传失败
            if(res.code > 0){
                return layer.msg('上传失败');
            }
            //上传成功
            var demoText = $('#demoText');
            demoText.html('<span style="color: #4cae4c;">上传成功</span>');

            var fileupload = $(".image");
            fileupload.attr("value",res.data.src);
            console.log(fileupload.attr("value"));
        }
        ,error: function(){
            //演示失败状态，并实现重传
            var demoText = $('#demoText');
            demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
            demoText.find('.demo-reload').on('click', function(){
                uploadInst.upload();
            });
        }
    });


});
/////////////////////////////////////////////////////通知弹框2的js/////////////////////////////////////////////////////
//树形菜单控件
layui.use('tree', function(){
    var tree = layui.tree;
    //渲染
    var inst1 = tree.render({
      elem: '#demo1' , //绑定元素
      showCheckbox:true,//显示复选框
      showLine:false, //不开启连接线
      id:'index',
      data: [{
          title:'全选',
          spread:true,
          children:[{
       title:'东城街道',
       children: [{
           title: '黄山小微园' //二级菜单
          ,children: [{
                title: '亦杰国际贸易'//三级菜单
            },{
                title:'星柏毅科技'
            }]
          },{
            title:'龙川小微园',//二级菜单
            children: [{
                title: '亦杰国际贸易'//三级菜单
            },{
                title:'星柏毅科技'
            }]
          }]
      },{
        title:'西城街道',
        children: [{
            title: '黄山小微园' //二级菜单
            ,children: [{
                    title: '亦杰国际贸易'//三级菜单
                },{
                    title:'星柏毅科技'
                }]
            },{
                title:'龙川小微园',//二级菜单
                children: [{
                    title: '亦杰国际贸易'//三级菜单
                },{
                    title:'星柏毅科技'
            }]
        }]
      },{
        title:'江南街道',
        children: [{
            title: '黄山小微园' //二级菜单
            ,children: [{
                    title: '亦杰国际贸易'//三级菜单
                },{
                    title:'星柏毅科技'
                }]
                },{
                title:'龙川小微园',//二级菜单
                children: [{
                    title: '亦杰国际贸易'//三级菜单
                },{
                    title:'星柏毅科技'
            }]
        }]
      },{
        title:'芝英街道',
        children: [{
            title: '黄山小微园' //二级菜单
            ,children: [{
                    title: '亦杰国际贸易'//三级菜单
                },{
                    title:'星柏毅科技'
                }]
                },{
                title:'龙川小微园',//二级菜单
                children: [{
                    title: '亦杰国际贸易'//三级菜单
                },{
                    title:'星柏毅科技'
            }]
        }]
      },{
        title:'石 柱 镇',
        children: [{
            title: '黄山小微园' //二级菜单
            ,children: [{
                    title: '亦杰国际贸易'//三级菜单
                },{
                    title:'星柏毅科技'
                }]
                },{
                title:'龙川小微园',//二级菜单
                children: [{
                    title: '亦杰国际贸易'//三级菜单
                },{
                    title:'星柏毅科技'
            }]
        }]
      },{
        title:'象 珠 镇',
        children: [{
            title: '黄山小微园' //二级菜单
            ,children: [{
                    title: '亦杰国际贸易'//三级菜单
                },{
                    title:'星柏毅科技'
                }]
                },{
                title:'龙川小微园',//二级菜单
                children: [{
                    title: '亦杰国际贸易'//三级菜单
                },{
                    title:'星柏毅科技'
            }]
        }]
      },{
        title:'龙 山 镇',
        children: [{
            title: '黄山小微园' //二级菜单
            ,children: [{
                    title: '亦杰国际贸易'//三级菜单
                },{
                    title:'星柏毅科技'
                }]
                },{
                title:'龙川小微园',//二级菜单
                children: [{
                    title: '亦杰国际贸易'//三级菜单
                },{
                    title:'星柏毅科技'
            }]
        }]
      }]
      }]
    });
    
  });
////////////////////////////////////////////////////园区档案js///////////////////////////////////////////////////////////
//时间控件
layui.use('laydate', function(){
    var laydate = layui.laydate;
    //执行一个laydate实例
    laydate.render({
      elem: '#Y128_starttime', //指定元素
      type:'datetime',
      format:'yyyy-MM-dd HH:mm',
      
    });
    laydate.render({
        elem: '#Y128_endtime', //指定元素
        type:'datetime',
        format:'yyyy-MM-dd HH:mm'
    });
    laydate.render({
        elem: '#Y128_tytime', //指定元素
        type:'datetime',
        format:'yyyy-MM-dd HH:mm'
    });
  });
