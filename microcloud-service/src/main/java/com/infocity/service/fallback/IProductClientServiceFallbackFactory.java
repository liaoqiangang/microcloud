package com.infocity.service.fallback;

import com.infocity.service.IProductClientService;
import com.infocity.vo.Product;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author liaoqiangang
 * @date 2020/3/22 9:50 PM
 * @desc
 * @lastModifier
 * @lastModifyTime
 **/
@Component
public class IProductClientServiceFallbackFactory implements FallbackFactory<IProductClientService> {
    @Override
    public IProductClientService create(Throwable throwable) {
        return new IProductClientService() {
            @Override
            public Product getProduct(long id) {
                Product product = new Product();
                product.setProductId(999999L);
                product.setProductName("feign-hystrixName");
                product.setProductDesc("feign-hystrixDesc");
                return product;
            }

            @Override
            public List<Product> listProduct() {
                return null;
            }

            @Override
            public boolean add(Product product) {
                return false;
            }
        };
    }
}
