package cn.edu.fudan.selab.smartHomeController.controller;

import cn.edu.fudan.selab.smartHomeController.reasoning.DoorWindowStateReasoning;
import cn.edu.fudan.selab.smartHomeController.reasoning.PaperStateReasoning;
import cn.edu.fudan.selab.smartHomeController.utility.Parameters;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import cn.edu.fudan.selab.smartHomeController.reasoning.TemperatureReasoning;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TemperatureController {
    @RequestMapping(value = Parameters.TemperatureApiDouble, method = RequestMethod.GET)
    @ResponseBody
    public String get_temperature() {
        JSONObject resultObj = new JSONObject();
        JSONArray arr = new JSONArray();
        arr.add("temperature");
        arr.add(Parameters.currentTemperature);
        arr.add("humidity");
        arr.add(Parameters.currentHumidity);
        System.out.println("TemperatureController has been called. Temperature has returned" + arr.get(0) + arr.get(1));
        /*
        返回的string中的格式必须是callback(json),详见前台代码里ajax部分
         */
        return "temperature(" + arr.toString() + ")";
    }

}
