$(function () {
    $("#landing").click(function () {
        var username=$("#username").val();
        var password=$("#password").val();
        $.post('erro',{
            username:username,
            password:password

        },function (result) {
                if (result.success==true){
                    window.location.href='information'
                }else {
                    $("p").html(result.msg)
                }
        })
    })
   $("#registered").click(function () {
       $.post('registered',function (result) {
           window.location.href='registered'
       })
   })
})