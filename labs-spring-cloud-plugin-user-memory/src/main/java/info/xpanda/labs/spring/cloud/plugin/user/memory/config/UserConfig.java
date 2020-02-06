package info.xpanda.labs.spring.cloud.plugin.user.memory.config;

import info.xpanda.labs.spring.cloud.plugin.user.facade.spi.UserService;
import info.xpanda.labs.spring.cloud.plugin.user.memory.MemoryUserServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Paul Jiang
 * @since 20200206
 */
@Configuration
public class UserConfig {

    @Bean
    @ConditionalOnMissingBean
    public UserService userService(){
        return new MemoryUserServiceImpl();
    }
}
