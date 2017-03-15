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
    <div class="container">

        <table id="table"
               data-search="true"
               data-show-refresh="true"
               data-show-toggle="true"
               data-show-columns="true"
               data-show-export="true"
               data-detail-view="true">
        </table>

    </div>
    <script>
        var $table = $('#table');

        function initTable() {
            $table.bootstrapTable({
                columns: [{
                    field: 'id',
                    title: 'Item ID'
                }, {
                    field: 'name',
                    title: 'Item Name'
                }, {
                    field: 'price',
                    title: 'Item Price'
                }],
                data: [{
                    id: 1,
                    name: 'Item 1',
                    price: '$1'
                }, {
                    id: 2,
                    name: 'Item 2',
                    price: '$2'
                }]
            });
        }

        initTable();
    </script>
</layout:override>

<%@include file="tmpl/base.jsp" %>