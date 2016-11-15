package com.gizwits.registry;

import org.apache.curator.x.discovery.ServiceInstanceBuilder;

/**
 * Created by feel on 2016/11/15.
 * <p>
 * 服务注册接口
 */
public interface ServiceRegistry {

    /**
     * 服务注册信息
     *
     * @param register
     */
    void register(ServiceInstanceBuilder<ServiceDetail> register);

}
