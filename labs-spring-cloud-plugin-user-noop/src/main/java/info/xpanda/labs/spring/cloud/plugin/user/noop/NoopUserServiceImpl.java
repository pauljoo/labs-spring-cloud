package info.xpanda.labs.spring.cloud.plugin.user.noop;

import info.xpanda.labs.spring.cloud.plugin.user.facade.model.UserModel;
import info.xpanda.labs.spring.cloud.plugin.user.facade.spi.UserService;

/**
 * @author Paul Jiang
 * @since 20200206
 */
public class NoopUserServiceImpl implements UserService {
    @Override
    public UserModel findByName(String name) {
        UserModel model = new UserModel();
        model.setName("noop");
        return model;
    }
}
