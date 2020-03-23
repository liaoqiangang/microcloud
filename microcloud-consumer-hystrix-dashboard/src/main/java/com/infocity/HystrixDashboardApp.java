package com.infocity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author liaoqiangang
 * @date 2020/3/22 10:17 PM
 * @desc
 * @lastModifier
 * @lastModifyTime
 **/
@SpringBootApplication
@EnableHystrixDashboard //开启仪表盘
public class HystrixDashboardApp {

  public static void main(String[] args) {
      SpringApplication.run(HystrixDashboardApp.class);
  }
}
