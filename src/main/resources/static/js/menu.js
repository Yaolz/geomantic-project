/**
 * Created by yao on 2018/12/19.
 */
    var message;
    layui.config({
        base: '/js/home/'
    }).use(['app', 'message','element','form','table'], function () {
        var element = layui.element;
        var form = layui.form;
        var table = layui.table,
            app = layui.app,
            layer = layui.layer,
            $ = layui.jquery;
        //将message设置为全局以便子页面调用
        message = layui.message;
        //主入口
        app.set({
            type: 'iframe'
        }).init();

    $(function () {
        //操作成功提示
        var msg=$("#msg").val();
        if (msg!= null && msg.trim() != '') {
            layer.msg(msg);
        }
        //初始化数据
        /*    $.post('/data/menu/get', {
            data:{pageNo:1,pageSize:30}
        });
        var form = document.createElement("form");
         form.action = "/page/menu/get";
         form.method="post";
         var input = document.createElement("input");
         input.type = "hidden";
         input.name = "permission"
         input.value = "permission"
         form.appendChild(input);
         $(document.body).append(form);
         form.submit();*/

    });

    //渲染table数据
    table.render({
        elem: '#menuList'
        ,url: '/data/menu/get'
        ,cols: [[
            {checkbox: true, fixed: true}
            ,{field:'parentId', title:'编号', width:60}
            ,{field:'icon', title:'图标', width:70}
            ,{field:'name', title:'菜单名称', width:100,height:160}
            ,{field:'href', title:'菜单URL', width:250,height:160}
            ,{field:'isShow', title:'状态', width:100,height:160}
            ,{field:'permission', title:'权限', width:60,height:160}
            ,{field:'remarks', title:'备注信息', width:300,height:160}
            ,{field:'createBy', title:'创建人', width:100,height:160}
            ,{field:'createDate', title:'创建时间', width:180,height:160}
            ,{field:'updateBy', title:'修改人', width:100,height:160}
            ,{field:'updateDate', title:'修改时间', width:180,height:160}
        ]]
        ,id: 'table'
        ,page: true
        ,width:1600
        ,height: 500
        ,request: {
            pageName: 'pageNo' //页码的参数名称，默认：page
            ,limitName: 'pageSize' //每页数据量的参数名，默认：limit
        }
        ,response: {
            statusName: 'code'
            ,statusCode: '0000'
            ,msgName: 'msg'
            ,countName: 'total'
            ,dataName: 'body'
        }
    });

    $('.bg-Btn .layui-btn').on('click', function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

    var active = {
        refreshBtn:function () {
            location.reload(true);
        },
        updateBtn: function(){ //验证是否全选
            var checkStatus = table.checkStatus('table')
                ,data = checkStatus.data;
            if(data.length == 1) {
                window.open("/page/menu/updatePg?id="+data[0].id)
            } else {
                layer.msg("请选择一行！");
            }
        }

    };

    //监听提交
    form.on('submit(update)', function (data) {
        var index = layer.load(0, {shade: false});
        $.ajax({
            async:false,
            type: "POST",//方法类型
            dataType: "json",//服务器返回的数据类型
            contentType: "application/json",//提交数据格式
            url: "/data/menu/add" ,//url
            data:  JSON.stringify(data.field),
            success: function (result) {
                layer.close(index);
                if (result.code == '0000') {
                    layer.msg("添加成功！");
                } else {
                    layer.msg(result.msg);
                }
            },
            error : function() {
                layer.close(index);
                layer.msg("添加失败! ")
            }
        });

    });

});

function addIcon() {
    layer.open({
        type: 1,
        title: ['图标', 'font-size:18px;'],
        area: ['60%', '70%'],
        shadeClose: false,
        shade: [0.1, '#000'],
        isOutAnim: false,
        content: $("#icons")
    })
}



