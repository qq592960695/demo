$(function () {
    $("button").click(function () {
        var name=$("#name").val();
        var age=$("#age").val();
        var grade=$("select option:selected").val();
        if (name==""||age==""||grade==""){
            alert("请把信息填写完整")
        }else{
            $.post('save',{
                name:name,
                age:age,
                gradeId:grade
            },function (result) {
                if (result.success==true){
                    alert(result.data)
                }else {
                    alert(result.msg)
                }
            })
        }

    })
})