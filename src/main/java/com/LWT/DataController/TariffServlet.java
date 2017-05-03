package com.LWT.DataController;

import com.LWT.Details.EventDetail;
import com.LWT.Details.TariffDetail;
import com.LWT.Entity.Result_BBK;
import com.LWT.Entity.SNX_BBK_Unit;
import com.LWT.Utils.MatchFeeUtils;
import com.LWT.Utils.TariffUtils;
import com.google.gson.Gson;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ThinkPad on 2017-04-19.
 */
public class TariffServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){

        String JLBH = req.getParameter("JLBH");
        String CBBH = req.getParameter("CBBH");
        String HZ = req.getParameter("HZ");
        String VESSELCN = req.getParameter("VESSELCN");
        String ZYQ = req.getParameter("ZYQ");
        String YSGJ = req.getParameter("YSGJ");
        String ZYLX = req.getParameter("ZYLX");
        String SHR = req.getParameter("SHR");
        String FHR = req.getParameter("FHR");
        String SHR_NAME = req.getParameter("SHR_NAME");
        String SFXT = req.getParameter("SFXT");
        String CZLX = req.getParameter("CZLX");
        String MXHZ = req.getParameter("MXHZ");
        String MTLB = req.getParameter("MTLB");
        String FSXM_NAME = req.getParameter("FSXM_NAME");
        String PREPORTNAMEID = req.getParameter("PREPORTNAMEID");
        String ZYSJ = req.getParameter("ZYSJ").substring(0,req.getParameter("ZYSJ").length()-2);
        String DS = req.getParameter("DS");
        String LJDS = req.getParameter("LJDS");
        String ZLJDS = req.getParameter("ZLJDS");
        String XCCM="";
        String XCSJ="0001-01-01 00:00:00";
        String SFYC="";
        String SFHQ="";
        String HQSJ="";
        String PZJS="";
        String SCS="";
        String ZCFS="";
        String SJLY="";
        String XTFS="";
        String FSXM="";

        System.out.println(JLBH);

        Result_BBK result_bbk = new Result_BBK();
        result_bbk.setRecordID(JLBH);
        result_bbk.setTransID(CBBH);
        result_bbk.setWorkArea(ZYQ);
        result_bbk.setCargoSpec(HZ);
        result_bbk.setConsignee(FHR);
        result_bbk.setConsignor(SHR);
        result_bbk.setVesselID(XCCM);
        result_bbk.setDetailCargoType(MXHZ);
        result_bbk.setPortType(MTLB);
        result_bbk.setLoadingType(ZCFS);
        result_bbk.setDataSource(SJLY);
        result_bbk.setDirTakeType(XTFS);
        result_bbk.setUnloadTime("".equals(XCSJ)?"0001-01-01 00:00:00":XCSJ);
        result_bbk.setWorkingTime("".equals(ZYSJ)?"0001-01-01 00:00:00":ZYSJ);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try{
            Date startDate = sdf.parse("".equals(XCSJ)?"0001-01-01 00:00:00":XCSJ);
            Date endDate = sdf.parse("".equals(ZYSJ)?"0001-01-01 00:00:00":ZYSJ);
            if(startDate.after(endDate)){
                result_bbk.setUnloadTime(result_bbk.getWorkingTime());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        result_bbk.setTonsWeight(DS);
        result_bbk.setTonsWeightSum(LJDS);
        result_bbk.setStowage(PZJS);
        result_bbk.setWaterGauge(SCS);

        result_bbk.setWorkType(ZYLX);
        result_bbk.setTransType(YSGJ);
        result_bbk.setDirectTake(SFXT);
        result_bbk.setYardMove(SFYC);
        result_bbk.setOperateType(CZLX);

        result_bbk.setProcessed(SFHQ);
        result_bbk.setProcessTime(HQSJ);

        result_bbk.setFeeItem(FSXM);

        SNX_BBK_Unit snx_bbk_unit = new SNX_BBK_Unit(result_bbk);
        //生成事件
        List<EventDetail> events = TariffUtils.createEvent(snx_bbk_unit);
        List<TariffDetail> tariffDetails = new ArrayList<TariffDetail>();

        for(EventDetail event:events){
            TariffUtils tariffUtils = new TariffUtils();
            String feeCode = tariffUtils.queryTree(event);
            if (feeCode!=null&&!"".equals(feeCode)){
                //查询feeCode所代表的费目与客户合同中的费目是否匹配，不匹配则不收费
                MatchFeeUtils matchFeeUtils = new MatchFeeUtils();
                //TODO 客户名称暂定杨思明
                TariffDetail tariffDetail = matchFeeUtils.matchFee(feeCode,SHR_NAME);

                BigDecimal feeAmount = new BigDecimal(tariffDetail.getValue());
                BigDecimal weight = new BigDecimal(result_bbk.getTonsWeight().toString());

                tariffDetail.setValue(feeAmount.multiply(weight).toString());
                tariffDetails.add(tariffDetail);
            }
        }

        Gson gson = new Gson();
        String s = gson.toJson(tariffDetails);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        try {
            PrintWriter out = resp.getWriter();
            out.write(String.valueOf(s));
            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public long getFee(String customer,String tariff,long amount){


        return amount;
    }
}
