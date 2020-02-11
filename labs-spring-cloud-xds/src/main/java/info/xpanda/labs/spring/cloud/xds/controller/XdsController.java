package info.xpanda.labs.spring.cloud.xds.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import info.xpanda.labs.spring.cloud.xds.cluster.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.Yaml;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

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
    public Map<String, Object> cluster(HttpServletRequest request, @RequestBody(required = false) String body)
            throws Exception {
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            log.info("header:" + headerName + "=" + request.getHeader(headerName));
        }

        Map<String, Object> response = new HashMap<>();
        response.put("version_info", "0");
        List<LoadAssignment> resources = new ArrayList<>();
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            LoadAssignment resource = createrCluster(service);
            resources.add(resource);
        }
        response.put("resources", resources);

        Yaml yaml = new Yaml();
        log.info(yaml.dump(response));

        ObjectMapper mapper = new ObjectMapper();
        log.info(mapper.writer().writeValueAsString(response));
        return response;
    }

    private LoadAssignment createrCluster(String name) {
        List<ServiceInstance> instances = discoveryClient.getInstances(name);

        LoadAssignment loadAssignment = new LoadAssignment();
        loadAssignment.setCluster_name(name);
        loadAssignment.setEndpoints(createEndpoints(instances));
        return loadAssignment;
    }

    private List<Endpoints> createEndpoints(List<ServiceInstance> instances) {
        Endpoints endpoint = new Endpoints();
        endpoint.setLb_endpoints(createLbEndpoints(instances));

        List<Endpoints> endpoints = new ArrayList<>();
        endpoints.add(endpoint);
        return endpoints;
    }

    private List<LbEndpoints> createLbEndpoints(List<ServiceInstance> instances) {
        List<Endpoint> endpoints = new ArrayList<>();
        for (ServiceInstance instance : instances) {
            SocketAddress socketAddress = new SocketAddress();
            socketAddress.setAddress(instance.getHost());
            socketAddress.setPort_value(instance.getPort());

            Endpoint.Address address = new Endpoint.Address();
            address.setSocket_address(socketAddress);

            Endpoint endpoint = new Endpoint();
            endpoint.setAddress(address);

            endpoints.add(endpoint);
        }

        LbEndpoints lbEndpoint = new LbEndpoints();
        lbEndpoint.setEndpoint(endpoints);

        List<LbEndpoints> lbEndpoints = new ArrayList<>();
        lbEndpoints.add(lbEndpoint);
        return lbEndpoints;
    }
}
