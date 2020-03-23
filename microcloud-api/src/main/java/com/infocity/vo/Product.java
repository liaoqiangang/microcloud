package com.infocity.vo;

import java.io.Serializable;

/**
 * @author liaoqiangang
 * @date 2020/3/17 3:28 PM
 * @desc
 * @lastModifier
 * @lastModifyTime
 */
public class Product implements Serializable {

  private long productId;

  private String productName;

  private String productDesc;

  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getProductDesc() {
    return productDesc;
  }

  public void setProductDesc(String productDesc) {
    this.productDesc = productDesc;
  }

  @Override
  public String toString() {
    return "Product{"
        + "productId="
        + productId
        + ", productName='"
        + productName
        + '\''
        + ", productDesc='"
        + productDesc
        + '\''
        + '}';
  }
}
