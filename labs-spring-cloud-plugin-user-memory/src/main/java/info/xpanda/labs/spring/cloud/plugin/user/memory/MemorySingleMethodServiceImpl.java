package info.xpanda.labs.spring.cloud.plugin.user.memory;

import info.xpanda.labs.spring.cloud.plugin.user.facade.spi.SingleMethodService;

/**
 * @author Paul Jiang
 * @since 20200206
 */
public class MemorySingleMethodServiceImpl implements SingleMethodService {
    @Override
    public String message1() {
        return "memory message1";
    }

    @Override
    public String message2() {
        return "memory message1";
    }
}
