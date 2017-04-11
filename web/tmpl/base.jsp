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

    <%--<script type="text/javascript" src="/static/dateTime/js/jquery-1.11.0.min.js"></script>--%>
    <%--<link type="text/css" rel="stylesheet" href="/static/dateTime/css/admin.css" />--%>
    <link rel="stylesheet" type="text/css" href="/static/dateTime/css/jquery-ui.css" />
    <script type="text/javascript" src="/static/dateTime/js/jquery-ui-1.10.4.custom.min.js"></script>
    <script type="text/javascript" src="/static/dateTime/js/jquery.ui.datepicker-zh-CN.js"></script>
    <script type="text/javascript" src="/static/dateTime/js/jquery-ui-timepicker-addon.js"></script>
    <script type="text/javascript" src="/static/dateTime/js/jquery-ui-timepicker-zh-CN.js"></script>
    <style type="text/css">
        .ui-timepicker-div .ui-widget-header { margin-bottom: 8px; }
        .ui-timepicker-div dl { text-align: left; }
        .ui-timepicker-div dl dt { float: left; clear:left; padding: 0 0 0 5px; }
        .ui-timepicker-div dl dd { margin: 0 10px 10px 45%; }
        .ui-timepicker-div td { font-size: 90%; }
        .ui-tpicker-grid-label { background: none; border: none; margin: 0; padding: 0; }

        .ui-timepicker-rtl{ direction: rtl; }
        .ui-timepicker-rtl dl { text-align: right; padding: 0 5px 0 0; }
        .ui-timepicker-rtl dl dt{ float: right; clear: right; }
        .ui-timepicker-rtl dl dd { margin: 0 45% 10px 10px; }
    </style>
</head>
<body>
<layout:block name="content"></layout:block>
</body>
</html>
