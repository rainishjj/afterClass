package com.rainish.api.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author jiajiao
 * @Date 2019/7/22 15:15
 */
@Configuration
@EnableDubbo
@PropertySource("classpath:/dubbo-provider.properties")
public class ProviderConfiguration {
}
