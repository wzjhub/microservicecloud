package com.wzj.springcloud.service.impl;

import com.wzj.springcloud.dao.DeptDao;
import com.wzj.springcloud.entities.Dept;
import com.wzj.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    DeptDao deptDao;

    @Override
    public boolean add(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept get(Integer id) {
        return deptDao.findById(id);
    }

    @Override
    public List<Dept> list() {
        return deptDao.findAll();
    }
}
