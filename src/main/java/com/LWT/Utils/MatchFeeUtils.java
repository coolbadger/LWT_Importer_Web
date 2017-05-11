package com.LWT.Utils;

import com.LWT.Details.TariffDetail;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ThinkPad on 2017-04-27.
 */
public class MatchFeeUtils {

    public TariffDetail matchFee(String feeCode, String customerName){

        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        List<TariffDetail> allFee = new ArrayList<TariffDetail>();
        TariffDetail tariffDetail = new TariffDetail();
        String eventfee = "";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("开始初始化billing数据库");
            String url = "jdbc:oracle:" + "thin:@192.168.37.111:1521:nb";
//            String url = "jdbc:oracle:" + "thin:@192.168.3.10:1521:nb";
            String user = "nbuser";
            String password = "nbuser";
            con = DriverManager.getConnection(url, user, password);

            //查询客户基础合同下所有费目，与amount
            String sql = "select bt.id,bt.description,btr.amount,bc.contract_type from bil_tariff_rates btr,BIL_TARIFFS bt,BIL_CONTRACTS bc where btr.tariff_gkey = bt.gkey and btr.CONTRACT_GKEY = bc.gkey and bc.description ="+"'"+customerName+"'";
            pre = con.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()){
                TariffDetail tariffDetailC = new TariffDetail();
                tariffDetailC.setTariffId(rs.getString("ID"));
                tariffDetailC.setTariffName(rs.getString("DESCRIPTION"));
                tariffDetailC.setValue(rs.getString("AMOUNT"));
                tariffDetailC.setTariffType(rs.getString("CONTRACT_TYPE"));
                allFee.add(tariffDetailC);
            }

            //如果基础合同与增补合同中有同一笔费收  以增补合同为准
            for (int i = 0;i<allFee.size()-1;i++){
                for (int j = allFee.size()-1;j>i;j--){
                    if (allFee.get(j).getTariffName().equals(allFee.get(i).getTariffName())){
                        if ("BASE".equals(allFee.get(j).getTariffType())){
                            allFee.remove(j);
                        }else if ("BASE".equals(allFee.get(i).getTariffType())){
                            allFee.remove(i);
                        }
                    }
                }
            }

            //查询当前事件所满条件的费目
            String sql2 = "select fmv.UIVALUE from frm_mapping_values fmv where fmv.EMAPP_GKEY ="+"'"+feeCode+"'";
            pre = con.prepareStatement(sql2);
            rs = pre.executeQuery();
            while (rs.next()){
                eventfee = rs.getString("UIVALUE");
            }

            for (TariffDetail tariffDetailF : allFee){
                if (tariffDetailF.getTariffId().equals(eventfee)){
                    tariffDetail.setTariffId(eventfee);
                    tariffDetail.setTariffName(tariffDetailF.getTariffName());
                    System.out.println(tariffDetail.getTariffName());
                    tariffDetail.setValue(tariffDetailF.getValue());
                    if ("ADDENDUM".equals(tariffDetailF.getTariffType())){
                        tariffDetail.setTariffType("增补合同");
                    }else if ("BASE".equals(tariffDetailF.getTariffType())){
                        tariffDetail.setTariffType("基础合同");
                    }

                }
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

        return tariffDetail;
    }

}
