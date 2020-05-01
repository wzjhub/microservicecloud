package com.wzj.springcloud.entities;


import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class Dept implements Serializable {

    private Integer id;
    private String dname;
    private String db_source;

    public static void main(String[] args) {
        Dept dept = new Dept();
        dept.setId(1).setDname("wzj").setDb_source("mysql");
        System.out.println(dept);
    }
}
