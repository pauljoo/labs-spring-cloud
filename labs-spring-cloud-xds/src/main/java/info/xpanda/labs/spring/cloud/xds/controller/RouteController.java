package info.xpanda.labs.spring.cloud.xds.controller;

import io.envoyproxy.envoy.api.v2.DiscoveryResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Paul Jiang
 * @since 20200212
 */
@RestController
@Slf4j
public class RouteController {
    @RequestMapping("/v2/discovery:routes")
    public DiscoveryResponse discovery() {
        DiscoveryResponse response = DiscoveryResponse.newBuilder().build();
        return null;
    }
}
