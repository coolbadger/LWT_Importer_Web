package com.LWT.Entity;

/**
 * Created by 杨思明 on 2017/4/11.
 */
public class Conversion {


    private String JLBH;
    private String CBBH;
    private String ZYQ;
    private String HZ;
    private String SHR ;
    private String ZYLX;
    private String YSGJ;
    private String FHR;
    private String SFXT;
    private String CZLX;
    private Double DS;
    private String ZYSJ;
    private String MXHZ;
    private String MTLB ;
    private Double LJDS;
    private Double ZLJDS;
    private String FSXM_NAME;
    private String PREPORTNAMEID;
    private String VESSELCN;
    private String SHR_NAME;

    public String getJLBH() {
        return JLBH;
    }

    public void setJLBH(String JLBH) {
        this.JLBH = JLBH;
    }

    public String getCBBH() {
        return CBBH;
    }

    public void setCBBH(String CBBH) {
        this.CBBH = CBBH;
    }

    public String getZYQ() {
        return ZYQ;
    }

    public void setZYQ(String ZYQ) {
        this.ZYQ = ZYQ;
    }

    public String getHZ() {
        return HZ;
    }

    public void setHZ(String HZ) {
        this.HZ = HZ;
    }

    public String getSHR() {
        return SHR;
    }

    public void setSHR(String SHR) {
        this.SHR = SHR;
    }

    public String getZYLX() {
        return ZYLX;
    }

    public void setZYLX(String ZYLX) {
        this.ZYLX = ZYLX;
    }

    public String getYSGJ() {
        return YSGJ;
    }

    public void setYSGJ(String YSGJ) {
        this.YSGJ = YSGJ;
    }

    public String getFHR() {
        return FHR;
    }

    public void setFHR(String FHR) {
        this.FHR = FHR;
    }

    public String getSFXT() {
        return SFXT;
    }

    public void setSFXT(String SFXT) {
        this.SFXT = SFXT;
    }

    public String getCZLX() {
        return CZLX;
    }

    public void setCZLX(String CZLX) {
        this.CZLX = CZLX;
    }

    public Double getDS() {
        return DS;
    }

    public void setDS(Double DS) {
        this.DS = DS;
    }

    public String getZYSJ() {
        return ZYSJ;
    }

    public void setZYSJ(String ZYSJ) {
        ZYSJ = ZYSJ.replace("-","");
        ZYSJ = ZYSJ.replace(":","");
        ZYSJ = ZYSJ.substring(0,8);
        this.ZYSJ = ZYSJ;
    }

    public String getMXHZ() {
        return MXHZ;
    }

    public void setMXHZ(String MXHZ) {
        this.MXHZ = MXHZ;
    }

    public String getMTLB() {
        return MTLB;
    }

    public void setMTLB(String MTLB) {
        this.MTLB = MTLB;
    }

    public Double getLJDS() {
        return LJDS;
    }

    public void setLJDS(Double LJDS) {
        this.LJDS = LJDS;
    }

    public Double getZLJDS() {
        return ZLJDS;
    }

    public void setZLJDS(Double ZLJDS) {
        this.ZLJDS = ZLJDS;
    }

    public String getFSXM_NAME() {
        return FSXM_NAME;
    }

    public void setFSXM_NAME(String FSXM_NAME) {
        this.FSXM_NAME = FSXM_NAME;
    }

    public String getPREPORTNAMEID() {
        return PREPORTNAMEID;
    }

    public void setPREPORTNAMEID(String PREPORTNAMEID) {
        this.PREPORTNAMEID = PREPORTNAMEID;
    }

    public String getVESSELCN() {
        return VESSELCN;
    }

    public void setVESSELCN(String VESSELCN) {
        this.VESSELCN = VESSELCN;
    }

    public String getSHR_NAME() {
        return SHR_NAME;
    }

    public void setSHR_NAME(String SHR_NAME) {
        this.SHR_NAME = SHR_NAME;
    }
}
