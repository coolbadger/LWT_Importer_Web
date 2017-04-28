package com.LWT.connect

/**
 * Created by lekoxnfx on 2017/3/15.
 */
class ConnectorFactory {
    public static N4Operator createN4Operator(String destserver){
//先改为鼎合汇办公室的配置
        String argoServiceUrl
//        String operatorId = "WZCT"
        String operatorId = "ZSCT"
//        String complexId = "WZT"
        String complexId = "ZST"
//        String facilityId = "LWT"
        String facilityId = "DLT"
//        String yardId = "LWT"
        String yardId = "DLT"



        N4Operator n4Operator = new N4Operator();
        switch (destserver){
            case "testserver":
//                argoServiceUrl = "http://192.168.37.111:9080/apex/services/argoservice"
                argoServiceUrl = "http://192.168.3.10:9080/apex/services/argoservice"
            break;
            case "productserver":
                argoServiceUrl = "http://192.168.37.112:9080/apex/services/argoservice"
            break;
        }

        n4Operator.argoServiceUrl = argoServiceUrl
        n4Operator.operatorId = operatorId
        n4Operator.complexId = complexId
        n4Operator.facilityId = facilityId
        n4Operator.yardId = yardId

        return n4Operator
    }
    public static DBAdapter createBulkDBAdatper(){
        String dbUrl = 'jdbc:oracle:thin:@192.168.37.103:1521:database'
        String username = 'lwjk'
        String password = 'wzlwjk'
        String driver = 'oracle.jdbc.driver.OracleDriver'

        DBAdapter dbAdapter = new DBAdapter(dbUrl, username, password, driver)
        return dbAdapter
    }
    public static DBAdapter createN4DBAdapter(String destserver){
        String dbUrl
        String username = "n4user"
        String password
        String driver = 'oracle.jdbc.driver.OracleDriver'

        switch (destserver){
            case "testserver":
//                dbUrl = "jdbc:oracle:thin:@192.168.37.111:1521:n4"
                dbUrl = "jdbc:oracle:thin:@192.168.3.10:1521:n4"
                password = "n4user"
                break;
            case "productserver":
                dbUrl = "jdbc:oracle:thin:@192.168.37.110:1521:n4"
                dbUrl = "n4lwt"
                break;
        }
        DBAdapter dbAdapter = new DBAdapter(dbUrl, username, password, driver)
        return dbAdapter
    }

}
