/**
 * Created by yao on 2019/1/8.
 */
layui.use(['form', 'layedit','upload'], function () {
    var form = layui.form;
    var layedit = layui.layedit;
    var upload = layui.upload;

    //监听提交
    form.on('submit(inputForm)', function(data){
        $("#inputForm").submit();
    });
    //上传封面图
    var uploadInst = upload.render({
        elem: '#checkImg'
        , url: '/util/fileUpload' //接口url
        , before: function (obj) {
            //预读本地文件示例，不支持ie8
            obj.preview(function (index, file, result) {
                $('#photo').attr('src', result); //图片链接（base64）
            });
        }
        , done: function (res) {
            //如果上传失败
            if (res > 0) {
                return layer.msg('上传失败！');
            } else {
                console.log(res)
                return $('#firstImg').val(res.data.src);
            }
            //上传成功
        }
        , error: function () {
            //演示失败状态，并实现重传
            var demoText = $('#demoText');
            demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
            demoText.find('.demo-reload').on('click', function () {
                uploadInst.upload();
            });
        }
    });


    // 编辑器上传图片接口
    layedit.set({
        uploadImage: {
            url: '/util/fileUpload' //接口url
            , type: 'post' //默认post
        }
    });
    //创建一个编辑器
    var editIndex = layedit.build('content', {
        tool: [
            'strong' //加粗
            , 'left' //左对齐
            , 'center' //居中对齐
            , 'link' //超链接
            , 'unlink' //清除链接
            , 'face' //表情
            
            , 'image' //插入图片
        ]
    });
});