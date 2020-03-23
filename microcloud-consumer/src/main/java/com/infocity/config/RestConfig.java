package com.infocity.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * @author liaoqiangang
 * @date 2020/3/17 5:18 PM
 * @desc
 * @lastModifier
 * @lastModifyTime
 */
@Configuration
public class RestConfig {

  /**
   * LoadBalanced ribbon 负载均衡 默认轮询
   *
   * @return
   */
  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  public HttpHeaders getHttpHeaders() { // 要进行一个http头信息配置
    // 定义一个http的头信息
    HttpHeaders headers = new HttpHeaders();
    // 认证的原始信息
    String auth = "admin:admin";
    // 进行一个加密的处理
    byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));
    String authHeader = "Basic " + new String(encodedAuth);
    headers.set("authorization", authHeader);
    return headers;
  }

  /**
   * 其中 IRule就是所有规则的标准
   *
   * @return
   */
  /*@Bean
  public IRule ribbonRule() {
    // 随机的访问策略
    return new RandomRule();
  }*/


}
