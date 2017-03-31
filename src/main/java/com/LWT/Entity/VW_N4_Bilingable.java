package com.LWT.Entity;

/**
 * Created by Kirito on 2017/3/29.
 */
public class VW_N4_Bilingable {
    private String RecordID;        //记录编号
    private String TransID;       //船舶编号
    private String WorkArea;       //作业区
    private String CargoSpec;       //货种
    private String Consignee;       //收货人编号
    private String Consignor;       //发货人
    private String DetailCargoType; //明细货种
    private String ShipmentHarbor;  //装货港
    private String ShipsnameNumber; //船名航次
    private String PortType;        //码头类别
    private String ConsignorName;  //收货人名称
    private String FeeItem;         //费收项目

    //DATE类型
    private String WorkingTime;     //作业时间

    //NUMBER类型
    private Double TonsWeight;      //吨数，单位 T=1000KG
    private Double TonsWeightSum;   //累计吨数（不含当前量），单位 T=1000KG
    private Double AllTonsWeightSum; //总累计吨数，单位 T=1000KG

    //CHAR(1)类型
    private String WorkType;        //作业类型
    private String TransType;       //运输工具
    private String DirectTake;      //是否现提
    private String OperateType;     //操作类型

    //

    public String getRecordID(String jlbh) {
        return RecordID;
    }

    public void setRecordID(String recordID) {
        RecordID = recordID;
    }

    public String getTransID(String cbbh) {
        return TransID;
    }

    public void setTransID(String transID) {
        TransID = transID;
    }

    public String getWorkArea(String hz) {
        return WorkArea;
    }

    public void setWorkArea(String workArea) {
        WorkArea = workArea;
    }

    public String getCargoSpec() {
        return CargoSpec;
    }

    public void setCargoSpec(String cargoSpec) {
        CargoSpec = cargoSpec;
    }

    public String getConsignee() {
        return Consignee;
    }

    public void setConsignee(String consignee) {
        Consignee = consignee;
    }

    public String getConsignor() {
        return Consignor;
    }

    public void setConsignor(String consignor) {
        Consignor = consignor;
    }

    public String getDetailCargoType() {
        return DetailCargoType;
    }

    public void setDetailCargoType(String detailCargoType) {
        DetailCargoType = detailCargoType;
    }

    public String getShipmentHarbor() {
        return ShipmentHarbor;
    }

    public void setShipmentHarbor(String shipmentHarbor) {
        ShipmentHarbor = shipmentHarbor;
    }

    public String getShipsnameNumber() {
        return ShipsnameNumber;
    }

    public void setShipsnameNumber(String shipsnameNumber) {
        ShipsnameNumber = shipsnameNumber;
    }

    public String getPortType() {
        return PortType;
    }

    public void setPortType(String portType) {
        PortType = portType;
    }

    public String getConsignorName() {
        return ConsignorName;
    }

    public void setConsignorName(String consignorName) {
        ConsignorName = consignorName;
    }

    public String getFeeItem() {
        return FeeItem;
    }

    public void setFeeItem(String feeItem) {
        FeeItem = feeItem;
    }

    public String getWorkingTime() {
        return WorkingTime;
    }

    public void setWorkingTime(String workingTime) {
        WorkingTime = workingTime;
    }

    public Double getTonsWeight() {
        return TonsWeight;
    }

    public void setTonsWeight(Double tonsWeight) {
        TonsWeight = tonsWeight;
    }

    public Double getTonsWeightSum() {
        return TonsWeightSum;
    }

    public void setTonsWeightSum(Double tonsWeightSum) {
        TonsWeightSum = tonsWeightSum;
    }

    public Double getAllTonsWeightSum() {
        return AllTonsWeightSum;
    }

    public void setAllTonsWeightSum(Double allTonsWeightSum) {
        AllTonsWeightSum = allTonsWeightSum;
    }

    public String getWorkType() {
        return WorkType;
    }

    public void setWorkType(String workType) {
        WorkType = workType;
    }

    public String getTransType() {
        return TransType;
    }

    public void setTransType(String transType) {
        TransType = transType;
    }

    public String getDirectTake() {
        return DirectTake;
    }

    public void setDirectTake(String directTake) {
        DirectTake = directTake;
    }

    public String getOperateType() {
        return OperateType;
    }

    public void setOperateType(String operateType) {
        OperateType = operateType;
    }

    @Override
    public String toString() {
        return "VW_N4_Bilingable{" +
                "RecordID='" + RecordID + '\'' +
                ", TransID='" + TransID + '\'' +
                ", WorkArea='" + WorkArea + '\'' +
                ", CargoSpec='" + CargoSpec + '\'' +
                ", Consignee='" + Consignee + '\'' +
                ", Consignor='" + Consignor + '\'' +
                ", DetailCargoType='" + DetailCargoType + '\'' +
                ", ShipmentHarbor='" + ShipmentHarbor + '\'' +
                ", ShipsnameNumber='" + ShipsnameNumber + '\'' +
                ", PortType='" + PortType + '\'' +
                ", ConsignorName='" + ConsignorName + '\'' +
                ", FeeItem='" + FeeItem + '\'' +
                ", WorkingTime='" + WorkingTime + '\'' +
                ", TonsWeight=" + TonsWeight +
                ", TonsWeightSum=" + TonsWeightSum +
                ", AllTonsWeightSum=" + AllTonsWeightSum +
                ", WorkType='" + WorkType + '\'' +
                ", TransType='" + TransType + '\'' +
                ", DirectTake='" + DirectTake + '\'' +
                ", OperateType='" + OperateType + '\'' +
                '}';
    }
}
