package com.gizwits.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by feel on 2016/11/15.
 */
@Component
public class DataPointServiceHystrix implements DataPointService {
    @Override
    public String getDatapoint(@RequestParam(value = "product_key") String product_key) {


        return "Wait a moment  for  timeout  ";
    }
}
