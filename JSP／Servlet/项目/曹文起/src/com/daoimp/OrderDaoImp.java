package com.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.BaseDao;
import com.dao.OrderDao;
import com.entity.Order_detail;
import com.entity.Product_order_util;

public class OrderDaoImp extends BaseDao implements OrderDao{

	@Override
	public void cr_Order(String id, String name, String dizi, String date,
			Float cost, int status, int type, String serilNumber) {
		// TODO Auto-generated method stub
		Connection lianjie = super.lianjie();
		String sql="insert into easybuy_order values(null,?,?,?,?,?,?,?,?)";
		PreparedStatement pr=null;
		try {
			pr=lianjie.prepareStatement(sql);
			pr.setString(1, id);
			pr.setString(2, name);
			pr.setString(3, dizi);
			pr.setString(4, date);
			pr.setFloat(5, cost);
			pr.setInt(6, status);
			pr.setInt(7, type);
			pr.setString(8, serilNumber);
			pr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.guanbi(null, pr, lianjie);
	}

	@Override
	public void cr_Order_detail(int orderId, int productId, int quantity,
			float cost) {
		// TODO Auto-generated method stub
		Connection lianjie = super.lianjie();
		String sql="insert into easybuy_order_detail values(null,?,?,?,?)";
		PreparedStatement pr=null;
		try {
			pr=lianjie.prepareStatement(sql);
			pr.setInt(1, orderId);
			pr.setInt(1, productId);
			pr.setInt(1, quantity);
			pr.setFloat(1, cost);
			pr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.guanbi(null, pr, lianjie);
	}

	//根据name查询地址、金额、订单号
	public Product_order_util name_Select_Order(String name){
		Connection lianjie = super.lianjie();
		String sql="select userAddress,cost,serilNumber from easybuy_order where loginName=?";
		PreparedStatement pr=null;
		ResultSet re=null;
		Product_order_util p=new Product_order_util();
		try {
			pr=lianjie.prepareStatement(sql);
			pr.setString(1, name);
			re = pr.executeQuery();
			while(re.next()){
				p.setDizi(re.getString("userAddress"));
				p.setMoney(String.valueOf(re.getFloat("cost")));
				p.setDingdanhao(re.getString("serilNumber"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.guanbi(re, pr, lianjie);
		return p;
	}
	
	//根据订单查询订单详情
	public List<Order_detail> dingdan_Select_Xiangqing(String dingdanhao){
		ArrayList<Order_detail> list=new ArrayList();
		Connection lianjie = super.lianjie();
		String sql="select * from easybuy_order_detail where orderId=?";
		PreparedStatement pr=null;
		ResultSet re=null;
		try {
			pr=lianjie.prepareStatement(sql);
			pr.setString(1, dingdanhao);
			re=pr.executeQuery();
			while(re.next()){
				int int1 = re.getInt(1);
				int int2 = re.getInt(2);
				int int3 = re.getInt(3);
				int int4 = re.getInt(4);
				float float3 = re.getFloat(5);
				Order_detail o=new Order_detail(int1, int2, int3, int4, float3);
				list.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.guanbi(re, pr, lianjie);
		return list;
	}
	
	

}
