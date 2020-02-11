package info.xpanda.labs.spring.cloud.xds.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author Paul Jiang
 * @since 20200211
 */
@RestController
@Slf4j
public class XdsController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/v2/discovery:clusters")
    public String cluster(HttpServletRequest request, @RequestBody(required = false) String body){
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            log.info("header:" + headerName + "=" + request.getHeader(headerName));
        }
        log.info(body);
        return "";
    }
}
