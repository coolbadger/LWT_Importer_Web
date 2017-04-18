package com.LWT.DataController;

import com.LWT.DataProcess.SNXProcess;
import com.LWT.DataProcess.SqlDataFunction;
import com.LWT.Entity.Result_BBK;
import com.LWT.Entity.SNX_BBK_Unit;
import com.LWT.connect.ConnectorFactory;
import com.LWT.connect.N4Operator;
import groovy.sql.GroovyRowResult;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.xml.sax.InputSource;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Kirito on 2017/3/31.
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

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
        String xml = snx_bbk_unit.createSNX().toString();

        N4Operator n4Operator = ConnectorFactory.createN4Operator("testserver");
        n4Operator.initRequest();
        Object a = n4Operator.sendRequestWithXml(xml);
        System.out.println(a.toString());

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        super.service(req, resp);
    }


}
