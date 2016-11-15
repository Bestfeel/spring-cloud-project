package com.gizwits.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by feel on 2016/11/15.
 */
@FeignClient(value = "ZkServer", fallback = DataPointServiceHystrix.class)
public interface DataPointService {

    @RequestMapping(value = "/datapoint", method = RequestMethod.GET)
    String getDatapoint(@RequestParam(value = "product_key") String product_key);
}
