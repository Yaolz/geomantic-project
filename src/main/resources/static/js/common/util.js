//判断数据是否为空
//    var _obj = "";
//    var _obj = " ";
//    var _obj = null;
//    var _obj = undefined;
//    var _obj = [];
//    var _obj = {};
//    var _obj = NaN;
function isBlank(_obj) {
    if (_obj === undefined) { // 只能用 === 运算来测试某个值是否是未定义的
        return true;
    }

    if (_obj == null) { // 等同于 _obj === undefined || _obj === null
        return true;
    }

    // String
    if (_obj === "") { // "",null,undefined
        return true;
    }

    if (!_obj) { // "",null,undefined,N_objN
        return true;
    }

    if (!$.trim(_obj)) { // "",null,undefined
        return true;
    }

    // _objrr_objy
    if (_obj.length === 0) { // "",[]
        return true;
    }

    if (!_obj.length) { // "",[]
        return true;
    }

    // Object {}
    if ($.isEmptyObject(_obj)) { // 普通对象使用 for...in 判断，有 key 即为 f_objlse
        return true;
    }

    return false;
}

//非空
function isNotBlank(_obj) {
    return !isBlank(_obj);
}

//后台列表通用js
layui.use(['laypage', 'layer'], function () {
    var laypage = layui.laypage;
    var layer = layui.layer;

    //分页组件
    laypage.render({
        elem: 'paging' //注意，这里的 paging 是 ID，不用加 # 号
        , count: $("#pageTotal").val()//[[${page.total}]] //数据总数，从服务端得到
        , curr: $("#pageNo").val() //[[${page.pageNum}]] //当前页数
        , limit: $("#pageSize").val() //[[${page.pageSize}]] //当前页数
        , layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']
        , jump: function (obj, first) {
            //点击分页触发效果，注以下ID名称在列表页请统一
            if (!first) {
                $("#pageNo").val(obj.curr);
                $("#pageSize").val(obj.limit);
                $("#inputForm").submit();
            }

        }
    });

    //提示
    var msg = $("#msg").val();
    if (isNotBlank(msg)) {
        layer.msg(msg);
    }
});