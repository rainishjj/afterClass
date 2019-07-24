package com.rainish.api;

import org.apache.dubbo.container.Main;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author jiajiao
 * @Date 2019/7/24 10:32
 * 记住 dubbo不依赖spring-boot
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.rainish.api.provider")
public class ProviderApplication {
    /**
     * spring boot启动可以访问
     * @param args
     */
//    public static void main(String[] args) {
//        SpringApplication.run(ProviderApplication.class,args);
//    }

    /**
     * 这样居然不能访问，为什么
     * @param args
     */
    public static void main(String[] args) {
    Main.main(new String[]{"spring","log4j"});
}
}
