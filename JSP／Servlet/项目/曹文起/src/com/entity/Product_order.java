package com.entity;

public class Product_order {
	private String name;
	private String fileName;
	private int num;
	private String money;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "Product_order [name=" + name + ", fileName=" + fileName
				+ ", num=" + num + ", money=" + money + "]";
	}
	
	
	
	
}
