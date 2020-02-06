package info.xpanda.labs.spring.cloud.biz.system.controller;

import info.xpanda.labs.spring.cloud.biz.system.service.CombineService;
import info.xpanda.labs.spring.cloud.plugin.user.facade.model.UserModel;
import info.xpanda.labs.spring.cloud.plugin.user.facade.spi.SingleMethodService;
import info.xpanda.labs.spring.cloud.plugin.user.facade.spi.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Paul Jiang
 * @since 20200206
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SingleMethodService singleMethodService;

    @Autowired
    private CombineService combineService;

    @RequestMapping("/findByName")
    public UserModel findByName(String name){
        return userService.findByName(name);
    }

    @RequestMapping("/message1")
    public String message1(){
        return singleMethodService.message1();
    }

    @RequestMapping("/combine")
    public String combine(){
        return combineService.combine();
    }
}
