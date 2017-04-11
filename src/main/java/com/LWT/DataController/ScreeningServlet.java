package com.LWT.DataController;

import com.LWT.Entity.Conversion;
import com.LWT.Entity.VW_N4_Bilingable;
import com.google.gson.Gson;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Du on 2017/4/7.
 */

public class ScreeningServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String KSSJ = new String(req.getParameter("KSSJ").getBytes("ISO-8859-1"), "UTF-8");
        String SHR = new String(req.getParameter("SHR").getBytes("ISO-8859-1"), "UTF-8");
        String JSSJ = new String(req.getParameter("JSSJ").getBytes("ISO-8859-1"), "UTF-8");
        String FSXM_NAME = new String(req.getParameter("FSXM_NAME").getBytes("ISO-8859-1"), "UTF-8");



        Connection con = null;
            PreparedStatement pre = null;
            ResultSet rs = null;

            List<Conversion> list=new ArrayList<Conversion>();
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                System.out.println("开始尝试连接数据库！");
                String url = "jdbc:oracle:" + "thin:@192.168.37.103:1521:database";
                String user = "lwjk";
                String password = "wzlwjk";
                con = DriverManager.getConnection(url, user, password);
                System.out.println("连接成功！");
                //SHR='78069616' AND ZYSJ>='06-4月 -17' AND ZYSJ<='11-4月 -17' AND FSXM_NAME='硬码头' ;
                String sql = "select * from VW_N4_BILLINGABLE WHERE SHR="+"'"+SHR+"'"+" AND "+"ZYSJ>="+"'"+KSSJ+"'"+" AND "+"ZYSJ<="+"'"+JSSJ+"'"+" AND " + "FSXM_NAME="+"'"+FSXM_NAME+"'";
                System.out.println(sql);
                pre = con.prepareStatement(sql);
                rs= pre.executeQuery();

                while(rs.next()){
                    Conversion vw=new Conversion();

                    vw.setJLBH(rs.getString("JLBH"));//记录编号
                    vw.setCBBH(rs.getString("CBBH"));//船舶编号
                    vw.setZYQ(rs.getString("ZYQ"));//作业区
                    vw.setHZ(rs.getString("HZ"));//货种
                    vw.setSHR(rs.getString("SHR"));//收货人编码
                    vw.setZYLX(rs.getString("ZYLX"));//作业类型
                    vw.setYSGJ(rs.getString("YSGJ"));//运输工具
                    vw.setFHR(rs.getString("FHR"));//发货人编码
                    vw.setSFXT(rs.getString("SFXT"));//是否现提
                    vw.setCZLX(rs.getString("CZLX"));//操作类型
                    vw.setDS(rs.getDouble("DS"));//吨数
                    vw.setZYSJ(rs.getString("ZYSJ"));//作业时间
                    vw.setMXHZ(rs.getString("MXHZ"));//明细货种
                    vw.setMTLB(rs.getString("MTLB"));//码头类别
                    vw.setLJDS(rs.getDouble("LJDS"));//累计吨数
                    vw.setZLJDS(rs.getDouble("ZLJDS"));//总累计吨数
                    vw.setFSXM_NAME(rs.getString("FSXM_NAME"));//费收项目
                    vw.setPREPORTNAMEID(rs.getString("PREPORTNAMEID"));//装货港
                    vw.setVESSELCN(rs.getString("VESSELCN"));//船名航次
                    vw.setSHR_NAME(rs.getString("SHR_NAME"));//收货人名称
                    list.add(vw);
                }

            }catch (Exception e){
                e.printStackTrace();
            }finally
            {
                try
                {
                    if (rs != null)
                        rs.close();
                    if (pre != null)
                        pre.close();
                    if (con != null)
                        con.close();
                    System.out.println("数据库连接已关闭！");
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }


            }

        Gson gson = new Gson();
        String s = gson.toJson(list);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.write(String.valueOf(s));
        out.close();

    }

}
