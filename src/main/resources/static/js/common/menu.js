//后台列表通用js
layui.config({
    base: '/layui_exts/' //配置 layui 第三方扩展组件存放的基础目录
}).extend({
    treetable: 'treeTable/treeTable' //以 regionSelect 组件为例，定义该组件模块名
}).use(['layer', 'table', 'treetable'], function () {
    var $ = layui.jquery;
    var table = layui.table;
    var layer = layui.layer;
    var treetable = layui.treetable;

    // 渲染表格
    var renderTable = function () {
        layer.load(2);
        treetable.render({
            treeColIndex: 1,
            treeSpid: 0,
            treeIdName: 'id',
            treePidName: 'parentId',
            treeDefaultClose: true,
            treeLinkage: false,
            elem: '#table1',
            url: '/data/menu/list',
            page: false,
            cols: [[
                {type: 'numbers'},
                {field: 'name', width: 200, title: '名称'},
                {field: 'id', width: 200, title: 'id'},
                {field: 'sort', width: 200, templet: function (d) {
                        return '<input class="layui-input" value="' + d.sort + '"/>';
                    }, title: '排序'},
                {field: 'parentId', width: 200, title: '父级ID'},
                {
                    field: 'isShow', width: 200, align: 'center', templet: function (d) {
                        if (d.isShow == 0) {
                            return '<span class="layui-badge layui-bg-gray">显示</span>';
                        } else {
                            return '<span class="layui-badge layui-bg-gray">隐藏</span>';
                        }
                    }, title: '是否显示'
                },
                {templet: '#oper-col', title: '操作'}
            ]],
            done: function () {
                layer.closeAll('loading');
            }
        });
    };

    renderTable();

    $('#btn-expand').click(function () {
        treetable.expandAll('#table1');
    });

    $('#btn-fold').click(function () {
        treetable.foldAll('#table1');
    });

    $('#btn-refresh').click(function () {
        renderTable();
    });

    //监听工具条
    table.on('tool(table1)', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;
        console.log(obj);
        console.log(data);
        if (layEvent === 'del') {
            layer.msg('添加下级' + data.id);
        } else if (layEvent === 'edit') {
            layer.msg('修改' + data.id);
        }
    });
});