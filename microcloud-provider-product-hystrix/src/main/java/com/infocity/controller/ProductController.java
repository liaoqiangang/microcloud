package com.infocity.controller;

import com.infocity.service.IProductService;
import com.infocity.vo.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liaoqiangang
 * @date 2020/3/17 4:36 PM
 * @desc
 * @lastModifier
 * @lastModifyTime
 */
@RestController
@RequestMapping("/product")
public class ProductController {
  @Resource private IProductService iProductService;

  /**
   * 进行Eureka的发现服务 org.springframework.cloud.client.discovery.DiscoveryClient;
   * com.netflix.discovery.DiscoveryClient;
   */
  @Resource private DiscoveryClient discoveryClient;

  @RequestMapping("/get/{id}")
  @HystrixCommand(fallbackMethod = "getFallback")
  public Object get(@PathVariable("id") long id) {
    Product product = iProductService.get(id);
    if (product == null) {
      throw new RuntimeException("该产品已下架！");
    }
    return product;
  }

  /**
   * 进行服务的降级
   * @param id
   * @return
   */
  public Object getFallback(@PathVariable("id")long id){
    Product product = new Product();
    product.setProductName("HystrixName");
    product.setProductDesc("HystrixDesc");
    return product;

  }



  @RequestMapping(value = "/add")
  public Object add(@RequestBody Product product) {
    return iProductService.add(product);
  }

  @RequestMapping("/list")
  public Object list() {
    return iProductService.list();
  }

  @RequestMapping("/hello")
  public String hello() {
    return "Hello World";
  }

  @RequestMapping("/discover")
  public Object discover() {
    return this.discoveryClient;
  }
}
