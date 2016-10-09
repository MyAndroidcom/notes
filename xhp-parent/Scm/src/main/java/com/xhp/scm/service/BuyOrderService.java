package com.xhp.scm.service;


import com.xhp.scm.entity.BuyOrder;

public interface BuyOrderService extends BaseService<BuyOrder> {
	
	public int insertBuyOrder(BuyOrder buyOrder) throws Exception;
	 
}
