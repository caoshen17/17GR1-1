package com.entity;

import java.util.List;

public class Product_order_util {
	private String name;
	private String dingdanhao;
	private String dizi;
	private String money;
	private List<Product_order> list;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDingdanhao() {
		return dingdanhao;
	}

	public void setDingdanhao(String dingdanhao) {
		this.dingdanhao = dingdanhao;
	}

	public String getDizi() {
		return dizi;
	}

	public void setDizi(String dizi) {
		this.dizi = dizi;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public List<Product_order> getList() {
		return list;
	}

	public void setList(List<Product_order> list) {
		this.list = list;
	}

}
