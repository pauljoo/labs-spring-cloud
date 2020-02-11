package info.xpanda.labs.admin.service.user.controller;

import info.xpanda.labs.admin.service.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Value("${spring.cloud.client.ipAddress}")
    private String ip;

    @Autowired
    private UserService userService;

    @RequestMapping("/info")
    @ResponseBody
    public String info(){
        String info = userService.info();
        return "I'm User Service!" + ip + info;
    }
}
