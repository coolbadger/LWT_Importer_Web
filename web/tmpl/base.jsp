<%--
  Created by IntelliJ IDEA.
  User: badger
  Date: 2017/3/14
  Time: 下午10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.dreamlu.net/tags/jsp-layout.tld" prefix="layout" %>

<layout:block name="checkLogin">
    <%
        if (session.getAttribute("username") == null) {
            response.sendRedirect("/login.jsp");
        }
    %>
</layout:block>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title><layout:block name="title">龙湾散货数据导入</layout:block></title>
    <script src="/static/js/jquery-3.1.1.min.js"></script>
    <script src="/static/bootstrap/js/bootstrap.min.js"></script>
    <link href="/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <layout:block name="script"></layout:block>
</head>
<body>
<layout:block name="content"></layout:block>
</body>
</html>
