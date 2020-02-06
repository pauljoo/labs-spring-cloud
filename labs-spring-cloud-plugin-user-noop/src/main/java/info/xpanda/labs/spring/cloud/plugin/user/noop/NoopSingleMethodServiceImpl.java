package info.xpanda.labs.spring.cloud.plugin.user.noop;

import info.xpanda.labs.spring.cloud.plugin.user.facade.spi.SingleMethodService;

/**
 * @author Paul Jiang
 * @since 20200206
 */
public class NoopSingleMethodServiceImpl implements SingleMethodService {
    @Override
    public String message1() {
        return "noop message1";
    }

    @Override
    public String message2() {
        return "noop message2";
    }
}
