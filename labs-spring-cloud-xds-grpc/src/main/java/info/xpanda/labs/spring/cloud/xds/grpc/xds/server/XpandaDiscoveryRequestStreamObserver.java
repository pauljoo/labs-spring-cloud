package info.xpanda.labs.spring.cloud.xds.grpc.xds.server;

import io.envoyproxy.envoy.api.v2.DiscoveryRequest;
import io.grpc.stub.StreamObserver;

/**
 * @author Paul Jiang
 * @since 20200308
 */
public class XpandaDiscoveryRequestStreamObserver implements StreamObserver<DiscoveryRequest> {
    @Override
    public void onNext(DiscoveryRequest request) {

    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onCompleted() {

    }
}
