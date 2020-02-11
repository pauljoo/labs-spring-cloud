package info.xpanda.labs.spring.cloud.xds.cluster;

import lombok.Data;

/**
 * @author Paul Jiang
 * @since 20200211
 */
@Data
public class Endpoint {
    private Address address;

    @Data
    public static class Address {
        private SocketAddress socket_address;
    }
}
