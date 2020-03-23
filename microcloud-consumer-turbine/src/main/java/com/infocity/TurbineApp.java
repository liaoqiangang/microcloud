package com.infocity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author liaoqiangang
 * @date 2020/3/22 11:18 PM
 * @desc
 * @lastModifier
 * @lastModifyTime
 **/
@SpringBootApplication
@EnableTurbine
public class TurbineApp {

  public static void main(String[] args) {
      SpringApplication.run(TurbineApp.class);
  }
}
