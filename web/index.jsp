<%@ page import="com.LWT.Dao.BilingableDao" %>
<%@ page import="com.LWT.Entity.VW_N4_Bilingable" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
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
    <link type="text/css" rel="stylesheet" href="/static/dateTime/css/admin.css" />
    <script src="/static/bootstrap-table/js/bootstrap-table.js"></script>
    <link href="/static/bootstrap-table/css/bootstrap-table.css" rel="stylesheet">
</layout:override>

<layout:override name="content">
    <form method="post" action="/test.do">
        <div class="container" style="width: 98%;">
            <div class="maincontent" style="height: 60%">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="text-center text-muted">龙湾散货系统</h3>
                    </div>
                    <div class="panel-body">

                        <div class="wrap">
                            <ul class="sub-nav">
                                <li ><a href="javascript:void(0);">基础信息</a></li>
                            </ul>
                            <ul class="doc-set">
                                <li>
                                    <div class="doc-dt">
                                        <p>时间格式为 11-4月 -17</p>
                                    </div>
                                    <div class="doc-dd">
                                        <input id="KSSJ" name="" type="text" class="text-box" value="" placeholder="开始时间≥当前时间" title="开始时间≥当前时间"  style="cursor:pointer;"/>
                                        <input id="JSSJ" name="" type="text" class="text-box" value="" placeholder="结束时间>开始时间" title="结束时间>开始时间"  style="cursor:pointer;"/>
                                        <input id="SHR" name="" type="text" class="text-box" value=""  placeholder="收货人编码" title="收货人编码"  style="cursor:pointer;"/>
                                        <input id="FSXM_NAME"  name="" type="text" class="text-box" value="" placeholder="费收项目" title="费收项目"  style="cursor:pointer;"/>
                                        <input type="button" value="提交" class="testSubmit" onclick="testSubmit()" style="width: 90px;height: 50px;">
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <div id="toolbar" class="btn-group">
                            <button id="btn_edit" type="submit" class="btn btn-info"
                                    onclick="return confirm('确定执行导入吗?')">
                                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>导入
                            </button>
                            <button id="btn_test" type="button" class="btn btn-info" onclick="getIdSelections()">
                                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>取值
                            </button>
                        </div>
                        <table id="table" data-toggle="table" data-url="" data-method="post"
                               data-query-params="queryParams"
                               data-toolbar="#toolbar"
                               data-pagination="true"
                               data-search="true"
                               data-checkbox="true"
                               data-show-refresh="true"
                               data-show-toggle="true"
                               data-show-columns="true"
                               data-page-size="10">
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </form>
    <script>
        var $table = $('#table');
        function initTable() {
            $table.bootstrapTable({
                columns: [{
                    field: 'state',
                    checkbox: true,
                    align: 'center',
                    valign: 'middle'
                },
                    {
                        field: 'JLBH',
                        title: '记录编号'
                    }, {
                        field: 'CBBH',
                        title: '船舶编号'
                    }, {
                        field: 'HZ',
                        title: '货种'
                    }, {
                        field: 'VESSELCN',
                        title: '船名航次'
                    }, {
                        field: 'ZYQ',
                        title: '作业区'
                    }, {
                        field: 'YSGJ',
                        title: '运输工具'
                    }, {
                        field: 'ZYLX',
                        title: '作业类型'
                    }, {
                        field: 'SHR',
                        title: '收货人编码'
                    }, {
                        field: 'FHR',
                        title: '发货人编码'
                    }, {
                        field: 'SHR_NAME',
                        title: '收货人名称'
                    }, {
                        field: 'SFXT',
                        title: '是否现提'
                    }, {
                        field: 'CZLX',
                        title: '操作类型'
                    }, {
                        field: 'MXHZ',
                        title: '明细货种'
                    }, {
                        field: 'MTLB',
                        title: '码头类别'
                    }, {
                        field: 'FSXM_NAME',
                        title: '费收项目'
                    }, {
                        field: 'PREPORTNAMEID',
                        title: '装货港'
                    }, {
                        field: 'ZYSJ',
                        title: '作业时间'
                    }, {
                        field: 'DS',
                        title: '吨数'
                    }, {
                        field: 'LJDS',
                        title: '累计吨数'
                    }, {
                        field: 'ZLJDS',
                        title: '总累计吨数'
                    }],

                data: [

                    <%
                        String text="无";
                        BilingableDao bilingableDao=new BilingableDao();
                        List<VW_N4_Bilingable> list_vw=bilingableDao.getAllData();
                        for(int i=0;i<list_vw.size();i++){
                            VW_N4_Bilingable vnb=list_vw.get(i);

                    %>
                    {
                        JLBH: "<%=vnb.getRecordID()==null ?  text:vnb.getRecordID() %>",
                        CBBH: "<%=vnb.getTransID()==null ?  text: vnb.getTransID()%>",
                        ZYQ: "<%=vnb.getWorkArea()==null ?  text: vnb.getWorkArea()%>",
                        HZ: "<%=vnb.getCargoSpec()==null ?  text: vnb.getCargoSpec()%>",
                        SHR: "<%=vnb.getConsignee()==null ?  text: vnb.getConsignee()%>",
                        ZYLX: "<%=vnb.getWorkType()==null ?  text: vnb.getWorkType()%>",
                        YSGJ: "<%=vnb.getTransType()==null ?  text: vnb.getTransType()%>",
                        FHR: "<%=vnb.getConsignee()==null ?  text: vnb.getConsignee()%>",
                        SFXT: "<%=vnb.getDirectTake()==null ?  text: vnb.getDirectTake()%>",
                        CZLX: "<%=vnb.getOperateType()==null ?  text: vnb.getOperateType()%>",
                        DS: "<%=vnb.getTonsWeight()==null ?  text: Double.toString(vnb.getTonsWeight())%>",
                        ZYSJ: "<%=vnb.getWorkingTime()==null ?  text: vnb.getWorkingTime()%>",
                        MXHZ: "<%=vnb.getDetailCargoType()==null ?  text: vnb.getDetailCargoType()%>",
                        MTLB: "<%=vnb.getPortType()==null ?  text: vnb.getPortType()%>",
                        LJDS: "<%=vnb.getTonsWeightSum()==null ?  text: Double.toString(vnb.getTonsWeightSum())%>",
                        ZLJDS: "<%=vnb.getAllTonsWeightSum()==null ?  text: Double.toString(vnb.getAllTonsWeightSum())%>",
                        FSXM_NAME: "<%=vnb.getFeeItem()==null ?  text: vnb.getFeeItem()%>",
                        PREPORTNAMEID: "<%=vnb.getShipsnameNumber()==null ?  text: vnb.getShipsnameNumber()%>",
                        VESSELCN: "<%=vnb.getShipmentHarbor()==null ?  text: vnb.getShipmentHarbor()%>",
                        SHR_NAME: "<%=vnb.getConsignorName()==null ?  text: vnb.getConsignorName()%>"

                    },
                    <%
                        }
                    %>

                ]


            });
        }
        initTable();
        function getIdSelections() {
            return $.map($table.bootstrapTable('getSelections'), function (row) {
                $.ajax({
                    //contentType: "application/json;charset=utf-8",
                    url: "/test.do?JLBH=" + row.JLBH + "&CBBH=" + row.CBBH + "&HZ=" + row.HZ + "&VESSELCN=" + row.VESSELCN + "&ZYQ=" + row.ZYQ + "&YSGJ=" + row.YSGJ + "&ZYLX=" + row.ZYLX + "&SHR=" + row.SHR + "&FHR=" + row.FHR + "&SHR_NAME=" + row.SHR_NAME + "&SFXT=" + row.SFXT + "&CZLX=" + row.CZLX + "&MXHZ=" + row.MXHZ + "&MTLB=" + row.MTLB + "&FSXM_NAME=" + row.FSXM_NAME + "&PREPORTNAMEID=" + row.PREPORTNAMEID + "&ZYSJ=" + row.ZYSJ + "&DS=" + row.DS + "&LJDS=" + row.LJDS + "&ZLJDS=" + row.ZLJDS,
                    type: "post",
                    dataType: "json",
                    success: function (data) {
                        alert(data);
                    },
                    error: function (err) {
                        console.log(err.status);
                    }
                });
            });
        }


        function screening() {
            $.ajax({
                //contentType: "application/json;charset=utf-8",
                url: "/test.do",
                data:1,
                type: "post",
                dataType: "json",
                success: function (data) {
                    alert(data);
                },
                error: function (err) {
                    console.log(err.status);
                }
            });
        }

        function testSubmit() {

            var shr=document.getElementById("SHR").value;
            var kssj=document.getElementById("KSSJ").value;
            var jssj=document.getElementById("JSSJ").value;
            var fsxm=document.getElementById("FSXM_NAME").value;
            //console.log("开始时间="+kssj+":结束时间="+jssj+":SHR="+shr+":费收="+fsxm)

            $.ajax({
                //contentType: "application/json;charset=utf-8",
                url: "/screening.do?FSXM_NAME="+fsxm+"&KSSJ="+kssj+"&JSSJ="+jssj+"&SHR="+shr,
                type: "post",
                success: function (data) {
                    $('#table').bootstrapTable('load',data);
                    console.log(data)
                },
                error: function (err) {
                    console.log(err.status);
                }
            });
        }

    </script>

    <script type="text/javascript">
        $( "input[name='act_start_time'],input[name='act_stop_time']" ).datetimepicker();
    </script>
</layout:override>

<%@include file="tmpl/base.jsp" %>