package com.wzj.springcloud.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wzj.springcloud.entities.Dept;
import com.wzj.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @RequestMapping("/add")
    public boolean add(@RequestBody Dept dept) {
        return deptService.add(dept);
    }

    @RequestMapping("/get/{id}")
    //调用出错，会自动调用fallbackMethod指定的方法,服务熔断
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Integer id) {
        Dept dept = deptService.get(id);
        if(null == dept){
            throw new RuntimeException("该ID：" + id + "没有对应的信息");
        }
        return dept;
    }

    public Dept processHystrix_Get(@PathVariable("id") Integer id){
        return new Dept().setId(id).setDname("该ID：" + id + "没有对应的信息,null--@HystrixCommand")
                .setDb_source("no this database in mysql");
    }

    @RequestMapping("/list")
    public List<Dept> list() {
        return deptService.list();
    }
}
