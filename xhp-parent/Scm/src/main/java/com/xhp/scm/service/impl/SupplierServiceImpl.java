package com.xhp.scm.service.impl;

import com.xhp.scm.entity.Page;
import com.xhp.scm.entity.Supplier;
import com.xhp.scm.mapper.SupplierMapper;
import com.xhp.scm.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("supplierService")
public class SupplierServiceImpl implements SupplierService {
	
	@Autowired
	private SupplierMapper supplierMapper;

	@Override
	public Integer insert(Supplier supplier) throws Exception {
		// TODO Auto-generated method stub
		return supplierMapper.insert(supplier);
	}

	@Override
	public int update(Supplier supplier) throws Exception {
		// TODO Auto-generated method stub
		return supplierMapper.update(supplier);
	}

	@Override
	public int delete(Supplier entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	//通过主键批量删除
	@Override
	public int deleteList(String[] pks){
		return supplierMapper.deleteList(pks);
	}

	@Override
	public Supplier select(Supplier entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Supplier> selectPage(Page<Supplier> page) {
		// TODO Auto-generated method stub
		page.setList(supplierMapper.selectPageList(page));
		page.setTotal(supplierMapper.selectPageCount(page));
		return page;
	}

	@Override
	public Page<Supplier> selectPageUseDyc(Page<Supplier> page) {
		// TODO Auto-generated method stub
		page.setList(supplierMapper.selectPageListUseDyc(page));
		page.setTotal(supplierMapper.selectPageCountUseDyc(page));
		return page;
	}


	@Override
	public List<Map<String, Object>> selectSupplier(Map<String, String> paramMap) {
		return supplierMapper.selectSupplier(paramMap);
	}
}
