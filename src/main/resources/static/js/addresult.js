$(function () {
    $("button").click(function () {
        var name=$("#name").val();
        var result=$("#result").val();
        if (name==""||result==""){
            alert("请把信息填写完整")
        }else{
            $.post('addresult',{
                name:name,
                result:result,
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