package com.gizwits.registry;

/**
 * Created by feel on 2016/11/15.
 * zk  阶段存储的相关信息
 */
public class ServiceDetail {

    //服务注册的根路径
    public static final String REGISTER_ROOT_PATH = "/zkservices";

    private String desc;

    public ServiceDetail() {
    }


    public ServiceDetail(String desc) {
        this.desc = desc;
    }

    public static String getRegisterRootPath() {
        return REGISTER_ROOT_PATH;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "ServiceDetail{" +
                "desc='" + desc + '\'' +
                '}';
    }
}
