package com.LWT.DataController;

import com.LWT.DataProcess.SNXProcess;
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
        req.setCharacterEncoding("UTF-8");

        String JLBH = new String(req.getParameter("JLBH").getBytes("ISO-8859-1"), "UTF-8");
        String CBBH = new String(req.getParameter("CBBH").getBytes("ISO-8859-1"), "UTF-8");
        String HZ =new String( req.getParameter("HZ").getBytes("ISO-8859-1"), "UTF-8");
        String VESSELCN = new String(req.getParameter("VESSELCN").getBytes("ISO-8859-1"), "UTF-8");
        String ZYQ = new String(req.getParameter("ZYQ").getBytes("ISO-8859-1"), "UTF-8");
        String YSGJ = new String(req.getParameter("YSGJ").getBytes("ISO-8859-1"), "UTF-8");
        String ZYLX =new String( req.getParameter("ZYLX").getBytes("ISO-8859-1"), "UTF-8");
        String SHR =new String( req.getParameter("SHR").getBytes("ISO-8859-1"), "UTF-8");
        String FHR =new String( req.getParameter("FHR").getBytes("ISO-8859-1"), "UTF-8");
        String SHR_NAME =new String( req.getParameter("SHR_NAME").getBytes("ISO-8859-1"), "UTF-8");
        String SFXT = new String(req.getParameter("SFXT").getBytes("ISO-8859-1"), "UTF-8");
        String CZLX = new String(req.getParameter("CZLX").getBytes("ISO-8859-1"), "UTF-8");
        String MXHZ =new String( req.getParameter("MXHZ").getBytes("ISO-8859-1"), "UTF-8");
        String MTLB =new String( req.getParameter("MTLB").getBytes("ISO-8859-1"), "UTF-8");
        String FSXM_NAME =new String( req.getParameter("FSXM_NAME").getBytes("ISO-8859-1"), "UTF-8");
        String PREPORTNAMEID =new String( req.getParameter("PREPORTNAMEID").getBytes("ISO-8859-1"), "UTF-8");
        String ZYSJ = new String(req.getParameter("ZYSJ").getBytes("ISO-8859-1"), "UTF-8");
        String DS = new String(req.getParameter("DS").getBytes("ISO-8859-1"), "UTF-8");
        String LJDS =new String( req.getParameter("LJDS").getBytes("ISO-8859-1"), "UTF-8");
        String ZLJDS =new String( req.getParameter("ZLJDS").getBytes("ISO-8859-1"), "UTF-8");
        String XCCM="";
        String XCSJ="";
        String SFYC="";
        String SFHQ="";
        String HQSJ="";
        String PZJS="";
        String SCS="";
        String ZCFS="";
        String SJLY="";
        String XTFS="";
        String FSXM="";

        String xml = "<?xml version='1.0'  encoding='GBK' ?>"
                        +"<RESULTS>"
                        +"<ROW>"
                        +"<COLUMN NAME='JLBH'>"+JLBH+"</COLUMN>"
                        +"<COLUMN NAME='CBBH'>"+CBBH+"</COLUMN>"
                        +"<COLUMN NAME='ZYQ'>"+ZYQ+"</COLUMN>"
                        +"<COLUMN NAME='HZ'>"+HZ+"</COLUMN>"
                        +"<COLUMN NAME='FHR'>"+FHR+"</COLUMN>"
                        +"<COLUMN NAME='SHR'>"+SHR+"</COLUMN>"
                        +"<COLUMN NAME='ZYLX'>"+ZYLX+"</COLUMN>"
                        +"<COLUMN NAME='YSGJ'>"+YSGJ+"</COLUMN>"
                        +"<COLUMN NAME='DS'>"+DS+"</COLUMN>"
                        +"<COLUMN NAME='XCCM'>"+XCCM+"</COLUMN>"
                        +"<COLUMN NAME='XCSJ'>"+XCSJ+"</COLUMN>"
                        +"<COLUMN NAME='SFYC'>"+SFYC+"</COLUMN>"
                        +"<COLUMN NAME='CZLX'>"+CZLX+"</COLUMN>"
                        +"<COLUMN NAME='SFHQ'>"+SFHQ+"</COLUMN>"
                        +"<COLUMN NAME='HQSJ'>"+HQSJ+"</COLUMN>"
                        +"<COLUMN NAME='ZYSJ'>"+ZYSJ+"</COLUMN>"
                        +"<COLUMN NAME='MXHZ'>"+MXHZ+"</COLUMN>"
                        +"<COLUMN NAME='PZJS'>"+PZJS+"</COLUMN>"
                        +"<COLUMN NAME='SCS'>"+SCS+"</COLUMN>"
                        +"<COLUMN NAME='MTLB'>"+MTLB+"</COLUMN>"
                        +"<COLUMN NAME='ZCFS'>"+ZCFS+"</COLUMN>"
                        +"<COLUMN NAME='SJLY'>"+SJLY+"</COLUMN>"
                        +"<COLUMN NAME='XTFS'>"+XTFS+"</COLUMN>"
                        +"<COLUMN NAME='LJDS'>"+LJDS+"</COLUMN>"
                        +"<COLUMN NAME='ZLJDS'>"+ZLJDS+"</COLUMN>"
                        +"<COLUMN NAME='FSXM'>"+FSXM+"</COLUMN>"
                        +"<COLUMN NAME='FSXM_NAME'>"+FSXM_NAME+"</COLUMN>"
                        +"<COLUMN NAME='JLBH'>"+PREPORTNAMEID+"</COLUMN>"
                        +"<COLUMN NAME='VESSELCN'>"+VESSELCN+"</COLUMN>"
                        +"<COLUMN NAME='SHR_NAME'>"+SHR_NAME+"</COLUMN>"
                        +"</ROW>"
                        +"</RESULTS>";
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        super.service(req, resp);
    }


}
