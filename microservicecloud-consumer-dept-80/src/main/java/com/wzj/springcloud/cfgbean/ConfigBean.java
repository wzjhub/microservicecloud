package com.wzj.springcloud.cfgbean;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration  // @Configuration = applicationContext.xml
public class ConfigBean {

    @Bean
    @LoadBalanced  //开启负载均衡（客户端）
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public IRule myRule(){
        return new RandomRule(); //用选择的随机算法替代默认的轮询
        //return new RetryRule();
        //return new RoundRobinRule();
    }

}
