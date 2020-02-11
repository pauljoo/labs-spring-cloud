package info.xpanda.labs.spring.cloud.xds.cluster;

import lombok.Data;

import java.util.List;

/**
 * @author Paul Jiang
 * @since 20200211
 */
@Data
public class LbEndpoints {
    private List<Endpoint> endpoint;
}
