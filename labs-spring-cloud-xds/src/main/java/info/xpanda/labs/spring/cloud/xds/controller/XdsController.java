package info.xpanda.labs.spring.cloud.xds.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Paul Jiang
 * @since 20200211
 */
@RestController
@Slf4j
public class XdsController {
    @RequestMapping("/v2/discovery:clusters")
    public String cluster(@RequestBody(required = false) String body){
        log.info(body);
        return "";
    }
}
