package com.infocity.controller;

import com.infocity.service.IProductClientService;
import com.infocity.vo.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

  @Resource
  private IProductClientService iProductClientService;

  @RequestMapping("/get")
  public Object get(long id) {
    return iProductClientService.getProduct(id);
  }

  @RequestMapping("/list")
  public Object list() {
    return iProductClientService.listProduct();
  }

  @RequestMapping(value = "/add")
  public Object add(Product product) {
    return iProductClientService.add(product);
  }
}
