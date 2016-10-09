package com.xhp.scm.service;


import com.xhp.scm.entity.Supplier;

import java.util.List;
import java.util.Map;

public interface SupplierService extends BaseService<Supplier> {

    List<Map<String, Object>> selectSupplier(Map<String,String> paramMap);

}
