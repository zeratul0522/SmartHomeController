package cn.edu.fudan.selab.smartHomeController.controller;

import cn.edu.fudan.selab.smartHomeController.reasoning.DoorWindowStateReasoning;
import cn.edu.fudan.selab.smartHomeController.utility.Parameters;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Fan Zejun E-mail:fzj0522@outlook.com
 * @version 2018/1/25 下午9:07
 */
@RestController
public class DoorWindowStateController {

    @RequestMapping(value = Parameters.doorWindowStateApiString, method = RequestMethod.GET)
    public String index(){

        DoorWindowStateReasoning.execute();
        return "DoorWindowStateController called.";
    }
}