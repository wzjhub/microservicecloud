package com.wzj.springboot.dao;


import com.wzj.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptDao {

    public boolean addDept(Dept dept);

    public Dept findById(Integer id);

    public List<Dept> findAll();
}
