package info.xpanda.labs.spring.cloud.xds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Paul Jiang
 * @since 20200211
 */
@SpringBootApplication
@EnableDiscoveryClient
public class XdsApplication {

    public static void main(String[] args) {
        SpringApplication.run(XdsApplication.class, args);
    }

}
