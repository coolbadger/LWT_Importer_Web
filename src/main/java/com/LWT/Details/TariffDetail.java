package com.LWT.Details;

/**
 * Created by ThinkPad on 2017-04-20.
 */
public class TariffDetail {

    private String tariffId;//费目id
    private String tariffName;//费目名
    private String value;//钱数
    private String tariffType;//合同种类

    public String getTariffId() {
        return tariffId;
    }

    public void setTariffId(String tariffId) {
        this.tariffId = tariffId;
    }

    public String getTariffType() {
        return tariffType;
    }

    public void setTariffType(String tariffType) {
        this.tariffType = tariffType;
    }

    public String getTariffName() {
        return tariffName;
    }

    public void setTariffName(String tariffName) {
        this.tariffName = tariffName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
