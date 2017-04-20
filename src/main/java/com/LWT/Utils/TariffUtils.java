package com.LWT.Utils;

import com.LWT.Details.EventDetail;
import com.LWT.Entity.SNX_BBK_Unit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ThinkPad on 2017-04-19.
 */
public class TariffUtils {

    public static List<EventDetail> createEvent(SNX_BBK_Unit snx_bbk_unit){

        List<EventDetail> events = new ArrayList<EventDetail>();
        if("EXPORT".equals(snx_bbk_unit.getCategory())){
            EventDetail event = new EventDetail();
            event.setId("BBK_UNIT_LOAD");
            event.setQuantity(snx_bbk_unit.getUnitWeight().toString());
            event.setQuantity_unit("METRIC_TONNES");
            event.setNote("装船："+snx_bbk_unit.getUnitWeight().toString());
            event.setUser_id("snx:admin");
            event.setIs_billable("Y");
            events.add(event);
        }else{
            if (snx_bbk_unit.isIsYard()){
                EventDetail event = new EventDetail();
                event.setId("BBK_UNIT_DISCHARGE");
                event.setShipper_id(snx_bbk_unit.getUnitShiper().toString());
                event.setConsignee_id(snx_bbk_unit.getUnitConsignee().toString());
                event.setQuantity(snx_bbk_unit.getUnitWeight().toString());
                event.setQuantity_unit("METRIC_TONNES");
                event.setNote("卸船："+snx_bbk_unit.getUnitWeight());
                event.setUser_id("snx:admin");
                event.setIs_billable("Y");
                events.add(event);
            }else {
                if(snx_bbk_unit.isIsDirTake()){
                    EventDetail event = new EventDetail();
                    event.setId("BBK_UNIT_DISCHARGE");
                    event.setShipper_id(snx_bbk_unit.getUnitShiper().toString());
                    event.setConsignee_id(snx_bbk_unit.getUnitConsignee().toString());
                    event.setQuantity(snx_bbk_unit.getUnitWeight().toString());
                    event.setQuantity_unit("METRIC_TONNES");
                    event.setNote("直提："+snx_bbk_unit.getUnitWeight());
                    event.setUser_id("snx:admin");
                    event.setIs_billable("Y");
                    events.add(event);
                }else {
                    EventDetail event = new EventDetail();
                    event.setId("BBK_UNIT_DISCHARGE");
                    event.setShipper_id(snx_bbk_unit.getUnitShiper().toString());
                    event.setConsignee_id(snx_bbk_unit.getUnitConsignee().toString());
                    event.setQuantity(snx_bbk_unit.getUnitWeight().toString());
                    event.setQuantity_unit("METRIC_TONNES");
                    event.setNote("堆存："+snx_bbk_unit.getUnitWeight());
                    event.setUser_id("snx:admin");
                    event.setIs_billable("Y");
                    events.add(event);
                    EventDetail event1 = new EventDetail();
                    event1.setId("BBK_UNIT_DISCHARGE");
                    event1.setShipper_id(snx_bbk_unit.getUnitShiper().toString());
                    event1.setConsignee_id(snx_bbk_unit.getUnitConsignee().toString());
                    event1.setQuantity(snx_bbk_unit.getUnitWeight().toString());
                    event1.setQuantity_unit("METRIC_TONNES");
                    event1.setNote("提货："+snx_bbk_unit.getUnitWeight());
                    event1.setUser_id("snx:admin");
                    event1.setIs_billable("Y");
                    events.add(event1);
                }
            }
        }

        return events;
    }

}
