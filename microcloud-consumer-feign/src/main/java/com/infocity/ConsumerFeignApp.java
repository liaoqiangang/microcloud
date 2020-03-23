package com.infocity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author liaoqiangang
 * @date 2020/3/17 5:26 PM
 * @desc
 * @lastModifier
 * @lastModifyTime
 */
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "MICROCLOUD-PROVIDER-PRODUCT",configuration = RibbonConfig.class)
@EnableFeignClients("com.infocity.service")
public class ConsumerFeignApp {
  public static void main(String[] args) {
    SpringApplication.run(ConsumerFeignApp.class);
  }
}
