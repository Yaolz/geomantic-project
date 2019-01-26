/**
 * Created by yao on 2019/1/15.
 */
layui.use(['form', 'layedit','upload'], function () {
    var form = layui.form;
    var layedit = layui.layedit;
    var upload = layui.upload;

    form.verify({
        img: function (value) {
            if(value==null||value==''){
                return '请选择封面图！';
            }
        },
        pro_img: function (value) {
            if(value==null||value==''){
                return '请选择商品图！';
            }
        },
        pro_imgs: function (value) {
            if(value==null||value==''){
                return '请选择商品详情图！';
            }
        },
        content:function (value) {
            if (value == null || value == '') {
                return '请输入资讯内容！';
            }
        },
        number: [/^[0-9]*$/, '只能输入数字！'],
        price:[/^[1-9]\d*(\.\d{1,2})?$|^[0]\.\d{1,2}$/g,'请输入有效价格！']

    });
    //监听提交
    form.on('submit(inputForm)', function(data){
        $("#inputForm").submit();
    });
    // window.resetForm= function() {
    //     alert(1)
    //     // document.getElementById("inputForm").reset();//js 重置
    //     $('#inputForm')[0].reset();
    //     form.render();
    // };
    //上传封面图
    var uploadInst = upload.render({
        elem: '#checkImg'
        , url: '/uploadFile' //接口url
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
                $('#demoText').empty();
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
    //多图片上传
    upload.render({
        elem: '#checkImgs'
        ,url: '/uploadFile'
        ,multiple: true
        ,before: function(obj){
            //预读本地文件示例，不支持ie8
            obj.preview(function(index, file, result){
                // $('#demo2').append('<img src="'+ result +'" alt="'+ file.name +'" class="layui-upload-img">')
            });
        }
        ,done: function(res){
            if (res > 0) {
                return layer.msg('上传失败！');
            } else {
                var srcData = res.data.src;
                $('#demo2').append('<div style="float:left" id="'+srcData.split("/")[5].split(".")[0]+'div">' +
                    '<a href=\"javascript:;\" style="cursor:pointer" onclick="upImg('+"'"+srcData+"'"+','+"'"+srcData.split("/")[5].split(".")[0]+"'"+')" id ="'+srcData.split("/")[5].split(".")[0]+'"><img src="'+ srcData+'"  class="layui-upload-img"></a><br />' +
                    '<a href=\"javascript:;\" style="cursor:pointer" onclick="deleteImg('+"'"+srcData+"'"+','+"'"+srcData.split("/")[5].split(".")[0]+"'"+')"><i class="layui-icon">&#xe640;</i></a>' +
                    '</div>')

                var imgStr = $("#firstImgs").val();
                if(imgStr!=null&&imgStr!=''){
                  imgStr =  imgStr+","+srcData;
                }else {
                    imgStr = srcData;
                }
                return $('#firstImgs').val(imgStr);
            }
        }
    });

    // 编辑器上传图片接口
    layedit.set({
        uploadImage: {
            url: '/uploadFile' //接口url
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
    var firstImgs =$("#firstImgs").val();
    if(firstImgs!=null&&firstImgs!=''){
        var data = firstImgs.split(',');
        for(var i=0,size = data.length; i < size; i++){
            $('#demo2').append('<div style="float:left;" id="'+data[i].split("/")[5].split(".")[0]+'div">' +
                '<a href=\"javascript:;\" class ="bg-hand" onclick="upImg('+"'"+data[i]+"'"+','+"'"+data[i].split("/")[5].split(".")[0]+"'"+')" id ="'+data[i].split("/")[5].split(".")[0]+'"><img src="'+ data[i] +'" class="layui-upload-img"></a><br />' +
                '<a href=\"javascript:;\"  class ="bg-hand"  onclick="deleteImg('+"'"+data[i]+"'"+','+"'"+data[i].split("/")[5].split(".")[0]+"'"+')"><i class="layui-icon">&#xe640;</i></a>' +
                '</div>')
        }
    }
    window.upImg = function (value,id) {
        //图片更新
        upload.render({
            elem: '#'+id
            ,url: '/uploadFile'
            ,before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    console.log(result)
                    // document.getElementById(id).getElementsByTagName("img")[0].src=result;
                    $("#"+id+" img").attr("src",result);//修改选中的图片
                    // $('#'+id).attr('src',result)
                });
            }
            ,done: function(res){
                if (res > 0) {
                    return layer.msg('上传失败！');
                } else {
                    var imgStr = $("#firstImgs").val();
                    if(imgStr!=null&&imgStr!=''){
                        imgStr = imgStr.replace(value,res.data.src);
                    }
                    return $('#firstImgs').val(imgStr);
                }
            }
        });
    }
    window.deleteImg = function (value,id) {
        var div = document.getElementById(id+"div");
        if (div != null)
            div.parentNode.removeChild(div);
        var imgStr = $("#firstImgs").val();
        if(imgStr!=null&&imgStr!=''){
            imgStr = imgStr.replace(value+',','');
    }
        return $('#firstImgs').val(imgStr);
    }
});