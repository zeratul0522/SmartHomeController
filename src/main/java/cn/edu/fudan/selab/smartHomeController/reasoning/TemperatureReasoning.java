package cn.edu.fudan.selab.smartHomeController.reasoning;

import cn.edu.fudan.selab.smartHomeController.utility.HttpRequest4DeviceStates;
import cn.edu.fudan.selab.smartHomeController.utility.Parameters;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TemperatureReasoning {
    public static void execute(double value){
        List<String> entityList = new ArrayList<String>();
        entityList.add(Parameters.entityId4Temperature);
        entityList.add(Parameters.entityId4Humidity);

        Iterator<String> it = entityList.iterator();
        while(it.hasNext()){
            String currentEntityId = it.next();
            JSONObject obj = JSON.parseObject(HttpRequest4DeviceStates.getDeviceStateById(currentEntityId));
            System.out.println(currentEntityId + " " + obj.get("state"));
            if (obj.get("entity_id").equals(Parameters.entityId4Temperature))
            {
                if(obj.get("state") != null){
                    Parameters.currentTemperature = (String) obj.get("state");
                }
            }
            else
            {
                if(obj.get("state") != null){
                    Parameters.currentHumidity = (String) obj.get("state");
                }
            }

        }
    }
}


/**
 * entity_id: binary_sensor_.door_window_sensor_158d0002026341 实验室大门
 * entity_id: binary_sensor_.door_window_sensor_ 实验室大门
 * entity_id: binary_sensor_.door_window_sensor_158d0002026341 实验室大门
 * entity_id: binary_sensor_.door_window_sensor_158d0002026341 实验室大门
 * entity_id: binary_sensor_.door_window_sensor_158d0002026341 实验室大门
 *
 *
 */
