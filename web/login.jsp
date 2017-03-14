<%--
  Created by IntelliJ IDEA.
  User: lekoxnfx
  Date: 2017/3/14
  Time: 下午9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>龙湾散货数据导入</title>
    <script src="static/js/jquery-3.1.1.min.js"></script>
    <script src="static/bootstrap/js/bootstrap.min.js"></script>
    <link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<style type="text/css">
    body {
        padding-top: 100px;
        padding-bottom: 40px;
        background-image: url("static/images/terminal.jpeg");
        text-align: center;
    }

    .form-signin {
        max-width: 300px;
        /*padding: 19px 29px 29px;*/
        /*text-align: center;*/
        margin: 0 auto 20px;
        filter: alpha(opacity:80);
        opacity: 0.8;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
        -moz-border-radius: 5px;
        border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px #3C3771;
        -moz-box-shadow: 0 1px 2px #3C3771;
        box-shadow: 0 1px 2px #3C3771;
    }

    .form-signin .form-signin-heading,
    .form-signin .checkbox {
        margin-bottom: 10px;
    }

    .form-signin input[type="text"],
    .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
        -webkit-border-radius: 5px;
        -moz-border-radius: 5px;
        border-radius: 5px;
    }

</style>

<div class="container" ng-app="login" ng-controller="loginCtrl">

    <form id="loginForm" class="form-signin" method="post">
        <h2 class="form-signin-heading col-lg-12">登录系统</h2>
        <input ng-model="username" type="text" name="username" class="input-block-level" placeholder="账号">
        <input ng-model="password" type="password" name="password" class="input-block-level" placeholder="密码">
        <!--<input type="text" name="verify" class="input-medium" placeholder="验证码">-->

        <div style="padding: 10px 50px">
            <button ng-click="login()" id="loginBtn" class="btn btn-lg btn-block btn-primary" type="submit">登录
            </button>
        </div>
        <!--<div ng-model="name"><p>我的第一个表达式: </p></div>-->
    </form>
</div>


</body>
</html>
