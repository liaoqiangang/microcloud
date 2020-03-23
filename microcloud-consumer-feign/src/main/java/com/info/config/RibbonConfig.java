package com.info.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

/**
 * @author liaoqiangang
 * @date 2020/3/21 11:28 PM
 * @desc
 * @lastModifier
 * @lastModifyTime
 **/
public class RibbonConfig {

    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }
}
