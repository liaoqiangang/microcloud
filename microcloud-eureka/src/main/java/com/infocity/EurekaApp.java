package com.infocity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author liaoqiangang
 * @date 2020/3/19 4:11 PM
 * @desc    启用eureka服务（代表我是个注册中心），以springboot的项目启动
 * @lastModifier
 * @lastModifyTime
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaApp {

  public static void main(String[] args) {
      SpringApplication.run(EurekaApp.class);
  }
}
