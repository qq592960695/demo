$(function () {
    $("#registered").click(function () {
        var username=$("#username").val();
        var password=$("#password").val();
        $.post('updateRegistered',{
            username:username,
            password:password

        },function (result) {
            if (result.success==true){
                alert('注册成功')
                window.location.href='login'
            }else {
                $("p").html(result.msg)
            }
        })
    })
})