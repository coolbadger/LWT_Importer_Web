<%--
  Created by IntelliJ IDEA.
  User: lekoxnfx
  Date: 2017/3/14
  Time: 下午9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.dreamlu.net/tags/jsp-layout.tld" prefix="layout" %>

<layout:override name="checkLogin">
</layout:override>

<layout:override name="script">
    <link href="/static/css/login.css" rel="stylesheet">
</layout:override>

<layout:override name="content">
    <div class="container">

        <form id="loginForm" class="form-signin" method="post" action="login.do">
            <h2 class="form-signin-heading col-lg-12">登录系统</h2>
            <input type="text" name="username" class="input-block-level" placeholder="账号">
            <input type="password" name="password" class="input-block-level" placeholder="密码">

            <div style="padding: 10px 50px">
                <button id="loginBtn" class="btn btn-lg btn-block btn-primary" type="submit">登录
                </button>
            </div>
        </form>
    </div>
</layout:override>

<%@include file="/tmpl/base.jsp" %>

