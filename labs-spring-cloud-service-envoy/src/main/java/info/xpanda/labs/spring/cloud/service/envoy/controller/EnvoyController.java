package info.xpanda.labs.spring.cloud.service.envoy.controller;

import info.xpanda.labs.spring.cloud.service.envoy.service.EnvoyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/envoy")
public class EnvoyController {
    @Value("${spring.cloud.client.ipAddress}")
    private String ip;

    @Autowired
    private EnvoyService envoyService;

    @RequestMapping("/user")
    @ResponseBody
    public String user(){
        String info = envoyService.user();
        return "I'm Envoy Service!" + ip + info;
    }

    @RequestMapping("/system")
    @ResponseBody
    public String system(){
        String info = envoyService.system();
        return "I'm Envoy Service!" + ip + info;
    }
}
