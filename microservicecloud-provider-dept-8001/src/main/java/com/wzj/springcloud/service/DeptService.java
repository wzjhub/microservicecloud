package com.wzj.springcloud.service;

import com.wzj.springcloud.entities.Dept;

import java.util.List;

public interface DeptService {

    public boolean add(Dept dept);

    public Dept get(Integer id);

    public List<Dept> list();
}
