package com.xhp.scm.service.impl;

import com.xhp.scm.entity.Dept;
import com.xhp.scm.mapper.DeptMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * Created by xhp on 2016/9/30.
 */

public class DeptImpl {

    @Autowired
    private DeptMapper deptMapper;

    @Resource
    private SqlSessionTemplate sqlSessionTemplate;


    public Dept selectDept(Integer deptId) {
        Dept dept=	sqlSessionTemplate.selectOne("com.xhp.scm.mapper.DeptMapper.selectDept", deptId);
        return dept;

    }

    public int insertDept(Dept dept){
        return sqlSessionTemplate.insert(DeptMapper.class+".insertDept",dept);
    }
}
