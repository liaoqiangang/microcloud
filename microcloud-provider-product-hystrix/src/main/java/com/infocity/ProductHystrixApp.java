package com.infocity;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @author liaoqiangang
 * @date 2020/3/17 4:34 PM
 * @desc
 * @lastModifier
 * @lastModifyTime
 */
@SpringBootApplication
@MapperScan("com.infocity.mapper")
@EnableEurekaClient
@EnableDiscoveryClient
@EnableCircuitBreaker // 断路器启动
public class ProductHystrixApp {

  public static void main(String[] args) {
    SpringApplication.run(ProductHystrixApp.class);
  }


  /**
   * 解决  actoutor/hystrix.stream   404
   * @return
   */
  @Bean
  public ServletRegistrationBean getServlet() {
    HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
    ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
    registrationBean.setLoadOnStartup(1);
    registrationBean.addUrlMappings("/actuator/hystrix.stream");
    registrationBean.setName("HystrixMetricsStreamServlet");
    return registrationBean;
  }
}
