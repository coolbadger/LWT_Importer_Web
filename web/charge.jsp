
<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%--
  Created by IntelliJ IDEA.
  User: badger
  Date: 2017/3/13
  Time: 上午9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.dreamlu.net/tags/jsp-layout.tld" prefix="layout" %>

<layout:override name="script">
    <script src="/static/bootstrap-table/js/bootstrap-table.js"></script>
    <link href="/static/bootstrap-table/css/bootstrap-table.css" rel="stylesheet">
</layout:override>

<layout:override name="content">

        <div class="container" style="width: 98%;">
            <div class="maincontent" style="height: 80%">
                    <div class="panel-body" style="width: 45%;float: left">
                        <strong>基本合同</strong>
                        <table id="table" data-toggle="table" data-url="" data-method="post"
                               data-query-params="queryParams"
                               data-toolbar="#toolbar"
                               data-pagination="true"
                               data-search="true"
                               data-checkbox="true"
                               data-show-refresh="true"
                               data-show-toggle="true"
                               data-show-columns="true"
                               data-page-list="[5,10, 25, 50, 100, ALL]"
                               datatype="json">
                        </table>
                    </div>
                <div class="panel-body" style="width: 45%;float: right">
                    <strong>增补合同</strong>
                <table id="tables" data-toggle="table" data-url="" data-method="post"
                       data-query-params="queryParams"
                       data-toolbar="#toolbar"
                       data-pagination="true"
                       data-search="true"
                       data-checkbox="true"
                       data-show-refresh="true"
                       data-show-toggle="true"
                       data-show-columns="true"
                       data-page-list="[5,10, 25, 50, 100, ALL]"
                       datatype="json">
                </table>
                </div>

            </div>
        </div>

    <script>
        var $table = $('#table');
        function initTable() {
            $table.bootstrapTable({
                columns: [
                    {
                        field: 'tariffName',
                        title: '记录编号'
                    }, {
                        field: 'value',
                        title: '船舶编号'
                    }],

                data: []
            });
        }
        initTable();

        var $tables = $('#tables');
        function initTables() {
            $tables.bootstrapTable({
                columns: [
                    {
                        field: 'name',
                        title: '记录编号'
                    }, {
                        field: 'money',
                        title: '船舶编号'
                    }],

                data:[]
            });
        }
        initTables();


        var thisURL=document.URL;
        var getval=thisURL.split('?')[1];
        var showval=getval.split("=")[1];
        $.ajax({
            url: "/tariff.do?"+getval,
            type: "post",
            success: function (data) {
                console.log(data)
                var jsonData=JSON.parse(data)
                $table.bootstrapTable("load",jsonData);

            },
            error: function (err) {
                console.log(err.status);
            }
        });
    </script>

</layout:override>

<%@include file="tmpl/base.jsp" %>