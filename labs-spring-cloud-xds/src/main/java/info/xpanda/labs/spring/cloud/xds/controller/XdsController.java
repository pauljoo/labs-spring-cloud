package info.xpanda.labs.spring.cloud.xds.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Paul Jiang
 * @since 20200211
 */
@RestController
public class XdsController {
    @RequestMapping("/v2/discovery:clusters")
    public String cluster(@RequestBody String body){
        System.out.println(body);
        return "";
    }
}
