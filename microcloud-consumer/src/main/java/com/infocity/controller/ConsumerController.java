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
  /*
  public static final String PRODUCT_GET_URL = "http://localhost:8080/product/get/";
  public static final String PRODUCT_LIST_URL = "http://localhost:8080/product/list";
  public static final String PRODUCT_ADD_URL = "http://localhost:8080/product/add";
  */

  public static final String PRODUCT_GET_URL = "http://MICROCLOUD-PROVIDER-PRODUCT/product/get/";
  public static final String PRODUCT_LIST_URL = "http://MICROCLOUD-PROVIDER-PRODUCT/product/list";
  public static final String PRODUCT_ADD_URL = "http://MICROCLOUD-PROVIDER-PRODUCT/product/add";

  @Resource private RestTemplate restTemplate;

  @Resource private HttpHeaders httpHeaders;

  @Resource private LoadBalancerClient LoadBalancerClient;

  @RequestMapping("/get")
  public Object get(long id) {
    //        Product product = restTemplate.getForObject(PRODUCT_GET_URL + id, Product.class);
    Product product =
        restTemplate
            .exchange(
                PRODUCT_GET_URL + id, HttpMethod.GET, new HttpEntity(httpHeaders), Product.class)
            .getBody();
    return product;
  }

  @RequestMapping("/list")
  public Object list() {
    // 消费者获取服务提供者信息
    ServiceInstance serviceInstance =
            LoadBalancerClient.choose("MICROCLOUD-PROVIDER-PRODUCT");
    logger.info("\n{***ServiceInstance***} Host" + serviceInstance.getHost()
    +", Post:"+serviceInstance.getPort()+
    ", ServiceId:"+serviceInstance.getServiceId());

    //        List<Product> list = restTemplate.getForObject(PRODUCT_LIST_URL, List.class);
    List<Product> list =
        restTemplate
            .exchange(
                PRODUCT_LIST_URL,
                HttpMethod.GET,
                new HttpEntity<Object>(null, httpHeaders),
                List.class)
            .getBody();
    return list;
  }

  @RequestMapping(value = "/add")
  public Object add(Product product) {
    //    Boolean result = restTemplate.postForObject(PRODUCT_ADD_URL, product, Boolean.class);
    Boolean result =
        restTemplate
            .exchange(
                PRODUCT_ADD_URL,
                HttpMethod.POST,
                new HttpEntity(product, httpHeaders),
                Boolean.class)
            .getBody();
    return result;
  }
}
