package com.LWT.Base

import com.LWT.ImporterUI.MainFrameInfo
import com.LWT.connect.ConnectorFactory
import com.LWT.connect.N4Operator

class Global {
    public static def LOOP_SECONDS = 10
    public volatile static MainFrameInfo mainFrameParameter = new MainFrameInfo();

    static boolean WRITE_BACK = false

//    static OracleConn baseOracleConnection = baseConnection()
    static OracleConn bulkOracleConnection = bulkConnection()
    static OracleConn n4OracleConnection = n4Connection()

//    static N4Operator n4Operator = getN4Operator()

    static N4Operator n4Operator = ConnectorFactory.createN4Operator("testserver");

    static String argoSQL = ""

    static boolean baseConnected = false
    static boolean bulkConnection = false
    static boolean n4Connection = false
    static boolean n4PortConnection = false


    private static OracleConn baseConnection() {
        System.out.println("集团基础数据库初始化开始")
        GlobalLogger.myLogger.info("Init baseConnection:")
        //　集团基础数据库
        def DB = 'jdbc:oracle:thin:@192.168.0.74:1521:swave'
        def USER = 'swavemvclw'
        def PASSWORD = 'swavemvclw'
        def DRIVER = 'oracle.jdbc.driver.OracleDriver'
        OracleConn newConn = new OracleConn(DB, USER, PASSWORD, DRIVER)
        baseConnected = newConn.isConnected
        System.out.println("集团基础数据库初始化完成")
        return newConn
    }

    private static OracleConn bulkConnection() {
        System.out.println("散货数据库初始化开始")
        GlobalLogger.myLogger.info("Init bulkConnection:")
        //　散货系统数据库
        def DB = 'jdbc:oracle:thin:@192.168.37.103:1521:database'
        def USER = 'lwjk'
        def PASSWORD = 'wzlwjk'
        def DRIVER = 'oracle.jdbc.driver.OracleDriver'

        OracleConn newConn = new OracleConn(DB, USER, PASSWORD, DRIVER)
        bulkConnection = newConn.isConnected
        System.out.println("散货数据库初始化完成")
        return newConn
    }

    private static OracleConn n4Connection() {
        System.out.println("n4数据库初始化开始")
        GlobalLogger.myLogger.info("Init n4Connection:")
        //　N4系统数据库
//        def IP = mainFrameParameter.p_IsTestEnv ? "192.168.37.111" : "192.168.37.110"
        def IP = mainFrameParameter.p_IsTestEnv ? "192.168.3.10" : "192.168.37.110"//鼎和汇本地N4
        def DB = "jdbc:oracle:thin:@" + IP + ":1521:n4"
        def USER = "n4user"
        def PASSWORD = "n4user"
        def DRIVER = 'oracle.jdbc.driver.OracleDriver'

        OracleConn newConn = new OracleConn(DB, USER, PASSWORD, DRIVER)
        n4Connection = newConn.isConnected
        System.out.println("n4数据库初始化完成")
        return newConn
    }


    private static N4Operator getN4Operator() {
        GlobalLogger.myLogger.info("Init N4PortConnection:")
        //N4系统连接
//        def IP = mainFrameParameter.p_IsTestEnv ? "192.168.37.111" : "192.168.37.112"
        def IP = mainFrameParameter.p_IsTestEnv ? "192.168.3.10" : "192.168.37.112"//鼎合汇本地N4
        String ArgoServiceURL = "http://" + IP + ":9080/apex/services/argoservice"
        String OperatorId = "WZCT"
        String ComplexId = "WZT"
        String FacilityId = "LWT"
        String YardId = "LWT"

        String UserName = "admin"
        String Password = "itadmin"

        N4Operator newOperator = new N4Operator()

        newOperator.argoServiceUrl = ArgoServiceURL
        newOperator.operatorId = OperatorId
        newOperator.complexId = ComplexId
        newOperator.facilityId = FacilityId
        newOperator.yardId = FacilityId

        newOperator.username = UserName
        newOperator.password = Password

        newOperator.initRequest()
        n4PortConnection = newOperator.isconnected
        return newOperator;
    }
}
