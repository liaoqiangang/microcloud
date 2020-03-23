package com.infocity.config;

import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liaoqiangang
 * @date 2020/3/22 11:18 AM
 * @desc
 * @lastModifier
 * @lastModifyTime
 **/
@Configuration
public class FeignClientConfig {

    /**
     * 设置访问权限的 用户名，密码
     * @return
     */
    @Bean
    public BasicAuthRequestInterceptor getBasicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor("admin","admin");
    }

    /**
     * 设置日志级别
     * @return
     */
    @Bean
    public Logger.Level getFeignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
