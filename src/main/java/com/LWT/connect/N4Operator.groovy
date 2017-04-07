package com.LWT.connect

import com.navis.argo.webservice.types.v1_0.GenericInvokeResponseWsType
import com.navis.argo.webservice.types.v1_0.QueryResultType
import com.navis.argo.webservice.types.v1_0.ResponseType
import com.navis.argo.webservice.types.v1_0.ScopeCoordinateIdsWsType
import com.navis.www.services.argoservice.ArgoServiceLocator
import com.navis.www.services.argoservice.ArgoServicePort

import javax.xml.rpc.Stub

class N4Operator {
    static String OK = "0"
    static String INFO = "1"
    static String WARNINGS = "2"
    static String ERRORS = "3"

    String argoServiceUrl
    String username = ""
    String password = ""

    String operatorId
    String complexId
    String facilityId
    String yardId

    ScopeCoordinateIdsWsType scope
    ArgoServiceLocator service
    ArgoServicePort port

    String status = ""
    String payload = ""
    String[] results = null

    N4Operator() {
    }
    // 初始化
    def initRequest() {
        try {
            // ?指定的 Operator/Complex/Facility/Yard : WZCT/WZT/LWT_Old/LWT_Old
            this.scope = new ScopeCoordinateIdsWsType()
            this.scope.setOperatorId(this.operatorId)
            this.scope.setComplexId(this.complexId)
            this.scope.setFacilityId(this.facilityId)
            this.scope.setYardId(this.yardId)
            // 确定Web服务主机
            this.service = new ArgoServiceLocator()
            this.port = this.service.getArgoServicePort(new URL(this.argoServiceUrl))
            Stub stub = (Stub) this.port

            // 指定用户名和密码
            stub._setProperty(Stub.USERNAME_PROPERTY, this.username)
            stub._setProperty(Stub.PASSWORD_PROPERTY, this.password)


        } catch (Exception e) {
            e.printStackTrace()
        }
    }

    // 发送带XML的请求，返回执行结果状态
    def sendRequestWithXml(String _xmlString) {
        // 发送请求
        GenericInvokeResponseWsType response = this.port.genericInvoke(this.scope, _xmlString)
        this.payload = response.getResponsePayLoad()
        // 解析API响应
        ResponseType commonResponse = response.getCommonResponse()
        // 获取执行状态
        this.status = commonResponse.getStatus()

        if (commonResponse.getQueryResults() == null) {
            this.results = new String[0]
        } else {
            this.results = new String[commonResponse.getQueryResults().length]
            commonResponse.getQueryResults().eachWithIndex { QueryResultType resultType, int i ->
                this.results[i] = resultType.getResult()
            }
        }
        return this.status
    }
}

