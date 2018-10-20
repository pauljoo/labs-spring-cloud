package info.xpanda.labs.admin.service.user.remoting;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "labs-spring-cloud-admin-service-system", fallback = SystemRemotingHystrix.class)
@RequestMapping("/system")
public interface SystemRemoting {
    @GetMapping("/info")
    String info();
}
