package info.xpanda.labs.spring.cloud.xds;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author Paul Jiang
 * @since 20200211
 */
@SpringCloudApplication
public class XdsApplication {
    public static void main(String[] args) {
        SpringApplication.run(XdsApplication.class, args);
    }

}
