package com.dao;

import java.util.List;

import com.entity.Product;
import com.entity.Product_category;

public interface ProductDao {

	//查询一级分类列表
	public List<Product_category> yiji_fenlei();
	
	//根据上级id查询父分类id为上级id分类的列表
	public List<Product_category> parentId_fenlei(int id);
	
	//根据三级id查询所属商品
	public List<Product> sjid_select(int id);
	
	//根据根据id查询商品
	public Product id_select_shangpin(int id);
}
