package com.gizwits.controller;

import com.gizwits.bean.User;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by feel on 2016/10/18.
 */
@EnableSwagger2
@RestController
@Api(value = "api", description = "用户的一些操作信息", tags = {"user"})
@RequestMapping(value = "/user")
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    //  获取 classpath  环境变量（可获取application.properties 等信息）
    Environment env;

    @Autowired
    HelloController(Environment env) {
        this.env = env;
    }

    /**
     * curl -XGET   --insecure --user  guest:guest123  http://localhost:8080/user
     * authorizations 中的key 必须  在 SwaggerConfig   中有定义
     *
     * @return
     */
    @CrossOrigin
    @ApiOperation(value = "获取用户信息", notes = "测试接口详细描述", authorizations = {@Authorization("mykey")})
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "Authorization", value = "authorization header", required = true,
//                    dataType = "string", paramType = "header", defaultValue = "bearer")
//    })
    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
    public User getUser(@ApiParam(name = "name", required = true, value = "姓名")

                        @RequestParam(name = "name") String username) {
        //   curl
        logger.info("getUser  info ..... ");
        return new User("feel", 25);

    }

}
