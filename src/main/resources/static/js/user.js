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

    $('.bg-table .layui-btn').on('click', function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

    var active = {
        delete: function(){ //验证是否全选
            var checkStatus = table.checkStatus('table')
                ,data = checkStatus.data;
            if(data.length == 1) {

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



