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
<html>
<head>
    <title><layout:block name="title">龙湾散货数据导入</layout:block></title>
    <script src="/static/js/jquery-3.1.1.min.js"></script>
    <script src="/static/bootstrap/js/bootstrap.min.js"></script>
    <link href="/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <layout:block name="script"></layout:block>
</head>
<body>
<layout:block name="content"></layout:block>
</body>
</html>
