/**
 * Created by yao on 2018/12/17.
 */
//注意：导航 依赖 element 模块，否则无法进行功能性操作
layui.use(['element','form'], function () {
    var element = layui.element;
    var form = layui.form,
        layer = layui.layer,
        $ = layui.jquery;

    //自定义验证规则
    form.verify({
        pass: [/(.+){6,12}$/, '密码必须6到12位']
    });

    //监听提交
    form.on('submit(login)', function (data) {
        layer.load(0, {shade: false});
        console.log(data.field);
        $.post('/register',
            data.field,
            function (res) {
            console.log(res);
                if (res.code === '0000') {
                    alert(res);
                } else {
                    layer.closeAll();
                    layer.msg("手机号或者密码错误");
                }
            }, 'json'
        );
        return false;
    });

});

function login() {
    layer.open({
        type: 1,
        area: ['40%', '70%'],
        shadeClose: false,
        shade: [0.1, '#000'],
        content: $("#login")
    })
}

function register() {

}