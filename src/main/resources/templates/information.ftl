<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title></title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script src="js/jquery.js"></script>
    <script src="js/information.js"></script>
    <style>
        button{
            margin-left: 40%;
            position: relative;
            top:50px;
        }
    </style>
    <script src="js/jquery.js"></script>
    <script src="layui/layui.js"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
<#include "top.ftl" >
<#include  "left.ftl">
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <div class="layui-form-item">
                <label class="layui-form-label">姓名</label>
                <div class="layui-input-block">
                    <input id="name" type="text" name="title" lay-verify="title" autocomplete="off" placeholder="输入学生姓名" class="layui-input" style="width: 50%;">
                </div>
                <label class="layui-form-label">年龄</label>
                <div class="layui-input-block">
                    <input id="age" type="text" name="title" lay-verify="title" oninput = "value=value.replace(/[^\d]/g,'')" autocomplete="off" placeholder="输入学生年龄" class="layui-input" style="width: 50%;">
                </div>
            </div>

            <form class="layui-form" action="">

                <div class="layui-form-item">
                    <label class="layui-form-label">年级选择</label>
                    <div class="layui-input-block" style="width: 50%;">
                        <select name="city" lay-verify="required" >
                            <option value=""></option>
                            <option value="1">一年级</option>
                            <option value="2">二年级</option>
                            <option value="3">三年级</option>
                            <option value="4">四年级</option>
                            <option value="5">五年级</option>
                        </select>
                    </div>
                    <button type="button" class="layui-btn layui-btn-sm">提交</button>
                    <p></p>
                </div>
        </form>














    </div>
</div>

<div class="layui-footer">
    <!-- 底部固定区域 -->
    © layui.com - 底部固定区域
</div>
</div>

<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });

    layui.use('form', function(){
        var form = layui.form;

        //监听提交
        form.on('submit(formDemo)', function(data){
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    });


</script>
</body>
</html>