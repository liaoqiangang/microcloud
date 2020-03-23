package com.infocity.service;

import com.infocity.vo.Product;

import java.util.List;

/**
 * @author liaoqiangang
 * @date 2020/3/17 4:30 PM
 * @desc
 * @lastModifier
 * @lastModifyTime
 */
public interface IProductService {

  public Product get(long id);

  public boolean add(Product product);

  public List<Product> list();
}
