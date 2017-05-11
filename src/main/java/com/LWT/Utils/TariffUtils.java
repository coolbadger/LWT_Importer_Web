package com.LWT.Utils;

import com.LWT.Details.EventDetail;
import com.LWT.Details.TreeDetail;
import com.LWT.Entity.SNX_BBK_Unit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ThinkPad on 2017-04-19.
 */
public class TariffUtils {

    //根据页面数据生成事件
    public static List<EventDetail> createEvent(SNX_BBK_Unit snx_bbk_unit){

        List<EventDetail> events = new ArrayList<EventDetail>();
        if("EXPORT".equals(snx_bbk_unit.getCategory())){
            EventDetail event = new EventDetail();
            event.setId("BBK_UNIT_LOAD");
            event.setQuantity(snx_bbk_unit.getUnitWeight().toString());
            event.setQuantity_unit("METRIC_TONNES");
            event.setNote("装船："+snx_bbk_unit.getUnitWeight().toString());
            event.setUser_id("snx:admin");
            event.setIs_billable("Y");
            event.setLine(snx_bbk_unit.getLine().toString());
            event.setFeeItem(snx_bbk_unit.getFeeItem().toString());
            events.add(event);
        }else{
            if (snx_bbk_unit.isIsYard()){
                EventDetail event = new EventDetail();
                event.setId("BBK_UNIT_DISCHARGE");
                event.setShipper_id(snx_bbk_unit.getUnitShiper().toString());
                event.setConsignee_id(snx_bbk_unit.getUnitConsignee().toString());
                event.setQuantity(snx_bbk_unit.getUnitWeight().toString());
                event.setQuantity_unit("METRIC_TONNES");
                event.setNote("卸船："+snx_bbk_unit.getUnitWeight().toString());
                event.setUser_id("snx:admin");
                event.setIs_billable("Y");
                event.setLine(snx_bbk_unit.getLine().toString());
                event.setFeeItem(snx_bbk_unit.getFeeItem().toString());
                events.add(event);
            }else {
                if(snx_bbk_unit.isIsDirTake()){
                    EventDetail event = new EventDetail();
                    event.setId("BBK_UNIT_DISCHARGE");
                    event.setShipper_id(snx_bbk_unit.getUnitShiper().toString());
                    event.setConsignee_id(snx_bbk_unit.getUnitConsignee().toString());
                    event.setQuantity(snx_bbk_unit.getUnitWeight().toString());
                    event.setQuantity_unit("METRIC_TONNES");
                    event.setNote("直提："+snx_bbk_unit.getUnitWeight().toString());
                    event.setUser_id("snx:admin");
                    event.setIs_billable("Y");
                    event.setLine(snx_bbk_unit.getLine().toString());
                    event.setFeeItem(snx_bbk_unit.getFeeItem().toString());
                    events.add(event);
                }else {
                    EventDetail event = new EventDetail();
                    event.setId("BBK_UNIT_DISCHARGE");
                    event.setShipper_id(snx_bbk_unit.getUnitShiper().toString());
                    event.setConsignee_id(snx_bbk_unit.getUnitConsignee().toString());
                    event.setQuantity(snx_bbk_unit.getUnitWeight().toString());
                    event.setQuantity_unit("METRIC_TONNES");
                    event.setNote("堆存："+snx_bbk_unit.getUnitWeight().toString());
                    event.setUser_id("snx:admin");
                    event.setIs_billable("Y");
                    event.setLine(snx_bbk_unit.getLine().toString());
                    event.setFeeItem(snx_bbk_unit.getFeeItem().toString());
                    events.add(event);
                    EventDetail event1 = new EventDetail();
                    event1.setId("BBK_UNIT_DISCHARGE");
                    event1.setShipper_id(snx_bbk_unit.getUnitShiper().toString());
                    event1.setConsignee_id(snx_bbk_unit.getUnitConsignee().toString());
                    event1.setQuantity(snx_bbk_unit.getUnitWeight().toString());
                    event1.setQuantity_unit("METRIC_TONNES");
                    event1.setNote("提货："+snx_bbk_unit.getUnitWeight().toString());
                    event1.setUser_id("snx:admin");
                    event1.setIs_billable("Y");
                    event.setLine(snx_bbk_unit.getLine().toString());
                    event.setFeeItem(snx_bbk_unit.getFeeItem().toString());
                    events.add(event1);
                }
            }
        }

        EventDetail eventDetail = new EventDetail();
        eventDetail.setId("_SUM_OLD");
        eventDetail.setQuantity(snx_bbk_unit.getWeightSumOld().toString());
        eventDetail.setQuantity_unit("METRIC_TONNES");
        eventDetail.setNote("作业前累积量(吨)："+snx_bbk_unit.getWeightSumOld().toString());
        eventDetail.setUser_id("snx:admin");
        eventDetail.setIs_billable("Y");
        eventDetail.setLine(snx_bbk_unit.getLine().toString());
        events.add(eventDetail);

        EventDetail eventDetail2 = new EventDetail();
        eventDetail2.setId("_SUM_NEW");
        eventDetail2.setQuantity(snx_bbk_unit.getWeightSumNew().toString());
        eventDetail2.setQuantity_unit("METRIC_TONNES");
        eventDetail2.setNote("作业后累积量(吨)："+snx_bbk_unit.getWeightSumNew().toString());
        eventDetail2.setUser_id("snx:admin");
        eventDetail2.setIs_billable("Y");
        eventDetail2.setLine(snx_bbk_unit.getLine().toString());
        events.add(eventDetail2);
        return events;
    }

    //查询费目代号
    public String queryTree(EventDetail eventDetail){

        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        String GKEY;//条件id
        String METAFIELD;//
        String NEGATED;//
        String NEXT_EMAPP_GKEY;//兄弟节点GKEY
        String SUB_EMAPP_GKEY;//子节点GKEY
        String VALUE;//内容
        String UIVALUE;//页面显示内容
        String VERB;//条件类型

        String tariff_rules_id = "";
        Map<String,TreeDetail> map = new HashMap<String, TreeDetail>();

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("开始初始化billing数据库");
            String url = "jdbc:oracle:" + "thin:@192.168.37.111:1521:nb";
//            String url = "jdbc:oracle:" + "thin:@192.168.3.10:1521:nb";
            String user = "nbuser";
            String password = "nbuser";
            con = DriverManager.getConnection(url, user, password);

            //查询当前事件中涉及的费目组  及其生效时间，取最近的生效费目组
            String sql ="SELECT BSTA.EFFECTIVE_DATE,BSTA.TARIFF_RULES FROM BIL_SERVICE_TYPES BST, BIL_SERVICE_TARIFFS BSTA " +
                    "WHERE BST.ID = " + "'" + eventDetail.getId() + "'" + " AND BST.GKEY = BSTA.SERVICE_GKEY ORDER BY BSTA.EFFECTIVE_DATE";
            pre = con.prepareStatement(sql);
            rs = pre.executeQuery();

            while (rs.next()){
                tariff_rules_id = rs.getString("TARIFF_RULES");
            }
            System.out.println(tariff_rules_id);

            //查询所有费目生效条件
            String sql2 = "SELECT PMP.GKEY,PMP.VERB,PMP.METAFIELD,PMP.VALUE,PMP.UIVALUE,PMP.NEGATED,PMP.NEXT_EMAPP_GKEY,PMP.SUB_EMAPP_GKEY FROM FRM_MAPPING_PREDICATES PMP";
            pre = con.prepareStatement(sql2);
            rs = pre.executeQuery();

            while (rs.next()){
                TreeDetail treeDetail = new TreeDetail();
                GKEY = rs.getString("GKEY");
                METAFIELD = rs.getString("METAFIELD");
                NEGATED = rs.getString("NEGATED");
                NEXT_EMAPP_GKEY = rs.getString("NEXT_EMAPP_GKEY");
                SUB_EMAPP_GKEY = rs.getString("SUB_EMAPP_GKEY");
                VALUE = rs.getString("VALUE");
                UIVALUE = rs.getString("UIVALUE");
                VERB = rs.getString("VERB");

                treeDetail.setGKEY(GKEY);
                treeDetail.setMETAFIELD(METAFIELD);
                treeDetail.setNEGATED(NEGATED);
                treeDetail.setNEXT_EMAPP_GKEY(NEXT_EMAPP_GKEY);
                treeDetail.setSUB_EMAPP_GKEY(SUB_EMAPP_GKEY);
                treeDetail.setVALUE(VALUE);
                treeDetail.setUIVALUE(UIVALUE);
                treeDetail.setVERB(VERB);

                map.put(GKEY,treeDetail);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (rs != null)
                    rs.close();
                if (pre != null)
                    pre.close();
                if (con != null)
                    con.close();
                System.out.println("数据库连接已关闭！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String feeCode=null;//费目代号

        if (tariff_rules_id!=null&&!"".equals(tariff_rules_id)){
            TreeDetail treeDetail = map.get(tariff_rules_id);//得到第一个条件

            Map<String,String> tableMap = new HashMap<String, String>();
            tableMap.put("bexuFreightKind",eventDetail.getLine());
            tableMap.put("bexuFlexString09",eventDetail.getFeeItem());

            //根据各种条件查询当前事件满足的费目代号
            while (feeCode==null){
                if ("MATCHES".equals(treeDetail.getVERB())){
                    //TODO 待确定此处取value值还是uiValue值
                    String value = treeDetail.getVALUE();
//                    System.out.println(value);
                    value = value.replace("*","");
                    value = value.replace("%","");
                    //TODO 需做一个map转化 map.get(treeDetail.getMETAFIELD());
                    boolean s = tableMap.get(treeDetail.getMETAFIELD()).contains(value);
//                    System.out.println(tableMap.get(treeDetail.getMETAFIELD()));
                    if (s){
                        //满足当前条件时，无论有没有兄弟条件，都不会判断兄弟条件
                        //                如果有子条件，应再去判断子条件
                        //                如果没有子条件，则判断结束
                        if (treeDetail.getSUB_EMAPP_GKEY()!=null){
                            String sonGKEY = treeDetail.getSUB_EMAPP_GKEY();
                            treeDetail.setGKEY(map.get(sonGKEY).getGKEY());
                            treeDetail.setMETAFIELD(map.get(sonGKEY).getMETAFIELD());
                            treeDetail.setNEGATED(map.get(sonGKEY).getNEGATED());
                            treeDetail.setSUB_EMAPP_GKEY(map.get(sonGKEY).getSUB_EMAPP_GKEY());
                            treeDetail.setNEXT_EMAPP_GKEY(map.get(sonGKEY).getNEXT_EMAPP_GKEY());
                            treeDetail.setVERB(map.get(sonGKEY).getVERB());
                            treeDetail.setUIVALUE(map.get(sonGKEY).getUIVALUE());
                            treeDetail.setVALUE(map.get(sonGKEY).getVALUE());
                        }else {
                            feeCode = treeDetail.getGKEY();
                            System.out.println("成功+++++++++"+feeCode);
                        }
                    }else {
                        //不满足当前条件时，无论有没有子条件，都不会判断子条件
                        //                  如果有兄弟条件，应再去判断兄弟条件
                        //                  如果没有兄弟条件，则判断结束
                        if (treeDetail.getNEXT_EMAPP_GKEY()!=null){
                            String broGKEY = treeDetail.getNEXT_EMAPP_GKEY();
                            treeDetail = map.get(broGKEY);
                        }else {
                            System.out.println("无符合条件的费收项目");
                            break;
                        }
                    }
                }else if ("EQ".equals(treeDetail.getVERB())){
                    String value = treeDetail.getVALUE();
                    if (value.equals(tableMap.get(treeDetail.getMETAFIELD()))){
                        if (treeDetail.getSUB_EMAPP_GKEY()!=null){
                            String sonGKEY = treeDetail.getSUB_EMAPP_GKEY();
                            treeDetail.setGKEY(map.get(sonGKEY).getGKEY());
                            treeDetail.setMETAFIELD(map.get(sonGKEY).getMETAFIELD());
                            treeDetail.setNEGATED(map.get(sonGKEY).getNEGATED());
                            treeDetail.setSUB_EMAPP_GKEY(map.get(sonGKEY).getSUB_EMAPP_GKEY());
                            treeDetail.setNEXT_EMAPP_GKEY(map.get(sonGKEY).getNEXT_EMAPP_GKEY());
                            treeDetail.setVERB(map.get(sonGKEY).getVERB());
                            treeDetail.setUIVALUE(map.get(sonGKEY).getUIVALUE());
                            treeDetail.setVALUE(map.get(sonGKEY).getVALUE());
                        }else {
                            feeCode = treeDetail.getGKEY();
                        }
                    }else{
                        if (treeDetail.getNEXT_EMAPP_GKEY()!=null){
                            String broGKEY = treeDetail.getNEXT_EMAPP_GKEY();
                            treeDetail = map.get(broGKEY);
                        }else {
                            break;
                        }
                    }
                }
//                else if(){
//
//                }//TODO 还有多种判断条件
            }
        }

        if (feeCode==null){
            return "";
        }else {
            return feeCode;
        }

    }

    public static void main(String[] args){

        List<String> list = new ArrayList<String>();
        list.add("AAA");
        list.add("BBB");
        list.add("AAA");
        list.add("CCC");
        list.add("DDD");
        list.add("BBB");
        list.add("BBB");
        list.add("EEE");

        for (int i = 0;i<list.size()-1;i++){
            for (int j = list.size()-1;j>i;j--){
                if (list.get(j).equals(list.get(i))){
                    list.remove(j);
                }
            }
        }

        System.out.println(list);

    }

}
