package info.xpanda.labs.spring.cloud.xds.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Paul Jiang
 * @since 20200212
 */
@RestController
@Slf4j
public class EndpointController {
    @RequestMapping("/v2/discovery:endpoints")
    public Map<String, Object> discovery() {
        return null;
    }
}
