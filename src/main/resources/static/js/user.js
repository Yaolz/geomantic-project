/**
 * Created by yao on 2018/12/21.
 */
layui.use(['element','form','table'], function () {
    var element = layui.element;
    var form = layui.form;
    var table = layui.table,
        layer = layui.layer,
        $ = layui.jquery;

    $(function () {
        //操作成功提示
        var msg=$("#msg").val();
        if (msg!= null && msg.trim() != '') {
            layer.msg(msg);
        }
    });

    //渲染table数据
    table.render({
        elem: '#userList'
        ,url: '/data/userPage'
        ,cols: [[
            {checkbox: true, fixed: true}
            ,{field:'headphoto', title:'头像', width:90}
            ,{field:'nickName', title:'昵称', width:100}
            ,{field:'phone', title:'手机号', width:200}
            ,{field:'sex', title:'性别', width:60,height:50}
            ,{field:'autograph', title:'个性签名', width:250,height:160}
            ,{field:'address', title:'地址', width:300,height:160}
            ,{field:'state', title:'状态', width:60,height:160}
        ]]
        ,id: 'table'
        ,page: true
        ,width:1120
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
    form.on('submit(select)', function (data) {
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



