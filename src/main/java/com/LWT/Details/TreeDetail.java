package com.LWT.Details;

/**
 * Created by ThinkPad on 2017-04-25.
 * 收费条件
 */
public class TreeDetail {

    private String GKEY;
    private String VERB;
    private String METAFIELD;
    private String VALUE;
    private String UIVALUE;
    private String NEGATED;
    private String NEXT_EMAPP_GKEY;
    private String SUB_EMAPP_GKEY;

    public String getGKEY() {
        return GKEY;
    }

    public void setGKEY(String GKEY) {
        this.GKEY = GKEY;
    }

    public String getVERB() {
        return VERB;
    }

    public void setVERB(String VERB) {
        this.VERB = VERB;
    }

    public String getMETAFIELD() {
        return METAFIELD;
    }

    public void setMETAFIELD(String METAFIELD) {
        this.METAFIELD = METAFIELD;
    }

    public String getVALUE() {
        return VALUE;
    }

    public void setVALUE(String VALUE) {
        this.VALUE = VALUE;
    }

    public String getUIVALUE() {
        return UIVALUE;
    }

    public void setUIVALUE(String UIVALUE) {
        this.UIVALUE = UIVALUE;
    }

    public String getNEGATED() {
        return NEGATED;
    }

    public void setNEGATED(String NEGATED) {
        this.NEGATED = NEGATED;
    }

    public String getNEXT_EMAPP_GKEY() {
        return NEXT_EMAPP_GKEY;
    }

    public void setNEXT_EMAPP_GKEY(String NEXT_EMAPP_GKEY) {
        this.NEXT_EMAPP_GKEY = NEXT_EMAPP_GKEY;
    }

    public String getSUB_EMAPP_GKEY() {
        return SUB_EMAPP_GKEY;
    }

    public void setSUB_EMAPP_GKEY(String SUB_EMAPP_GKEY) {
        this.SUB_EMAPP_GKEY = SUB_EMAPP_GKEY;
    }
}
