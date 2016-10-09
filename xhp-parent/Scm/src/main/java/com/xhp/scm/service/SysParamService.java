package com.xhp.scm.service;

import com.xhp.scm.entity.SysParam;

import java.util.Map;


public interface SysParamService extends BaseService<SysParam> {
    public Map<String,Object>selectList();
	 
}
