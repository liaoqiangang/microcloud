package com.infocity.service;

import com.infocity.config.FeignClientConfig;
import com.infocity.service.fallback.IProductClientServiceFallbackFactory;
import com.infocity.vo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author liaoqiangang
 * @date 2020/3/22 11:16 AM
 * @desc
 * @lastModifier
 * @lastModifyTime
 */
@FeignClient(name = "MICROCLOUD-PROVIDER-PRODUCT", configuration = FeignClientConfig.class,fallbackFactory = IProductClientServiceFallbackFactory.class)
public interface IProductClientService {

  @RequestMapping("/product/get/{id}")
  public Product getProduct(@PathVariable("id") long id);

  @RequestMapping("/product/list")
  public List<Product> listProduct();

  @RequestMapping("/product/add")
  public boolean add(Product product);
}
