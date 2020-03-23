package com.infocity.service.impl;

import com.infocity.mapper.ProductMapper;
import com.infocity.service.IProductService;
import com.infocity.vo.Product;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liaoqiangang
 * @date 2020/3/17 4:32 PM
 * @desc
 * @lastModifier
 * @lastModifyTime
 */
@Service
public class ProductServiceImpl implements IProductService {

  @Resource private ProductMapper productMapper;

  @Override
  public Product get(long id) {
    return productMapper.findById(id);
  }

  @Override
  public boolean add(Product product) {

    return productMapper.create(product);
  }

  @Override
  public List<Product> list() {
    return productMapper.findAll();
  }
}
