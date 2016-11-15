package com.gizwits.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by feel on 2016/11/15.
 */
@SpringBootApplication(scanBasePackages = {"com.gizwits"})
public class ZkDiscoveryApplication {

    public static void main(String[] args) {

        SpringApplication.run(ZkDiscoveryApplication.class, args);
        // end main
    }
}
