package info.xpanda.labs.spring.cloud.plugin.user.noop.ext;

import info.xpanda.labs.spring.cloud.plugin.user.noop.NoopSingleMethodServiceImpl;

/**
 * @author Paul Jiang
 * @since 20200206
 */
public class ExtNoopSingleMethodServiceImpl extends NoopSingleMethodServiceImpl{
    @Override
    public String message1() {
        return "ext noop message1";
    }
}
