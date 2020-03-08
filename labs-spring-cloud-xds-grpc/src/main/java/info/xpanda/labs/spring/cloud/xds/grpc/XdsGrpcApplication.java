package info.xpanda.labs.spring.cloud.xds.grpc;

import info.xpanda.labs.spring.cloud.xds.grpc.xds.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.netty.NettyServerBuilder;

/**
 * @author Paul Jiang
 * @since 20200308
 */
public class XdsGrpcApplication {
    public static void main(String[] args) throws Exception{
        ServerBuilder builder = NettyServerBuilder.forPort(12345)
                .addService(new XpandaAggregatedDiscoveryServiceImpl())
                .addService(new XpandaClusterDiscoveryServiceImpl())
                .addService(new XpandaEndpointDiscoveryServiceImpl())
                .addService(new XpandaListenerDiscoveryServiceImpl())
                .addService(new XpandaRouteDiscoveryServiceImpl());
        Server server = builder.build();

        server.start();
    }
}
