//判断数据是否为空
//    var _obj = "";
//    var _obj = " ";
//    var _obj = null;
//    var _obj = undefined;
//    var _obj = [];
//    var _obj = {};
//    var _obj = NaN;
function isBlank(_obj) {
    if(_obj === undefined) { // 只能用 === 运算来测试某个值是否是未定义的
        return true;
    }

    if(_obj == null) { // 等同于 _obj === undefined || _obj === null
        return true;
    }

    // String
    if(_obj === ""){ // "",null,undefined
        return true;
    }

    if(!_obj){ // "",null,undefined,N_objN
        return true;
    }

    if(!$.trim(_obj)){ // "",null,undefined
        return true;
    }

    // _objrr_objy
    if(_obj.length === 0){ // "",[]
        return true;
    }

    if(!_obj.length){ // "",[]
        return true;
    }

    // Object {}
    if($.isEmptyObject(_obj)){ // 普通对象使用 for...in 判断，有 key 即为 f_objlse
        return true;
    }

    return false;
}