package com.gizwits.registry;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.CloseableUtils;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.apache.curator.x.discovery.ServiceInstanceBuilder;
import org.apache.curator.x.discovery.details.JsonInstanceSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by feel on 2016/11/15.
 */
@Component
public class ServiceRegistryImpl implements ServiceRegistry {

    private CuratorFramework client;

    @Value("${spring.zk.host}")
    private String zkHost;

    @PostConstruct
    public void init() {
        System.out.println(" init  method  using  @PostConstrut....");
        client = CuratorFrameworkFactory.newClient(zkHost, new ExponentialBackoffRetry(1000, 3));
        client.start();
        try {
            client.blockUntilConnected();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @PreDestroy
    public void dostory() {
        System.out.println("  destory method  using  @PreDestroy.....");
    }

    @Override
    public void register(ServiceInstanceBuilder<ServiceDetail> register) {
        ServiceInstance<ServiceDetail> instance = register.build();

        ServiceDiscovery<ServiceDetail> serviceDiscovery = ServiceDiscoveryBuilder.builder(ServiceDetail.class)
                .client(client)
                .serializer(new JsonInstanceSerializer<ServiceDetail>(ServiceDetail.class))
                .basePath(ServiceDetail.REGISTER_ROOT_PATH)
                .build();
        //服务注册
        try {
            serviceDiscovery.registerService(instance);
            serviceDiscovery.start();
            Thread.sleep(Integer.MAX_VALUE * 1000L);
        } catch (Exception e) {

            CloseableUtils.closeQuietly(serviceDiscovery);
            CloseableUtils.closeQuietly(client);

            e.printStackTrace();

        }


    }
}
