package com.wzj.springcloud.service;

import com.wzj.springcloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//Feign负载均衡
//@FeignClient(value = "MICROSERVICECLOUD-DEPT")
//服务降级
@FeignClient(value = "MICROSERVICECLOUD-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

    @RequestMapping("/dept/add")
    public boolean add(Dept dept);

    @RequestMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Integer id);

    @RequestMapping("/dept/list")
    public List<Dept> list();
}
