package info.xpanda.labs.spring.cloud.service.envoy.service.impl;

import info.xpanda.labs.spring.cloud.service.envoy.service.EnvoyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class EnvoyServiceImpl implements EnvoyService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${envoy.path}")
    private String path;

    @Override
    public String user() {
        String info = restTemplate.getForObject(path + "/service-user/user/info", String.class);
        return "===call user response(" + info + ")";
    }

    @Override
    public String system() {
        String info = restTemplate.getForObject(path + "/service-system/system/info", String.class);
        return "===call system response(" + info + ")";
    }
}
