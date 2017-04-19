
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
                        field: 'JLBH',
                        title: '记录编号'
                    }, {
                        field: 'CBBH',
                        title: '船舶编号'
                    }],

                data: [{"JLBH":"0114617","CBBH":"475900925"},{"JLBH":"0111914","CBBH":"477038633"},{"JLBH":"9092150","CBBH":"476361417"},{"JLBH":"9092123","CBBH":"477044066"},{"JLBH":"9092100","CBBH":"477042460"},{"JLBH":"7091958","CBBH":"475900690"},{"JLBH":"6140146","CBBH":"475900331"},{"JLBH":"6140105","CBBH":"475878811"},{"JLBH":"6135946","CBBH":"475900686"}]
            });
        }
        initTable();

        var $tables = $('#tables');
        function initTables() {
            $tables.bootstrapTable({
                columns: [
                    {
                        field: 'JLBH',
                        title: '记录编号'
                    }, {
                        field: 'CBBH',
                        title: '船舶编号'
                    }],

                data: [{"JLBH":"0114617","CBBH":"475900925"},{"JLBH":"0111914","CBBH":"477038633"},{"JLBH":"9092150","CBBH":"476361417"},{"JLBH":"9092123","CBBH":"477044066"},{"JLBH":"9092100","CBBH":"477042460"},{"JLBH":"7091958","CBBH":"475900690"},{"JLBH":"6140146","CBBH":"475900331"},{"JLBH":"6140105","CBBH":"475878811"},{"JLBH":"6135946","CBBH":"475900686"}]
            });
        }
        initTables();


        var thisURL=document.URL;
        var getval=thisURL.split('?')[1];
        var showval=getval.split("=")[1];
            console.log(getval)
        $.ajax({
            url: "/tariff.do?"+getval,
            type: "post",
            success: function (data) {
/*                console.log(data);
                var jsonData = JSON.parse(data);
                $table.bootstrapTable("load", jsonData);*/
            },
            error: function (err) {
                console.log(err.status);
            }
        });
    </script>

</layout:override>

<%@include file="tmpl/base.jsp" %>