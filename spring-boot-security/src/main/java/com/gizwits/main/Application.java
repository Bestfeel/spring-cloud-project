package com.gizwits.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(value = "com.gizwits")
@EnableAuthorizationServer
@EnableGlobalMethodSecurity
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

//    /**
//     * 错误页面需要放在Spring Boot web应用的static内容目录下，
//     * 它的默认位置是：src/main/resources/static
//     *
//     * @return
//     */
//    @Bean
//    public EmbeddedServletContainerCustomizer containerCustomizer() {
//
//        return new EmbeddedServletContainerCustomizer() {
//            @Override
//            public void customize(ConfigurableEmbeddedServletContainer container) {
//
//                ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/index.html");
//                ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/index.html");
//                ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/index.html");
//                ErrorPage error405Page = new ErrorPage(HttpStatus.METHOD_NOT_ALLOWED, "/index.html");
//
//                container.addErrorPages(error401Page, error404Page, error500Page, error405Page);
//            }
//        };
//    }

    public static void main(String[] args) throws Exception {

        //开启监控 http://localhost:8080/health

        SpringApplication.run(Application.class, args);

    }
}