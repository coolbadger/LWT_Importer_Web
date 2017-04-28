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
            String url = "jdbc:oracle:" + "thin:@192.168.3.10:1521:nb";
            String user = "nbuser";
            String password = "nbuser";
            con = DriverManager.getConnection(url, user, password);

            //TODO 基础合同与增补合同都要查
            //查询客户基础合同下所有费目，与amount
            String sql = "select bt.id,btr.amount,bc.contract_type from bil_tariff_rates btr,BIL_TARIFFS bt,BIL_CONTRACTS bc where btr.tariff_gkey = bt.gkey and btr.CONTRACT_GKEY = bc.gkey and bc.description ="+"'"+customerName+"'";
            pre = con.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()){
                TariffDetail tariffDetailC = new TariffDetail();
                tariffDetailC.setTariffName(rs.getString("ID"));
                tariffDetailC.setValue(rs.getString("AMOUNT"));
                tariffDetailC.setTariffType(rs.getString("CONTRACT_TYPE"));
                allFee.add(tariffDetailC);
            }

            //查询当前事件所满条件的费目
            String sql2 = "select fmv.UIVALUE from frm_mapping_values fmv where fmv.EMAPP_GKEY ="+"'"+feeCode+"'";
            pre = con.prepareStatement(sql2);
            rs = pre.executeQuery();
            while (rs.next()){
                eventfee = rs.getString("UIVALUE");
            }

            for (TariffDetail tariffDetailF : allFee){
                if (tariffDetailF.getTariffName().equals(eventfee)){
                    tariffDetail.setTariffName(eventfee);
                    System.out.println(tariffDetail.getTariffName());
                    tariffDetail.setValue(tariffDetailF.getValue());
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
