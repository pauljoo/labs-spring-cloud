package info.xpanda.labs.admin.service.user.service.impl;

import info.xpanda.labs.admin.service.user.remoting.SystemRemoting;
import info.xpanda.labs.admin.service.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private SystemRemoting systemRemoting;
    @Override
    public String info() {
        String info = systemRemoting.info();
        log.info("System Say: " + info);
        return info;
    }
}
