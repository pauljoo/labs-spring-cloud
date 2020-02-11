#端口号
|服务名|端口|
|-|-|
|labs-spring-cloud-registry|15000|
|labs-spring-cloud-service-user|25000|
|labs-spring-cloud-service-system|25001|


git clone https://github.com/pauljoo/labs-spring-cloud.git
mvn clean install -Dmaven.test.skip=true

mkdir -p /data/dockerfile/labs-spring-cloud-registry
cd /data/dockerfile/labs-spring-cloud-registry
\cp -f /root/labs-spring-cloud/labs-spring-cloud-registry/client.xml /data/dockerfile/labs-spring-cloud-registry
\cp -f /root/labs-spring-cloud/labs-spring-cloud-registry/Dockerfile /data/dockerfile/labs-spring-cloud-registry
\cp -f /root/labs-spring-cloud/labs-spring-cloud-registry/target/labs-spring-cloud-registry.jar /data/dockerfile/labs-spring-cloud-registry
docker build -t xpanda/labs-spring-cloud-registry:latest .

mkdir -p /data/dockerfile/labs-spring-cloud-service-system
cd /data/dockerfile/labs-spring-cloud-service-system
\cp -f /root/labs-spring-cloud/labs-spring-cloud-service-system/client.xml /data/dockerfile/labs-spring-cloud-service-system
\cp -f /root/labs-spring-cloud/labs-spring-cloud-service-system/Dockerfile /data/dockerfile/labs-spring-cloud-service-system
\cp -f /root/labs-spring-cloud/labs-spring-cloud-service-system/target/labs-spring-cloud-service-system.jar /data/dockerfile/labs-spring-cloud-service-system
docker build -t xpanda/labs-spring-cloud-service-system:latest .

mkdir -p /data/dockerfile/labs-spring-cloud-service-user
cd /data/dockerfile/labs-spring-cloud-service-user
\cp -f /root/labs-spring-cloud/labs-spring-cloud-service-user/client.xml /data/dockerfile/labs-spring-cloud-service-user
\cp -f /root/labs-spring-cloud/labs-spring-cloud-service-user/Dockerfile /data/dockerfile/labs-spring-cloud-service-user
\cp -f /root/labs-spring-cloud/labs-spring-cloud-service-user/target/labs-spring-cloud-service-user.jar /data/dockerfile/labs-spring-cloud-service-user
docker build -t xpanda/labs-spring-cloud-service-user:latest .

mkdir -p /data/dockerfile/labs-spring-cloud-service-envoy
cd /data/dockerfile/labs-spring-cloud-service-envoy
\cp -f /root/labs-spring-cloud/labs-spring-cloud-service-envoy/client.xml /data/dockerfile/labs-spring-cloud-service-envoy
\cp -f /root/labs-spring-cloud/labs-spring-cloud-service-envoy/Dockerfile /data/dockerfile/labs-spring-cloud-service-envoy
\cp -f /root/labs-spring-cloud/labs-spring-cloud-service-envoy/target/labs-spring-cloud-service-envoy.jar /data/dockerfile/labs-spring-cloud-service-envoy
docker build -t xpanda/labs-spring-cloud-service-envoy:latest .

mkdir -p /data/dockerfile/labs-spring-cloud-service-xds
cd /data/dockerfile/labs-spring-cloud-service-xds
\cp -f /root/labs-spring-cloud/labs-spring-cloud-service-xds/client.xml /data/dockerfile/labs-spring-cloud-service-xds
\cp -f /root/labs-spring-cloud/labs-spring-cloud-service-xds/Dockerfile /data/dockerfile/labs-spring-cloud-service-xds
\cp -f /root/labs-spring-cloud/labs-spring-cloud-service-xds/target/labs-spring-cloud-service-xds.jar /data/dockerfile/labs-spring-cloud-service-xds
docker build -t xpanda/labs-spring-cloud-service-xds:latest .

docker build -t xpanda/envoy:latest .


docker run -d --net host --name labs-spring-cloud-registry xpanda/labs-spring-cloud-registry:latest
docker run -d --net host --name labs-spring-cloud-service-system --add-host labs-spring-cloud-registry:10.0.2.15 xpanda/labs-spring-cloud-service-system:latest
docker run -d --net host --name labs-spring-cloud-service-user --add-host labs-spring-cloud-registry:10.0.2.15 xpanda/labs-spring-cloud-service-user:latest
docker run -d --net host --name labs-spring-cloud-service-envoy --add-host labs-spring-cloud-registry:10.0.2.15 xpanda/labs-spring-cloud-service-envoy:latest
docker run -d --net host --name labs-spring-cloud-service-xds --add-host labs-spring-cloud-registry:10.0.2.15 xpanda/labs-spring-cloud-service-xds:latest
docker run -d --net host --name envoy --add-host labs-spring-cloud-registry:10.0.2.15 xpanda/envoy:latest