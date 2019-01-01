/**
 * Created by yao on 2019/1/1.
 */
layui.use(['form', 'layedit','iconPicker'], function () {
    var form = layui.form;
    var icon = layui.iconPicker;

    icon.render({
        // 选择器，推荐使用input
        elem: '#icon',
        // 数据类型：fontClass/unicode，推荐使用fontClass
        type: 'fontClass',
        // 是否开启搜索：true/false
        search: true,
        // 点击回调
        click: function (data) {
            console.log(data);
        }
    });

    /**
     * 选中图标 （常用于更新时默认选中图标）
     * @param filter lay-filter
     * @param iconName 图标名称，自动识别fontClass/unicode
     */
    icon.checkIcon('iconPicker', 'layui-icon-star-fill');

    //监听提交
    form.on('submit(inputForm)', function(data){
        $("#inputForm").submit();
    });
  var option =  $("#option").val();
  if(option=='addChild'){
    document.getElementById("id").style.display = "none";
    document.getElementById("pid").style.display = "none";
  }
    if(option=='add'){
        document.getElementById("parentId").value= "0";
        document.getElementById("id").style.display = "none";
        document.getElementById("parentIds").value = "0,";
        document.getElementById("pid").style.display = "none";
    }
});