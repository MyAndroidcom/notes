package com.xhp.scm.mapper;


import com.xhp.scm.entity.Supplier;

import java.util.List;
import java.util.Map;

public interface SupplierMapper extends BaseMapper<Supplier> {

    List<Map<String, Object>> selectSupplier(Map<String, String> paramMap);
}