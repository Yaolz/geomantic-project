/**
 * Created by yao on 2018/12/27.
 */
var message;
layui.config({
    base: '/js/home/'
}).use(['app', 'message', 'form','element'], function () {
    var app = layui.app,
        $ = layui.jquery,
        layer = layui.layer
    //将message设置为全局以便子页面调用
    message = layui.message;
    var element = layui.element;
    var form = layui.form;
    //主入口
    app.set({
        type: 'iframe'
    }).init();
});