package com.infocity.controller;

import com.infocity.vo.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author liaoqiangang
 * @date 2020/3/17 5:19 PM
 * @desc
 * @lastModifier
 * @lastModifyTime
 */
@RestController
@RequestMapping("consumer")
public class ConsumerController {

  private Logger logger = LoggerFactory.getLogger(ConsumerController.class);

  public static final String PRODUCT_TOPIC = "MICROCLOUD-PROVIDER-PRODUCT";

  @Resource private RestTemplate restTemplate;

  @Resource private HttpHeaders httpHeaders;

  @Resource private LoadBalancerClient LoadBalancerClient;


  @RequestMapping("/list")
  public Object list() {
    // 消费者获取服务提供者信息
    ServiceInstance serviceInstance =
            LoadBalancerClient.choose(PRODUCT_TOPIC);
    logger.info("\n{***ServiceInstance***} Host" + serviceInstance.getHost()
    +", Post:"+serviceInstance.getPort()+
    ", ServiceId:"+serviceInstance.getServiceId());
    URI uri = URI.create(String.format("http://%s:%s/product/list/",serviceInstance.getHost(),serviceInstance.getPort()));
    List<Product> list =
        restTemplate
            .exchange(uri, HttpMethod.GET, new HttpEntity<Object>(null, httpHeaders), List.class)
            .getBody();
    return list;
  }
}
