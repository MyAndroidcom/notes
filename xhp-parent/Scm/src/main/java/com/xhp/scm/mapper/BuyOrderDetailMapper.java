package com.xhp.scm.mapper;


import com.xhp.scm.entity.BuyOrderDetail;

import java.util.List;

public interface BuyOrderDetailMapper extends BaseMapper<BuyOrderDetail> {
	public int insertList(List<BuyOrderDetail> buyOrderDetails);
}