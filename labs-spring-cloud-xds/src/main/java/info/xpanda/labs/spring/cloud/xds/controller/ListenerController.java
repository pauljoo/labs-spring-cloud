package info.xpanda.labs.spring.cloud.xds.controller;

import com.google.protobuf.Any;
import com.googlecode.protobuf.format.JsonFormat;
import io.envoyproxy.envoy.api.v2.DiscoveryRequest;
import io.envoyproxy.envoy.api.v2.DiscoveryResponse;
import io.envoyproxy.envoy.api.v2.Listener;
import io.envoyproxy.envoy.api.v2.RouteConfiguration;
import io.envoyproxy.envoy.api.v2.core.Address;
import io.envoyproxy.envoy.api.v2.core.SocketAddress;
import io.envoyproxy.envoy.api.v2.listener.Filter;
import io.envoyproxy.envoy.api.v2.listener.FilterChain;
import io.envoyproxy.envoy.api.v2.route.Route;
import io.envoyproxy.envoy.api.v2.route.RouteAction;
import io.envoyproxy.envoy.api.v2.route.RouteMatch;
import io.envoyproxy.envoy.api.v2.route.VirtualHost;
import io.envoyproxy.envoy.config.filter.network.http_connection_manager.v2.HttpConnectionManager;
import io.envoyproxy.envoy.config.filter.network.http_connection_manager.v2.HttpFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Paul Jiang
 * @since 20200212
 */
@RestController
@Slf4j
public class ListenerController {
    @RequestMapping("/v2/discovery:listeners")
    public String discovery(DiscoveryRequest request) {
        RouteMatch routeMatch1 = RouteMatch.newBuilder()
                .setPrefix("/service-system")
                .build();
        RouteAction routeAction1 = RouteAction.newBuilder()
                .setPrefixRewrite("/")
                .setCluster("labs-spring-cloud-service-system")
                .build();
        Route route1 = Route.newBuilder()
                .setMatch(routeMatch1)
                .setRoute(routeAction1)
                .build();

        RouteMatch routeMatch2 = RouteMatch.newBuilder()
                .setPrefix("/service-system")
                .build();
        RouteAction routeAction2 = RouteAction.newBuilder()
                .setPrefixRewrite("/")
                .setCluster("labs-spring-cloud-service-system")
                .build();
        Route route2 = Route.newBuilder()
                .setMatch(routeMatch2)
                .setRoute(routeAction2)
                .build();

        VirtualHost virtualHost = VirtualHost.newBuilder()
                .setName("local_service")
                .addDomains("*")
                .addRoutes(route1)
                .addRoutes(route2)
                .build();
        RouteConfiguration routeConfiguration = RouteConfiguration.newBuilder()
                .setName("local_route")
                .addVirtualHosts(virtualHost)
                .build();

        HttpFilter httpFilter = HttpFilter.newBuilder()
                .setName("envoy.router")
                .build();
        HttpConnectionManager connectionManager = HttpConnectionManager.newBuilder()
                .setRouteConfig(routeConfiguration)
                .addHttpFilters(httpFilter)
                .build();

        Filter filter = Filter.newBuilder()
                .setName("envoy.http_connection_manager")
                .setTypedConfig(Any.pack(connectionManager))
                .build();
        FilterChain filterChain = FilterChain.newBuilder()
                .addFilters(filter)
                .build();

        Listener listener = Listener.newBuilder()
                .setName("listener_0")
                .setAddress(Address.newBuilder()
                        .setSocketAddress(SocketAddress.newBuilder().setAddress("0.0.0.0").setPortValue(10000))
                        .build())
                .addFilterChains(filterChain)
                .build();

        DiscoveryResponse response = DiscoveryResponse.newBuilder()
                .setVersionInfo("1")
                .addResources(Any.pack(listener))
                .build();

        return JsonFormat.printToString(response);
    }
}
