package com.LWT.Utils;

import com.LWT.Details.TreeDetail;
import com.LWT.Entity.Conversion;

/**
 * Created by badger on 2017/5/11.
 */
public class Tariff {
    Conversion conversion;
    String feeCode;

    public Tariff(Conversion conversion) {
        this.conversion = conversion;
    }

    public String getFeeCode(String currentFeeCode) {
        feeCode = "none";
        //根据currentFeeCode获取treeDetail
        TreeDetail treeDetail = new TreeDetail();

        //根据conversion与treeDetail中对比条件，获取要对比的值
        String value = "";

        //如果符合条件，则当前treeDetail即是对应的费目
        if (treeDetail.getVALUE().contains(value)) {
            if (treeDetail.getSUB_EMAPP_GKEY() != null) {
                feeCode = getFeeCode(treeDetail.getNEXT_EMAPP_GKEY());
            } else
                feeCode = treeDetail.getGKEY();

        } else if (treeDetail.getNEXT_EMAPP_GKEY() != null) {
            feeCode = getFeeCode(treeDetail.getNEXT_EMAPP_GKEY());
        }

        return feeCode;
    }
}
