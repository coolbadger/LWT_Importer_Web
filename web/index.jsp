<%@ page import="com.LWT.Dao.BilingableDao" %>
<%@ page import="com.LWT.Entity.VW_N4_Bilingable" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
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

    <%
        BilingableDao bd=new BilingableDao();
        List<VW_N4_Bilingable> vw=bd.getAllData();
        for(int i=0;i<vw.size();i++){
            VW_N4_Bilingable vnb=vw.get(i);

    %><div>
     <p><%=vnb.toString()%></p>
      </div>
        <%
            }
        %>

    <div class="container" style="width: 98%;">
        <div class="top">
            <ul class="nav nav-tabs">
                <li class="active">
                    <a href="#">首页</a>
                </li>
                <li class="disabled"><a href="#">资料</a></li>
                <li><a href="#">数据分析</a></li>
                <li class="dropdown pull-right"><a href="#" data-toggle="dropdown" class="dropdown-toggle">更多<strong
                        class="caret"></strong></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">操作</a></li>
                        <li><a href="#">刷新</a></li>
                        <li><a href="#">退出</a></li>
                        <li class="divider">分隔</li>
                    </ul>
                </li>
            </ul>
        </div>
        <div style="height: 80%">
            <table id="table"
                   class="table table-hover table-bordered table-striped"
                   data-search="true"
                   data-show-refresh="true"
                   data-show-toggle="true"
                   data-show-columns="true"
                   data-show-export="true"
                   data-detail-view="true"
                   data-pagination="true"
                   data-show-pagination-switch="true"
                   data-page-list="[10, 25, ALL]">
            </table>
        </div>

    </div>
    <script>
        var $table = $('#table');
        function initTable() {
            $table.bootstrapTable({
                columns: [{
                    field: 'JLBH',
                    title: '记录编号'
                }, {
                    field: 'CBBH',
                    title: '船舶编号'
                }, {
                    field: 'ZYQ',
                    title: '作业区'
                }, {
                    field: 'HZ',
                    title: '货种'
                }, {
                    field: 'SHR',
                    title: '收货人编码'
                },{
                    field: 'ZYLX',
                    title: '作业类型'
                }, {
                    field: 'YSGJ',
                    title: '运输工具'
                }, {
                    field: 'FHR',
                    title: '发货人编码'
                }, {
                    field: 'SFXT',
                    algin:'center',
                    valgin:'middle',
                    title: '是否现提'
                }, {
                    field: 'CZLX',
                    title: '操作类型'
                },{
                    field: 'DS',
                    title: '吨数'
                }, {
                    field: 'ZYSJ',
                    title: '作业时间'
                }, {
                    field: 'MXHZ',
                    title: '明细货种'
                }, {
                    field: 'MTLB',
                    title: '码头类别'
                }, {
                    field: 'LJDS',
                    title: '累计吨数'
                },{
                    field: 'ZLJDS',
                    title: '总累计吨数'
                }, {
                    field: 'FSXM_NAME',
                    title: '费收项目'
                }, {
                    field: 'PREPOPTNAMEID',
                    title: '装货港'
                }, {
                    field: 'VESSELCN',
                    title: '船名航次'
                }, {
                    field: 'SHR_NAME',
                    title: '收货人名称'
                }],
                data:[{
                    JLBH:"001",
                    CBBH:"SH0512",
                    ZYQ:"上海浦东",
                    HZ:"散货",
                    SHR:"W001",
                    ZYLX:"普通",
                    YSGJ:"货轮",
                    FHR:"J001",
                    SFXT:"是",
                    CZLX:"起吊",
                    DS:"10T",
                    ZYSJ:"2016-10-01",
                    MXHZ:"普通",
                    MTLB:"码头类别",
                    LJDS:"20T",
                    ZLJDS:"100T",
                    FSXM_NAME:"费收项目",
                    PREPOPTNAMEID:"温州",
                    VESSELCN:"G20",
                    SHR_NAME:"Q231"
                },{
                    JLBH:"001",
                    CBBH:"SH098",
                    ZYQ:"上海浦东",
                    HZ:"散货",
                    SHR:"W001",
                    ZYLX:"普通",
                    YSGJ:"货轮",
                    FHR:"J001",
                    SFXT:"是",
                    CZLX:"起吊",
                    DS:"10T",
                    ZYSJ:"2016-10-01",
                    MXHZ:"普通",
                    MTLB:"码头类别",
                    LJDS:"20T",
                    ZLJDS:"100T",
                    FSXM_NAME:"费收项目",
                    PREPOPTNAMEID:"温州",
                    VESSELCN:"G20",
                    SHR_NAME:"Q231"
                }]
            });
        }
        initTable();
    </script>
</layout:override>

<%@include file="tmpl/base.jsp" %>