$(function () {
    $("button").click(function () {
        var name = $("#name").val();
        var grade = $("select option:selected").val();
        alert(name+grade)
        $.post('/all', {
            name: name,
            grade: grade
        }, function (result) {
            var tableIns = table.render({
                elem: '#table'
                ,cols: [ {field: 'id', title: 'ID', align: 'center'}
                    , {field: 'name', title: '姓名', align: 'center'}
                    , {field: 'age', title: '年龄', align: 'center'}
                    , {field: 'result', title: '成绩', align: 'center'}
                    , {field: 'grade', title: '班级', align: 'center'}
                    , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 150, align: 'center'}] //设置表头
                ,data:result.data //设置异步接口

            });
        })
    })
})