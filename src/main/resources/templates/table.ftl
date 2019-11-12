<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title></title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <style>

    </style>
    <script src="js/jquery.js"></script>
    <script src="layui/layui.js"></script>
    <script src="js/StudentQuery.js"></script>
</head>

<body class="layui-layout-body">
<div style="display: none" id="saveOrUpdata">
    <form class="layui-form" lay-filter="form" id="dataForm" style="margin-right: 30px;">
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-inline">
                <input type="text" name="name" required lay-verify="required" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">年级</label>
            <div class="layui-input-inline">
                <input type="text" name="grade" required lay-verify="required" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">成绩</label>
            <div class="layui-input-inline">
                <input type="number" name="result" required lay-verify="required" autocomplete="off"
                       class="layui-input">
            </div>
        </div>


        <div class="layui-form-item" style="width: 50%">
            <label class="layui-form-label">所在年级</label>
            <div class="layui-input-block">
                <select name="grade" lay-verify="required">
                    <option value="1">一年级</option>
                    <option value="2">二年级</option>
                    <option value="3">三年级</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo" id="but">修改</button>
            </div>
        </div>
    </form>
</div>
<div class="layui-layout layui-layout-admin">
    <#include "top.ftl" >
    <#include "left.ftl">
    <div class="layui-body">

        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <div class="layui-form-item">
                <label class="layui-form-label">姓名</label>
                <div class="layui-input-block">
                    <input id="name" type="text" name="title" lay-verify="title" autocomplete="off" placeholder="输入学生姓名"
                           class="layui-input" style="width: 50%;">
                </div>
                <br>
            </div>
            <form class="layui-form" action="" lay-filter="dataform">
                <div class="layui-form-item">
                    <label class="layui-form-label">年级选择</label>
                    <div class="layui-input-block" style="width: 47%;">
                        <select name="city" lay-verify="required">
                            <option value=""></option>
                            <option value="一年级">一年级</option>
                            <option value="二年级">二年级</option>
                            <option value="三年级">三年级</option>
                            <option value="四年级">四年级</option>
                            <option value="五年级">五年级</option>
                        </select>
                    </div>
                </div>
            </form>
            <form class="layui-form" action="">
                <button type="button" class="layui-btn layui-btn-sm">查询</button>
            </form>
            <div>
                <table class="layui-hide" id="table" lay-filter="userTable"></table>
            </div>
        </div>

    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script>

    layui.use(['table','layer'], function () {

        var table = layui.table;
        var layer=layui.layer;

        table.render({
            elem: '#table' //需要显示数据表格的table标签
            ,
            url: '/jing' //请求地址
            ,
            method: 'post' //请求方式
            ,
            response: {//后台返回的数据
                countName: 'count' //数据总数的字段名称，默认:count
                ,
                dataName: 'data' //数据列表字段名称，默认：data
            },
            page: true,//开启分页
            limits: ['10', '20', '30'],//分页每页显示数据条数（页面选择）
            cols: [[
                {field: 'id', title: 'ID', align: 'center'}
                , {field: 'name', title: '姓名', align: 'center'}
                , {field: 'age', title: '年龄', align: 'center'}
                , {field: 'result', title: '成绩', align: 'center'}
                , {field: 'grade', title: '班级', align: 'center'}
                , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 150, align: 'center'}
            ]]

        })
        table.on('tool(userTable)', function (obj) {
            var data = obj.data;
            //console.log(obj)
            if (obj.event === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    obj.del();
                    layer.close(index);
                    $.post('/del',{
                        id:obj.data.id
                    })
                });
            } else if (obj.event === 'edit') {
                modify(data);

        }
        });

        function modify(data) {
            layer.open({
                type: 1,
                title: "修改用户",
                skin: 'layui-layer-rim', //加上边框
                area: ['500px', '500px'], //设置宽高
                content: $("#saveOrUpdata"),
                success: function (index) {
                    form.val("form", data);
                }
            });
        }
    });
</script>
</body>
</html>