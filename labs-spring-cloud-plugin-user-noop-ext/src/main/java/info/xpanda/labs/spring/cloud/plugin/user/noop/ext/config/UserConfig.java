package info.xpanda.labs.spring.cloud.plugin.user.noop.ext.config;

import info.xpanda.labs.spring.cloud.plugin.user.facade.spi.SingleMethodService;
import info.xpanda.labs.spring.cloud.plugin.user.facade.spi.UserService;
import info.xpanda.labs.spring.cloud.plugin.user.noop.NoopSingleMethodServiceImpl;
import info.xpanda.labs.spring.cloud.plugin.user.noop.NoopUserServiceImpl;
import info.xpanda.labs.spring.cloud.plugin.user.noop.ext.ExtNoopSingleMethodServiceImpl;
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
@AutoConfigureOrder(Ordered.LOWEST_PRECEDENCE - 1)
public class UserConfig {

    @Bean
    @ConditionalOnMissingBean
    public SingleMethodService singleMethodService(){
        return new ExtNoopSingleMethodServiceImpl();
    }
}
