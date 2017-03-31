package com.LWT.Dao;

import com.LWT.Entity.VW_N4_Bilingable;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kirito on 2017/3/29.
 */
public class BilingableDao {
    public List<VW_N4_Bilingable> getAllData(){

        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        List<VW_N4_Bilingable> list=new ArrayList<VW_N4_Bilingable>();
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("开始尝试连接数据库！");
            String url = "jdbc:oracle:" + "thin:@192.168.37.103:1521:database";
            String user = "lwjk";
            String password = "wzlwjk";
            con = DriverManager.getConnection(url, user, password);
            System.out.println("连接成功！");
            String sql = "select * from VW_N4_BILLINGABLE";
            pre = con.prepareStatement(sql);
            rs= pre.executeQuery();

            while(rs.next()){
                VW_N4_Bilingable vw=new VW_N4_Bilingable();
                vw.setRecordID(rs.getString("JLBH"));//记录编号
                vw.setTransID(rs.getString("CBBH"));//船舶编号
                vw.setWorkArea(rs.getString("ZYQ"));//作业区
                vw.setCargoSpec(rs.getString("HZ"));//货种
                vw.setConsignee(rs.getString("SHR"));//收货人编码
                vw.setWorkType(rs.getString("ZYLX"));//作业类型
                vw.setTransType(rs.getString("YSGJ"));//运输工具
                vw.setConsignor(rs.getString("FHR"));//发货人编码
                vw.setDirectTake(rs.getString("SFXT"));//是否现提
                vw.setOperateType(rs.getString("CZLX"));//操作类型
                vw.setTonsWeight(rs.getDouble("DS"));//吨数
                vw.setWorkingTime(rs.getString("ZYSJ"));//作业时间
                vw.setDetailCargoType(rs.getString("MXHZ"));//明细货种
                vw.setPortType(rs.getString("MTLB"));//码头类别
                vw.setTonsWeightSum(rs.getDouble("LJDS"));//累计吨数
                vw.setAllTonsWeightSum(rs.getDouble("ZLJDS"));//总累计吨数
                vw.setFeeItem(rs.getString("FSXM_NAME"));//费收项目
                vw.setShipmentHarbor(rs.getString("PREPORTNAMEID"));//装货港
                vw.setShipsnameNumber(rs.getString("VESSELCN"));//船名航次
                vw.setConsignorName(rs.getString("SHR_NAME"));//收货人名称
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

    return list;
}
}
