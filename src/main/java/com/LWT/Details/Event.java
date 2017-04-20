package com.LWT.Details;

/**
 * Created by ThinkPad on 2017-04-19.
 */
public class Event {

    private String id;//事件类型
    private String shipper_id;//发货人
    private String consignee_id;//收货人
    private String quantity;//重量
    private String quantity_unit;//重量单位
    private String note;//记录
    private String user_id;//操作员
    private String is_billable;//是否收费

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShipper_id() {
        return shipper_id;
    }

    public void setShipper_id(String shipper_id) {
        this.shipper_id = shipper_id;
    }

    public String getConsignee_id() {
        return consignee_id;
    }

    public void setConsignee_id(String consignee_id) {
        this.consignee_id = consignee_id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getQuantity_unit() {
        return quantity_unit;
    }

    public void setQuantity_unit(String quantity_unit) {
        this.quantity_unit = quantity_unit;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getIs_billable() {
        return is_billable;
    }

    public void setIs_billable(String is_billable) {
        this.is_billable = is_billable;
    }
}
