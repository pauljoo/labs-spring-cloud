package info.xpanda.labs.spring.cloud.plugin.user.noop.config;

import info.xpanda.labs.spring.cloud.plugin.user.facade.spi.SingleMethodService;
import info.xpanda.labs.spring.cloud.plugin.user.facade.spi.UserService;
import info.xpanda.labs.spring.cloud.plugin.user.noop.NoopSingleMethodServiceImpl;
import info.xpanda.labs.spring.cloud.plugin.user.noop.NoopUserServiceImpl;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @author Paul Jiang
 * @since 20200206
 */
@Configuration
@AutoConfigureOrder
public class UserConfig {

    /**
     * 默认实现采用
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    public UserService userService(){
        return new NoopUserServiceImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public SingleMethodService singleMethodService(){
        return new NoopSingleMethodServiceImpl();
    }
}
