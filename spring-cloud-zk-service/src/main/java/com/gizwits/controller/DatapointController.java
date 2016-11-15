package com.gizwits.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by feel on 2016/11/15.
 */
@RestController
public class DatapointController {
    private final Logger logger = Logger.getLogger(getClass());
    @Autowired
    private DiscoveryClient client;

    /**
     * curl http://localhost:9001/datapoint?product_key="pk"
     *
     * @param product_key
     * @return
     */
    @RequestMapping(value = "/datapoint", method = RequestMethod.GET)
    public String getDatapoint(@RequestParam String product_key) {

        ServiceInstance instance = client.getLocalServiceInstance();

        logger.info("/datapoint, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());

        return "{\"name\":\"test\",\"packetVersion\":\"0x00000004\",\"protocolType\":\"standard\",\"product_key\":\"763434ad2464ddfdaf9b9dd052ec9950c\",\"entities\":[{\"display_name\":\"机智云开发套件\",\"attrs\":[{\"display_name\":\"开关\",\"name\":\"Switch\",\"data_type\":\"bool\",\"position\":{\"byte_offset\":0,\"unit\":\"bit\",\"len\":1,\"bit_offset\":0},\"type\":\"status_writable\",\"id\":0,\"desc\":\".....\"},{\"display_name\":\"儿童安全锁\",\"name\":\"Child_Security_Lock\",\"data_type\":\"bool\",\"position\":{\"byte_offset\":0,\"unit\":\"bit\",\"len\":1,\"bit_offset\":3},\"type\":\"status_writable\",\"id\":3,\"desc\":\".....\"},{\"display_name\":\"风速\",\"name\":\"Wind_Velocity\",\"data_type\":\"enum\",\"enum\":[\"强力\",\"标准\",\"睡眠\",\"智能\"],\"position\":{\"byte_offset\":0,\"unit\":\"bit\",\"len\":2,\"bit_offset\":4},\"type\":\"status_writable\",\"id\":4,\"desc\":\".....\"},{\"display_name\":\"空气检测灵敏度\",\"name\":\"Air_Sensitivity\",\"data_type\":\"enum\",\"enum\":[\"0\",\"1\",\"2\",\"3\",\"4\"],\"position\":{\"byte_offset\":0,\"unit\":\"bit\",\"len\":3,\"bit_offset\":6},\"type\":\"status_writable\",\"id\":5,\"desc\":\".....\"},{\"display_name\":\"滤网寿命\",\"name\":\"Filter_Life\",\"data_type\":\"uint8\",\"position\":{\"byte_offset\":2,\"unit\":\"byte\",\"len\":1,\"bit_offset\":0},\"uint_spec\":{\"addition\":0,\"max\":100,\"ratio\":1,\"min\":0},\"type\":\"status_writable\",\"id\":6,\"desc\":\".....\"},{\"display_name\":\"按周重复\",\"name\":\"Week_Repeat\",\"data_type\":\"uint8\",\"position\":{\"byte_offset\":3,\"unit\":\"byte\",\"len\":1,\"bit_offset\":0},\"uint_spec\":{\"addition\":0,\"max\":255,\"ratio\":1,\"min\":0},\"type\":\"status_writable\",\"id\":7,\"desc\":\".....\"},{\"display_name\":\"倒计时开机\",\"name\":\"CountDown_On_min\",\"data_type\":\"uint16\",\"position\":{\"byte_offset\":4,\"unit\":\"byte\",\"len\":2,\"bit_offset\":0},\"uint_spec\":{\"addition\":0,\"max\":1440,\"ratio\":1,\"min\":0},\"type\":\"status_writable\",\"id\":8,\"desc\":\".....\"},{\"display_name\":\"倒计时关机\",\"name\":\"CountDown_Off_min\",\"data_type\":\"uint16\",\"position\":{\"byte_offset\":6,\"unit\":\"byte\",\"len\":2,\"bit_offset\":0},\"uint_spec\":{\"addition\":0,\"max\":1440,\"ratio\":1,\"min\":0},\"type\":\"status_writable\",\"id\":9,\"desc\":\".....\"},{\"display_name\":\"定时开机\",\"name\":\"Timing_On\",\"data_type\":\"uint16\",\"position\":{\"byte_offset\":8,\"unit\":\"byte\",\"len\":2,\"bit_offset\":0},\"uint_spec\":{\"addition\":0,\"max\":1440,\"ratio\":1,\"min\":0},\"type\":\"status_writable\",\"id\":10,\"desc\":\".....\"},{\"display_name\":\"定时关机\",\"name\":\"Timing_Off\",\"data_type\":\"uint16\",\"position\":{\"byte_offset\":10,\"unit\":\"byte\",\"len\":2,\"bit_offset\":0},\"uint_spec\":{\"addition\":0,\"max\":1440,\"ratio\":1,\"min\":0},\"type\":\"status_writable\",\"id\":11,\"desc\":\".....\"},{\"display_name\":\"空气质量\",\"name\":\"Air_Quality\",\"data_type\":\"enum\",\"enum\":[\"优\",\"良\",\"中\",\"差\"],\"position\":{\"byte_offset\":12,\"unit\":\"bit\",\"len\":2,\"bit_offset\":0},\"type\":\"status_readonly\",\"id\":12,\"desc\":\".....\"},{\"display_name\":\"空气质量_粉尘\",\"name\":\"Dust_Air_Quality\",\"data_type\":\"uint8\",\"position\":{\"byte_offset\":13,\"unit\":\"byte\",\"len\":1,\"bit_offset\":0},\"uint_spec\":{\"addition\":0,\"max\":255,\"ratio\":1,\"min\":0},\"type\":\"status_readonly\",\"id\":13,\"desc\":\".....\"},{\"display_name\":\"空气质量_异味\",\"name\":\"Peculiar_Air_Quality\",\"data_type\":\"uint8\",\"position\":{\"byte_offset\":14,\"unit\":\"byte\",\"len\":1,\"bit_offset\":0},\"uint_spec\":{\"addition\":0,\"max\":255,\"ratio\":1,\"min\":0},\"type\":\"status_readonly\",\"id\":14,\"desc\":\".....\"},{\"display_name\":\"滤芯寿命报警\",\"name\":\"Alert_Filter_Life\",\"data_type\":\"bool\",\"position\":{\"byte_offset\":15,\"unit\":\"bit\",\"len\":1,\"bit_offset\":0},\"type\":\"alert\",\"id\":15,\"desc\":\".....\"},{\"display_name\":\"空气质量警报\",\"name\":\"Alert_Air_Quality\",\"data_type\":\"bool\",\"position\":{\"byte_offset\":15,\"unit\":\"bit\",\"len\":1,\"bit_offset\":1},\"type\":\"alert\",\"id\":16,\"desc\":\".....\"},{\"display_name\":\"电机故障\",\"name\":\"Fault_Motor\",\"data_type\":\"bool\",\"position\":{\"byte_offset\":16,\"unit\":\"bit\",\"len\":1,\"bit_offset\":0},\"type\":\"fault\",\"id\":17,\"desc\":\".....\"},{\"display_name\":\"空气传感器故障\",\"name\":\"Fault_Air_Sensors\",\"data_type\":\"bool\",\"position\":{\"byte_offset\":16,\"unit\":\"bit\",\"len\":1,\"bit_offset\":1},\"type\":\"fault\",\"id\":18,\"desc\":\".....\"},{\"display_name\":\"灰尘传感器故障\",\"name\":\"Fault_Dust_Sensor\",\"data_type\":\"bool\",\"position\":{\"byte_offset\":16,\"unit\":\"bit\",\"len\":1,\"bit_offset\":2},\"type\":\"fault\",\"id\":19,\"desc\":\".....\"}],\"name\":\"entity0\",\"id\":0}]}";
    }
}
