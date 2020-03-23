package com.infocity;

import com.info.config.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author liaoqiangang
 * @date 2020/3/17 5:26 PM
 * @desc
 * @lastModifier
 * @lastModifyTime
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "MICROCLOUD-PROVIDER-PRODUCT",configuration = RibbonConfig.class)
public class ConsumerApp {
  public static void main(String[] args) {
    SpringApplication.run(ConsumerApp.class);
  }
}
