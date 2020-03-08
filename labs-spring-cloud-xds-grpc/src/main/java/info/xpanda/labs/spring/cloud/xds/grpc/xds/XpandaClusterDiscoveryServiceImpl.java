package info.xpanda.labs.spring.cloud.xds.grpc.xds;

import io.envoyproxy.envoy.api.v2.*;
import io.grpc.stub.StreamObserver;

/**
 * @author Paul Jiang
 * @since 20200308
 */
public class XpandaClusterDiscoveryServiceImpl extends ClusterDiscoveryServiceGrpc.ClusterDiscoveryServiceImplBase {
    @Override
    public StreamObserver<DiscoveryRequest> streamClusters(StreamObserver<DiscoveryResponse> responseObserver) {
        return super.streamClusters(responseObserver);
    }

    @Override
    public StreamObserver<DeltaDiscoveryRequest> deltaClusters(StreamObserver<DeltaDiscoveryResponse> responseObserver) {
        return super.deltaClusters(responseObserver);
    }

    @Override
    public void fetchClusters(DiscoveryRequest request, StreamObserver<DiscoveryResponse> responseObserver) {
        super.fetchClusters(request, responseObserver);
    }
}
