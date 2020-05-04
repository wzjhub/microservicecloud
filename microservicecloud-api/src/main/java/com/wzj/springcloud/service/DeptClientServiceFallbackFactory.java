package com.wzj.springcloud.service;

import com.wzj.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

//在这个类上新增@Component注解,否则不生效。服务降级
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService(){

            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(Integer id) {
               return new Dept().setId(id).setDname("该ID：" + id + "没有对应的信息,consumer客户端提供的降级信息，此刻服务provider关闭")
                        .setDb_source("no this database in mysql");
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };

    }
}
