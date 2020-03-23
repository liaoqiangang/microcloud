package com.infocity.mapper;

import com.infocity.vo.Product;

import java.util.List;

/**
 * @author liaoqiangang
 * @date 2020/3/17 3:49 PM
 * @desc
 * @lastModifier
 * @lastModifyTime
 */
public interface ProductMapper {

  boolean create(Product product);

  public Product findById(Long id);

  public List<Product> findAll();
}
