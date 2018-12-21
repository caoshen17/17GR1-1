package com.dao;

public interface OrderDao {

	//插入订单
	public void cr_Order(String id,String name,String dizi,String date,Float cost,int status,int type,String serilNumber);
	
	//插入订单具体信息
	public void cr_Order_detail(int orderId,int productId,int quantity,float cost);
	
}
