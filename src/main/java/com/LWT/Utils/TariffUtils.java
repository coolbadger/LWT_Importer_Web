package com.LWT.Utils;

import com.LWT.Details.Event;
import com.LWT.Entity.SNX_BBK_Unit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ThinkPad on 2017-04-19.
 */
public class TariffUtils {

    public static List<Event> createEvent(SNX_BBK_Unit snx_bbk_unit){

        List<Event> events = new ArrayList<Event>();
        if("EXPORT".equals(snx_bbk_unit.getCategory())){
            Event event = new Event();
            event.setId("BBK_UNIT_LOAD");
            event.setQuantity(snx_bbk_unit.getUnitWeight().toString());
            event.setQuantity_unit("METRIC_TONNES");
            event.setNote("装船："+snx_bbk_unit.getUnitWeight().toString());
            event.setUser_id("snx:admin");
            event.setIs_billable("Y");
        }else{
            if (snx_bbk_unit.isIsYard()){
                Event event = new Event();
                event.setId("BBK_UNIT_DISCHARGE");
                event.setShipper_id(snx_bbk_unit.getUnitShiper().toString());
                event.setConsignee_id(snx_bbk_unit.getUnitConsignee().toString());
                event.setQuantity(snx_bbk_unit.getUnitWeight().toString());
                event.setQuantity_unit("METRIC_TONNES");
                event.setNote("卸船："+snx_bbk_unit.getUnitWeight());
                event.setUser_id("snx:admin");
                event.setIs_billable("Y");
            }else {
                if(snx_bbk_unit.isIsDirTake()){
                    Event event = new Event();
                    event.setId("BBK_UNIT_DISCHARGE");
                    event.setShipper_id(snx_bbk_unit.getUnitShiper().toString());
                    event.setConsignee_id(snx_bbk_unit.getUnitConsignee().toString());
                    event.setQuantity(snx_bbk_unit.getUnitWeight().toString());
                    event.setQuantity_unit("METRIC_TONNES");
                    event.setNote("直提："+snx_bbk_unit.getUnitWeight());
                    event.setUser_id("snx:admin");
                    event.setIs_billable("Y");
                }else {
                    Event event = new Event();
                    event.setId("BBK_UNIT_DISCHARGE");
                    event.setShipper_id(snx_bbk_unit.getUnitShiper().toString());
                    event.setConsignee_id(snx_bbk_unit.getUnitConsignee().toString());
                    event.setQuantity(snx_bbk_unit.getUnitWeight().toString());
                    event.setQuantity_unit("METRIC_TONNES");
                    event.setNote("堆存："+snx_bbk_unit.getUnitWeight());
                    event.setUser_id("snx:admin");
                    event.setIs_billable("Y");
                    events.add(event);
                    Event event1 = new Event();
                    event.setId("BBK_UNIT_DISCHARGE");
                    event.setShipper_id(snx_bbk_unit.getUnitShiper().toString());
                    event.setConsignee_id(snx_bbk_unit.getUnitConsignee().toString());
                    event.setQuantity(snx_bbk_unit.getUnitWeight().toString());
                    event.setQuantity_unit("METRIC_TONNES");
                    event.setNote("提货："+snx_bbk_unit.getUnitWeight());
                    event.setUser_id("snx:admin");
                    event.setIs_billable("Y");
                    events.add(event);
                }
            }
        }

        return events;
    }

}
