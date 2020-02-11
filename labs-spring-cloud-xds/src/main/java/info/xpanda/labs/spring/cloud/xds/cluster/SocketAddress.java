package info.xpanda.labs.spring.cloud.xds.cluster;

import lombok.Data;

/**
 * @author Paul Jiang
 * @since 20200211
 */
@Data
public class SocketAddress {
    private String address;

    private Integer port_value;
}
