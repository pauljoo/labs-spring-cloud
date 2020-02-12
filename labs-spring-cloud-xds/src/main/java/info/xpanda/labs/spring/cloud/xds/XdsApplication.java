package info.xpanda.labs.spring.cloud.xds;

import com.google.common.collect.ImmutableList;
import com.google.protobuf.Duration;
import io.envoyproxy.controlplane.cache.SimpleCache;
import io.envoyproxy.controlplane.cache.Snapshot;
import io.envoyproxy.controlplane.server.DiscoveryServer;
import io.envoyproxy.envoy.api.v2.Cluster;
import io.envoyproxy.envoy.api.v2.core.Address;
import io.envoyproxy.envoy.api.v2.core.SocketAddress;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.netty.NettyServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author Paul Jiang
 * @since 20200211
 */
@SpringCloudApplication
public class XdsApplication {
    private static final String GROUP = "key";


    public static void main(String[] args) {
//        SimpleCache<String> cache = new SimpleCache<>(node -> GROUP);
//
//        cache.setSnapshot(
//                GROUP,
//                Snapshot.create(
//                        ImmutableList.of(
//                                Cluster.newBuilder()
//                                        .setName("cluster0")
//                                        .setConnectTimeout(Duration.newBuilder().setSeconds(5))
//                                        .setType(Cluster.DiscoveryType.STATIC)
//                                        .addHosts(Address.newBuilder()
//                                                .setSocketAddress(SocketAddress.newBuilder().setAddress("127.0.0.1").setPortValue(1234)))
//                                        .build()),
//                        ImmutableList.of(),
//                        ImmutableList.of(),
//                        ImmutableList.of(),
//                        ImmutableList.of(),
//                        "1"));
//
//        DiscoveryServer discoveryServer = new DiscoveryServer(cache);
//
//        ServerBuilder builder = NettyServerBuilder.forPort(12345)
//                .addService(discoveryServer.getAggregatedDiscoveryServiceImpl())
//                .addService(discoveryServer.getClusterDiscoveryServiceImpl())
//                .addService(discoveryServer.getEndpointDiscoveryServiceImpl())
//                .addService(discoveryServer.getListenerDiscoveryServiceImpl())
//                .addService(discoveryServer.getRouteDiscoveryServiceImpl());
//
//        Server server = builder.build();
//
//        server.start();
//
//        System.out.println("Server has started on port " + server.getPort());
//
//        Runtime.getRuntime().addShutdownHook(new Thread(server::shutdown));

        SpringApplication.run(XdsApplication.class, args);
    }

}
