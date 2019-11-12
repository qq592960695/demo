<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <script src="js/jquery.js"></script>
    <script src="js/registered.js"></script>
    <style type="text/css">
        .hander{
            text-align: center;
        }
        .center{
            float: right;
            width: 300px;
            height: 200px;
            position: relative;
            right: 7rem;
            top: 50px;
            background-color: #FFFFFF;
        }
        button{
            padding-left: 2%;
            position: relative;
            left: 7rem;
            bottom: 20px;
        }
        .center-hander{
            position: relative;
            top: 50px;
            left: 40px;
        }
        .center button{
            background-color: #00FFFF;
        }
        .center-hander p{
            font-size: 12px;
            position: relative;
            bottom: 20px;
            color: #FF0000;
        }
    </style>
</head>
<body background="img/timg6H13XWKN.jpg" style="background-repeat: no-repeat;background-size: 100%;">
<div class="hander">
    <h1>管理员登陆页面</h1>
</div>
<div class="center">
    <div class="center-hander">
        账号:<input  id="username"/><br /><br />
        密码:<input id="password" type="password"/><br /><br />
        <button id="registered">注册</button>
        <p></p>
    </div>
</div>
<div class="footer"></div>
</body>
</html>