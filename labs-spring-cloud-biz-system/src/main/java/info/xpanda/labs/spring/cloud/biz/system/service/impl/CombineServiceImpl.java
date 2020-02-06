package info.xpanda.labs.spring.cloud.biz.system.service.impl;

import info.xpanda.labs.spring.cloud.biz.system.service.CombineService;
import org.springframework.stereotype.Service;

/**
 * @author Paul Jiang
 * @since 20200206
 */
@Service
public class CombineServiceImpl implements CombineService {
    @Override
    public String combine() {
        return "combine";
    }
}
