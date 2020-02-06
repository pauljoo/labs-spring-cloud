package info.xpanda.labs.spring.cloud.plugin.user.facade.spi;

import info.xpanda.labs.spring.cloud.plugin.user.facade.model.UserModel;

public interface UserService {
    UserModel findByName(String name);
}
