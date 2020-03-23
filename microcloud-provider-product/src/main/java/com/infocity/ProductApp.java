package com.infocity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author liaoqiangang
 * @date 2020/3/17 4:34 PM
 * @desc
 * @lastModifier
 * @lastModifyTime
 */
@SpringBootApplication
@MapperScan("com.infocity.mapper")
@EnableAutoConfiguration
@EnableEurekaClient
@EnableDiscoveryClient
public class ProductApp {

  public static void main(String[] args) {
    SpringApplication.run(ProductApp.class);
  }
}
