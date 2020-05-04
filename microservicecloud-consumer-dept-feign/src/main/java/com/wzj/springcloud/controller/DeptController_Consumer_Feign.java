package com.wzj.springcloud.controller;

import com.wzj.springcloud.entities.Dept;
import com.wzj.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController_Consumer_Feign {

    @Autowired
    private DeptClientService deptClientService;

    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return deptClientService.add(dept);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Integer id){
        return deptClientService.get(id);
    }


    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return deptClientService.list();
    }


}
