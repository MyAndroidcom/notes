package com.xhp.scm.mapper;

import com.xhp.scm.entity.Dept;

/**
 * Created by xhp on 2016/9/30.
 */
public interface DeptMapper extends BaseMapper<Dept>{

    public Dept selectDept(Integer deptId);

    public int insertDept(Dept dept);
}
